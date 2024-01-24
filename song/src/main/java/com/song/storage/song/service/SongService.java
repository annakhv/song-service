package com.song.storage.song.service;

import java.util.Arrays;
import java.util.List;

import com.song.storage.song.entity.SongData;
import com.song.storage.song.exception.IdNotFoundException;
import com.song.storage.song.exception.InvalidScvException;
import com.song.storage.song.repository.SongDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongDataRepository songDataRepository;

    public long saveSong(SongData songData){
        return songDataRepository.save(songData).getId();
    }

    public SongData getSong(Long songResourceId) {
        return songDataRepository.findByResourceId(songResourceId)
                .orElseThrow(() -> new IdNotFoundException("no metadata found for id " + songResourceId));
    }

    @Transactional
    public long[] deleteSong(String resourceIds) {
        validateScv(resourceIds);
        List<String> idsList = Arrays.asList(resourceIds.split(","));
        return idsList.stream()
                .mapToLong(Long::parseLong)
                .filter(songDataRepository::existsByResourceId)
                .peek(songDataRepository::deleteByResourceId)
                .toArray();
    }

    private void validateScv(String ids) {
        if (ids.length() >= 200) {
            throw new InvalidScvException("provided scv is invalid");
        }
    }
}
