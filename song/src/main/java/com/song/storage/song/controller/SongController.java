package com.song.storage.song.controller;

import com.song.storage.song.dto.SongMetaData;
import com.song.storage.song.mapper.MetaDataMapper;
import com.song.storage.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meta-data")
public class SongController {

    private final SongService songService;

    @PostMapping("/songs")
    public Long createSongMetaData(@RequestBody SongMetaData metaData) {
        return songService.saveSong(MetaDataMapper.mapToSongData(metaData));
    }

    @GetMapping("/songs/{id}")
    public SongMetaData getSongMetaData(@PathVariable Long id) {
        return MetaDataMapper.mapToMetaData(songService.getSong(id));
    }

    @DeleteMapping("/songs")
    public long[] deleteSongMetaData(@Param("ids") String ids) {
        return songService.deleteSong(ids);
    }
}
