package com.mongolia.component;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 短信验证码组件
 *
 * @author Dong.w
 */
@Component
public class SmsTemplate {

    private static Map<String, String> params = new HashMap<>();

    private final static int EXPIRED_TIME = 30 * 60;

    private static Map<String, Map<String, Long>> verificationCode = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        InputStream in = null;
        Properties properties = new Properties();
        try {
            in = new BufferedInputStream(SmsTemplate.class.getClassLoader().getResourceAsStream("properties/sms.properties"));
            properties.load(in);
            Set<Object> smsKey = properties.keySet();
            for(Object sms : smsKey){
                params.put((String) sms, properties.getProperty((String) sms));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean sendCode(String phone) {
        try {
            String sendCode = generateCode();
            params.put("mobile", phone);
            params.put("param", sendCode);
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("https://open.ucpaas.com/ol/sms/sendsms");
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(10000)
                    .setRedirectsEnabled(true).build();
            httpPost.setConfig(config);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(params);
            System.out.println(jsonObject.toString());
            HttpEntity httpEntity = new StringEntity(jsonObject.toString(), "UTF-8");
            httpPost.setEntity(httpEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            JSONObject result = JSONObject.parseObject(EntityUtils.toString(entity, "UTF-8"));
            if (StringUtils.equals(result.getString("code"),"000000")) {
                Map<String, Long> map = new HashMap<>(2);
                map.put("code", Long.valueOf(sendCode));
                map.put("time", System.currentTimeMillis());
                verificationCode.put(phone,map);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean verification(String phone, String code) {
        String verification = String.valueOf(verificationCode.get(phone).get("code"));
        if (StringUtils.equals(code, verification)) {
            verificationCode.remove(phone);
            return true;
        }
        return false;
    }

    public void clearExpiredCode() {
        for (Iterator<Map.Entry<String, Map<String, Long>>> iterator = verificationCode.entrySet().iterator();
             iterator.hasNext(); ) {
            Map.Entry entry = iterator.next();
            if (entry.getValue() instanceof Map) {
                Map<String, Long> value = (Map<String, Long>) entry.getValue();
                long time = (System.currentTimeMillis() - value.get("time")) / 1000;
                if (time > EXPIRED_TIME) {
                    iterator.remove();
                }
            }
        }
    }

    public String generateCode() {
        return RandomStringUtils.random(6, "1234567890");
    }

}