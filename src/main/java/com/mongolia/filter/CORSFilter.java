package com.mongolia.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 跨域拦截器
 *
 * @author Dong.w
 */
@Component
public class CORSFilter implements Filter {

    private String[] permitUrl;

    private final Logger log = LoggerFactory.getLogger(CORSFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("permitUrl");
        if (urls != null) {
            urls = urls.replaceAll("\\n", "").replaceAll("\\r", "").replaceAll("\\t", "");
        }

        if (urls != null && !"".equals(urls)) {
            permitUrl = urls.split(",");
        }

        if (permitUrl != null) {
            for (int i = 0; i < permitUrl.length; i++) {
                permitUrl[i] = permitUrl[i].trim();
            }
        }
        log.info(Arrays.toString(permitUrl));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        log.info("args[{}]", req.getDateHeader("object"));

        String myOrigin = req.getHeader("Origin");
        log.info("Origin ==> " + myOrigin);
        boolean isValid = true;
        for (String ip : permitUrl) {
            if (myOrigin != null && ip.equals(myOrigin)) {
                isValid = true;
                break;
            }
        }
        log.info("IP Address ==> " + req.getHeader("X-Forwarded-For"));
        log.info("IP Address ==> " + req.getRemoteAddr());
        log.info("Request Method ==> "+req.getMethod());
        log.info("Request Content Parameter ==> "+req.getParameter("content"));
        log.info("Request Content-Type ==> " +req.getHeader("Content-Type"));
        if (isValid) {
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setContentType("application/json;charset=UTF-8");
            resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            resp.setHeader("Access-Control-Max-Age", "0");
            resp.setHeader("Access-Control-Allow-Headers",
                    "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            resp.setHeader("XDomainRequestAllowed", "1");
            log.info("Interception and release");
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }

}
