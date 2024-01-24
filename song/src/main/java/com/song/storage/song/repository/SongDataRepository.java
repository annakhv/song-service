package com.song.storage.song.repository;

import java.util.Optional;

import com.song.storage.song.entity.SongData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongDataRepository extends JpaRepository<SongData, Long> {

    Optional<SongData> findByResourceId(long resourceId);

    void deleteByResourceId(long resourceId);

    boolean existsByResourceId(long resourceId);
}
