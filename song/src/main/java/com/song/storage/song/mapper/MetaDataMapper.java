package com.song.storage.song.mapper;

import com.song.storage.song.dto.SongMetaData;
import com.song.storage.song.entity.SongData;

public class MetaDataMapper {

    public static SongData mapToSongData(SongMetaData songMetaData){
       return new SongData()
               .setAlbum(songMetaData.getAlbum())
               .setName(songMetaData.getName())
               .setLength(songMetaData.getLength())
               .setYear(songMetaData.getYear())
               .setResourceId(songMetaData.getResourceId())
               .setArtist(songMetaData.getArtist());
    }

    public static SongMetaData mapToMetaData(SongData data){
        return new SongMetaData()
                .setAlbum(data.getAlbum())
                .setName(data.getName())
                .setLength(data.getLength())
                .setYear(data.getYear())
                .setResourceId(data.getResourceId())
                .setArtist(data.getArtist());
    }
}
