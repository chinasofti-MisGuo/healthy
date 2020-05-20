package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.User;
import com.mongolia.model.vo.UserVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户管理api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/user")
public class MsUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public BaseResultVO getUserList(@Valid PageDTO pageDTO) {
        PageInfo<User> userPageInfo = userService.userList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(userPageInfo.getList(), UserVO.class);
        return new BackPageResultVO(userPageInfo.getTotal(), list);
    }

    @GetMapping("/search")
    public BaseResultVO searchUser(@Valid SearchDTO searchDTO) {
        PageInfo<User> userPageInfo = userService.userListBySearch(searchDTO);
        List<Object> list = VoFactory.doBackwardList(userPageInfo.getList(), UserVO.class);
        return new BackPageResultVO(userPageInfo.getTotal(), list);
    }

    @GetMapping("/audit")
    public BaseResultVO getAuditUserList(@Valid PageDTO pageDTO) {
        PageInfo<User> userPageInfo = userService.notAuditUserList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(userPageInfo.getList(), UserVO.class);
        return new BackPageResultVO(userPageInfo.getTotal(), list);
    }

    @GetMapping("/audit/search")
    public BaseResultVO auditUserBySearch(@Valid SearchDTO searchDTO) {
        PageInfo<User> userPageInfo = userService.auditUserListBySearch(searchDTO);
        List<Object> list = VoFactory.doBackwardList(userPageInfo.getList(), UserVO.class);
        return new BackPageResultVO(userPageInfo.getTotal(), list);
    }

    @PostMapping("/freeze")
    public BaseResultVO freezeUser(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = userService.freezeUser(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/freezeCom")
    public BaseResultVO freezeComment(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = userService.freezeComment(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/review")
    public BaseResultVO review(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = userService.reviewUser(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/del")
    public BaseResultVO deleteUser(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = userService.deleteUser(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }
}
