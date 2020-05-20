package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.ProblemDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Problem;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.ProblemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 常见问题相关Controller
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/problem")
public class MsProblemController {

    @Resource
    private ProblemService problemService;

    @GetMapping("/list")
    public BaseResultVO getList(@Valid PageDTO pageDTO) {
        PageInfo<Problem> resultList = problemService.getList(pageDTO);
        List list = VoFactory.doBackwardList(resultList.getList(), ProblemDTO.class);
        return new BackPageResultVO(resultList.getTotal(), list);
    }

    @PostMapping("/add")
    public BaseResultVO addProblem(@RequestBody @Valid ProblemDTO problemDTO) {
        Problem problem = problemDTO.convertTo();
        int result = problemService.addProblem(problem);
        if (result == 0) {
            return new FailedResultVO();
        } else {
            return new SuccessResultVO(result);
        }
    }

    @PostMapping("/edit")
    public BaseResultVO editProblem(@RequestBody ProblemDTO problemDTO) {
        Problem problem = problemDTO.convertTo();
        int result = problemService.editProblem(problem);
        if (result == 0) {
            return new FailedResultVO();
        } else {
            return new SuccessResultVO(result);
        }
    }

    @PostMapping("/del")
    public BaseResultVO delProblem(@RequestBody BaseDataDTO baseDataDTO) {
        int result = problemService.deleteProblem(baseDataDTO);
        if (result == 0) {
            return new FailedResultVO();
        } else {
            return new SuccessResultVO(result);
        }
    }

    @GetMapping("/search")
    public BaseResultVO searchProblem(@Valid SearchDTO searchDTO) {
        PageInfo<Problem> problemPageInfo = problemService.getSearchList(searchDTO);
        List list = VoFactory.doBackwardList(problemPageInfo.getList(), ProblemDTO.class);
        return new BackPageResultVO(problemPageInfo.getTotal(), list);
    }
}
