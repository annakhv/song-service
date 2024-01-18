package com.song.storage.song.service;

import java.util.Arrays;
import java.util.List;

import com.song.storage.song.entity.SongData;
import com.song.storage.song.repository.SongDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongDataRepository songDataRepository;

    public long saveSong(SongData songData){
        return songDataRepository.save(songData).getId();
    }

    public SongData getSong(Long songId) {
        return songDataRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("no metadata found for id " + songId));
    }

    public long[] deleteSong(String ids) {
        List<String> idsList = Arrays.asList(ids.split(","));
        return idsList.stream()
                .mapToLong(Long::valueOf)
                .filter(songDataRepository::existsById)
                .peek(songDataRepository::deleteById)
                .toArray();
    }
}
