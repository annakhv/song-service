package com.song.storage.song.repository;

import com.song.storage.song.entity.SongData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongDataRepository extends JpaRepository<SongData, Long> {}
