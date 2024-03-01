package com.tonio;

import com.tonio.model.Artist;
import com.tonio.model.DataSource;
import com.tonio.model.SongArtist;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()) {
            System.out.println("Can't open data datasource");
            return;
        }
        List<Artist> artists = dataSource.queryArtist();
        if(artists == null){
            System.out.println("No Artist Found");
            return;
        }
        for(Artist artist : artists){
            System.out.println("ID: " + artist.getId() + " Name: " + artist.getName());
        }

        List<String> albumsForArtists =
                dataSource.queryAlbumsForArtist("Iron Maiden",DataSource.ORDER_BY_ASC);

        for(String album : albumsForArtists){
            System.out.println(album);
        }

        List<SongArtist> songArtists = dataSource.queryArtistForSong("Heartless", DataSource.ORDER_BY_ASC);
        if(songArtists == null){
            System.out.println("Couldn't find the  artist for the song");
            return;
        }

        for(SongArtist artist : songArtists){
            System.out.println("Artist name: " + artist.getArtistName() +
                            " Album name: " +  artist.getAlbumName() +
                            " Song Track: " + artist.getTrack());
        }
        System.out.println("Number of songs: " +  dataSource.getCount(DataSource.TABLE_SONGS));
        dataSource.close();
    }
}
