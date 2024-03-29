package com.tonio.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Administrator\\Desktop\\Antonio\\Java\\Music\\" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;


    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK  = 2;
    public static final int INDEX_SONG_TITLE  = 3;
    public static final int INDEX_SONG_ALBUM  = 4;
    public static final int ORDER_BY_NONE = 0;
    public static final int ORDER_BY_ASC = 1;
    public static final int ORDER_BY_DESC = 2;
    public static final String QUERY_ARTIST_OR_SONG_START =
            "SELECT " + TABLE_SONGS + '.' + COLUMN_SONG_TRACK + ", " +
            TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS +  '.' + COLUMN_ALBUM_NAME + " " +
            "FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS +
            " ON " + TABLE_SONGS + '.' + COLUMN_SONG_ALBUM +  "=" + TABLE_ALBUMS + '.' +  COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS +  '.'  +  COLUMN_ALBUM_ARTIST + "=" + TABLE_ARTISTS + '.'  + COLUMN_ARTIST_ID  +
            " WHERE "+ TABLE_SONGS + '.' + COLUMN_SONG_TITLE +  "=\"";
    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME +  ", " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME +
                    " COLLATE NOCASE ";
    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        }catch (SQLException e){
            System.out.println("Could connect to  db: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Could not close connection: " + e.getMessage());
        }
    }

    public List<Artist> queryArtist(){
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()){
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(COLUMN_ARTIST_ID));
                artist.setName(resultSet.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        }catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String>  queryAlbumsForArtist(String artistName, int  sortOrder){
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(TABLE_ALBUMS);
        sb.append('.');
        sb.append(COLUMN_ALBUM_NAME);
        sb.append(" FROM ");
        sb.append(TABLE_ALBUMS);
        sb.append(" INNER JOIN ");
        sb.append(TABLE_ARTISTS);
        sb.append(" ON ");
        sb.append(TABLE_ALBUMS);
        sb.append('.');
        sb.append(COLUMN_ALBUM_ARTIST);
        sb.append(" = ");
        sb.append(TABLE_ARTISTS);
        sb.append('.');
        sb.append(COLUMN_ARTIST_ID);
        sb.append(" WHERE ");
        sb.append(TABLE_ARTISTS);
        sb.append('.');
        sb.append(COLUMN_ARTIST_NAME);
        sb.append("= \"");
        sb.append(artistName);
        sb.append("\"");

        if(sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER  BY ");
            sb.append(TABLE_ALBUMS);
            sb.append('.');
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE  NOCASE ");
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else {
                sb.append("ASC");
            }
        }
        System.out.println("SQL statement = "+ sb);
        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString())) {
            List<String> albums = new ArrayList<>();
            while (resultSet.next()){
                albums.add(resultSet.getString(1));
            }
            return albums;

        } catch (SQLException e) {
            System.out.println("Query  Failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<SongArtist> queryArtistForSong(String songName, int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_OR_SONG_START);
        sb.append(songName);
        sb.append("\"");

        if(sortOrder != ORDER_BY_NONE){
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);
            if(sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else {
                sb.append("ASC");
            }
        }
        System.out.println("SQL Statement: " + sb);

        try(Statement statement = conn.createStatement();
            ResultSet resultSet =statement.executeQuery(sb.toString())) {
            List<SongArtist> songArtists = new ArrayList<>();
            while(resultSet.next()){
                SongArtist songArtist = new SongArtist();
                songArtist.setTrack(resultSet.getInt(1));
                songArtist.setArtistName(resultSet.getString(2));
                songArtist.setAlbumName(resultSet.getString(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public int  getCount(String table){
        String sql = "SELECT COUNT(*) FROM " + table;
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            return resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Query Failed: " + e.getMessage());
            return -1;
        }
    }

}
