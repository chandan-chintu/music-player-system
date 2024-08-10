package listenfiy;

import java.util.List;

public class Album {

    private String albumName;
    private String artistName;
    public List<Song> songsList;

    public Album(String albumName, String artistName, List<Song> songsList) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songsList = songsList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Song> getSongsList() {
        return songsList;
    }

    public void setSongsList(List<Song> songsList) {
        this.songsList = songsList;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", songsList=" + songsList +
                '}';
    }

    public boolean findSongsInAlbum(String title){
        // traverse using for each loop and get the song from list of songs
        for(Song song : getSongsList()){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addSongsToTheAlbum(Song song){
        // check if the song is already present or not
        // if not prresent we can add it into songlist

        boolean songAlreadyPresent = findSongsInAlbum(song.getTitle());
        if(songAlreadyPresent){
            return "Song is already Present";
        } else{
            // we need add it to songlist
            songsList.add(song);
            return "New song has been added successfully";
        }
    }
}
