package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.*;
import com.mongolia.model.entity.Audio;
import com.mongolia.model.entity.AudioDir;
import com.mongolia.model.vo.AudioDirVO;
import com.mongolia.model.vo.AudioVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 管理系统音频相关Api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/audio")
public class MsAudioController {

    @Autowired
    private AudioService audioService;

    @GetMapping("/dir/list")
    public BaseResultVO audioDirList(@Valid PageDTO pageDTO) {
        PageInfo<AudioDir> pageInfo = audioService.audioDirList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), AudioDirVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/radio/list")
    public BaseResultVO radioDirList(@Valid PageDTO pageDTO) {
        PageInfo<AudioDir> pageInfo = audioService.radioDirList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), AudioDirVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/dir/search")
    public BaseResultVO searchAudioDir(@Valid SearchDTO searchDTO) {
        PageInfo<AudioDir> pageInfo = audioService.audioDirListBySearch(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), AudioDirVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @PostMapping("/dir/add")
    public BaseResultVO addAudioDir(@RequestBody @Valid AudioDirDTO audioDirDTO){
        AudioDir audioDir = audioDirDTO.convertToAudioDir();
        boolean result = audioService.publishAudioDir(audioDir);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/dir/edit")
    public BaseResultVO editAudioDir(@RequestBody @Valid AudioDirDTO audioDirDTO){
        AudioDir audioDir = audioDirDTO.convertToAudioDir();
        boolean result = audioService.editAudioDir(audioDir);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/dir/del")
    public BaseResultVO deleteAudioDir(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = audioService.deleteAudioDir(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/shelves")
    public BaseResultVO shelvesAudioDir(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = audioService.shelvesAudioDir(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @GetMapping("/list")
    public BaseResultVO audioList(@Valid PageDTO pageDTO){
        PageInfo<Audio> pageInfo = audioService.getAudioList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), AudioVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @PostMapping("/add")
    public BaseResultVO addAudio(@RequestBody @Valid AudioDTO audioDTO){
        Audio audio = audioDTO.convertToAudio();
        boolean result = audioService.publishAudio(audio);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/edit")
    public BaseResultVO editAudio(@RequestBody @Valid AudioDTO audioDTO){
        Audio audio = audioDTO.convertToAudio();
        boolean result = audioService.editAudio(audio);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/del")
    public BaseResultVO deleteAudio(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = audioService.deleteAudio(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/pay")
    public BaseResultVO payAudio(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = audioService.payAudio(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

}
