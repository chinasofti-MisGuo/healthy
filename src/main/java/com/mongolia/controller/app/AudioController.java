package com.mongolia.controller.app;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.CommentDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Audio;
import com.mongolia.model.entity.AudioDir;
import com.mongolia.model.entity.Comment;
import com.mongolia.model.vo.AudioDirVO;
import com.mongolia.model.vo.AudioVO;
import com.mongolia.model.vo.CommentVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.AudioService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 音频目录相关api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app/audio")
public class AudioController {

    @Resource
    private AudioService audioService;

    @GetMapping("/dir/list")
    public BaseResultVO getRecommendList(@Valid PageDTO pageDTO) {
        PageInfo<AudioDir> audioPageInfo = audioService.getRecommendList(pageDTO);
        List list = VoFactory.doBackwardList(audioPageInfo.getList(), AudioDirVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/dir/search")
    public BaseResultVO searchList(@Valid SearchDTO searchDTO) {
        PageInfo<AudioDir> pageInfo = audioService.getSearchList(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), AudioDirVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/class/{id}")
    public BaseResultVO getClassList(@Valid PageDTO pageDTO, @PathVariable("id") Integer id) {
        PageInfo<AudioDir> audioDirPageInfo = audioService.getClassList(pageDTO, id);
        List list = VoFactory.doBackwardList(audioDirPageInfo.getList(), AudioDirVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/list")
    public BaseResultVO getAudioList(@Valid PageDTO dataDTO) {
        PageInfo<Audio> audioPageInfo = audioService.getAudioList(dataDTO);
        List list = VoFactory.doBackwardList(audioPageInfo.getList(), AudioVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/detail")
    public BaseResultVO getAudioDetail(@Valid BaseDataDTO dataDTO) {
        Map<String, Object> result = audioService.getAudioDetail(dataDTO);
        return new SuccessResultVO(result);
    }

    @GetMapping("/comment/{id}")
    public BaseResultVO getCommentList(@Valid PageDTO pageDTO, @PathVariable("id") Long id) {
        PageInfo<Comment> pageInfo = audioService.getCommentList(pageDTO, id);
        List list = VoFactory.doBackwardList(pageInfo.getList(), CommentVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/collect/{uid}")
    public BaseResultVO userCollectList(@Valid PageDTO pageDTO, @PathVariable("uid") Long uid) {
        PageInfo<AudioDir> pageInfo = audioService.userCollectList(pageDTO, uid);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), AudioDirVO.class);
        return new SuccessResultVO(list);
    }

    @PostMapping("/dir/collect")
    public BaseResultVO collectAudioDir(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = audioService.collectAudioDir(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/dir/like")
    public BaseResultVO likeAudioDir(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = audioService.likeAudioDir(dataDTO);
        return new SuccessResultVO(result);
    }

    @PostMapping("/like")
    public BaseResultVO likeAudio(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = audioService.likeAudio(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/dir/comment/publish")
    public BaseResultVO commentAudioDir(@RequestBody @Valid CommentDTO commentDTO) {
        Comment comment = commentDTO.convertToComment();
        boolean result = audioService.commentAudioDir(comment);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/comment/publish")
    public BaseResultVO commentAudio(@RequestBody @Valid CommentDTO commentDTO) {
        Comment comment = commentDTO.convertToComment();
        boolean result = audioService.commentAudio(comment);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/dir/comment/like")
    public BaseResultVO likeDirComment(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = audioService.likeDirComment(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/comment/like")
    public BaseResultVO likeComment(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = audioService.likeComment(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

}
