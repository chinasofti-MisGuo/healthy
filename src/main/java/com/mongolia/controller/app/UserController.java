package com.mongolia.controller.app;

import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.DatumDTO;
import com.mongolia.model.dto.UserDTO;
import com.mongolia.model.entity.Follow;
import com.mongolia.model.entity.Integral;
import com.mongolia.model.entity.User;
import com.mongolia.model.vo.FansVO;
import com.mongolia.model.vo.UserVO;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 用户相关api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public BaseResultVO personHomePage(@Valid BaseDataDTO dataDTO) {
        System.out.println();
        Map<String, Object> result = userService.personHomePageDetail(dataDTO);
        return new SuccessResultVO(result);
    }

    @GetMapping("/others")
    public BaseResultVO othersHomePage(@Valid BaseDataDTO dataDTO) {
        Map<String, Object> result = userService.othersHomePageDetail(dataDTO);
        return new SuccessResultVO(result);
    }

    @GetMapping("/fans")
    public BaseResultVO fansList(@Valid BaseDataDTO dataDTO) {
        List<Follow> fans = userService.getFans(dataDTO);
        List<Object> list = VoFactory.doBackwardList(fans, FansVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/collect")
    public BaseResultVO collectList(@Valid BaseDataDTO dataDTO) {
        List<Follow> collects = userService.getCollect(dataDTO);
        List<Object> list = VoFactory.doBackwardList(collects, FansVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/certInfo")
    public BaseResultVO getCertification(@Valid BaseDataDTO dataDTO) {
        Map<String, Object> result = userService.getCertification(dataDTO.getUid());
        return new SuccessResultVO(result);
    }

    @GetMapping("/integral")
    public BaseResultVO getIntegral(@Valid BaseDataDTO dataDTO) {
        List<Integral> list = userService.getUserIntegral(dataDTO);
        return new SuccessResultVO(list);
    }

    @PostMapping("/registered")
    public BaseResultVO userRegistered(@RequestBody @Valid UserDTO userDTO) {
        User user = userDTO.convertToUser();
        if (!StringUtils.equals(userDTO.getCode().toString(), "1234")) {
            throw new InformationErrorException("验证码错误");
        }
        boolean result = userService.registered(user);
        if (!result) {
            return new FailedResultVO();
        }
        return new SuccessResultVO(1);
    }

    @PostMapping("/login")
    public BaseResultVO login(@RequestBody @Valid UserDTO userDTO) {
        User user = userDTO.convertToUser();
        User result = userService.userLogin(user);
        UserVO userVO = new UserVO().convertTo(result);
        return new SuccessResultVO(userVO);
    }

    @PostMapping("/pwd")
    public BaseResultVO chPwd(@RequestBody @Valid UserDTO userDTO) {
        User user = userDTO.convertToUser();
        if (!StringUtils.equals(userDTO.getCode().toString(), "1234")) {
            throw new InformationErrorException("验证码错误");
        }
        boolean result = userService.changePwd(user);
        if (!result) {
            return new FailedResultVO();
        }
        return new SuccessResultVO(1);
    }

    @PostMapping("/quick")
    public BaseResultVO quickLogin(@RequestBody @Valid UserDTO userDTO) {
        User user = userDTO.convertToUser();
        if (!StringUtils.equals(userDTO.getCode().toString(), "1234")) {
            throw new InformationErrorException("验证码错误");
        }
        User result = userService.quickLogin(user);
        UserVO userVO = new UserVO().convertTo(result);
        return new SuccessResultVO(userVO);
    }

    @PostMapping("/cert")
    public BaseResultVO certification(@RequestBody UserDTO userDTO) {
        User user = userDTO.convertToUser();
        if (StringUtils.isEmpty(user.getFullname()) || StringUtils.isEmpty(user.getIdNumber())
                || StringUtils.isEmpty(user.getIdCardImg())) {
            throw new InformationErrorException("请求数据不完整");
        }
        boolean result = userService.certification(user);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/datum/edit")
    public BaseResultVO editDatum(@RequestBody @Valid DatumDTO datumDTO) throws Exception {
        User user = datumDTO.convertToUser();
        User result = userService.editDatum(user);
        UserVO userVO = new UserVO().convertTo(result);
        return new SuccessResultVO(userVO);
    }

    @PostMapping("/tag")
    public BaseResultVO userSelectTag(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = userService.selectTag(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/col")
    public BaseResultVO collectUser(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = userService.collectUser(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

}
