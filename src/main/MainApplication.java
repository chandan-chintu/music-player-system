package main;

import listenfiy.Album;
import listenfiy.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

        List<Song> songList1 = new ArrayList<>();
        Song song1 = new Song("Channa mereya",4.32);
        songList1.add(song1);
        Song song2 = new Song("Tum kya mile",3.32);
        songList1.add(song2);
        Song song3 = new Song("Disco deewani",5.32);
        songList1.add(song3);

        Album album1 = new Album("Old Songs","old artist", songList1);
        System.out.println(album1);

        List<Song> songList2 = new ArrayList<>();
        Song song4 = new Song("ABC",1.32);
        songList2.add(song4);
        Song song5 = new Song("XYZ",2.32);
        songList2.add(song5);
        Song song6 = new Song("PQR",6.32);
        songList2.add(song6);

        Album album2 = new Album("Modern songs","modern artist", songList2);
        System.out.println(album2);

        System.out.println("Find song from album");
        Scanner sc = new Scanner(System.in);
        String titleOfSong = sc.nextLine();
        boolean songpresent = album1.findSongsInAlbum(titleOfSong);
        if(songpresent){
            System.out.println("Song "+titleOfSong+" is playing......");
        }else{
            System.out.println("Song "+titleOfSong+" not found");
        }

        System.out.println("Do you want to play previous or next songs : "); // previous -1 , next 1
        int previousornext = sc.nextInt();
        if(previousornext == 1){
            playNext(album1, titleOfSong);
        } else if(previousornext == -1){
            playPrevious(album1,titleOfSong);
        } else{
            System.out.println("Replaying same song : "+titleOfSong);
        }

    }

    public static void playPrevious(Album album, String titleOfSong){
        List<Song> songList = album.getSongsList();
        for(int i = 0; i<songList.size();i++){
            if(songList.get(i).getTitle().equals(titleOfSong)){
                System.out.println("Previous song playing is : "+songList.get(i-1).getTitle());
            }
        }
    }

    public static void playNext(Album album, String titleOfSong){
        List<Song> songList = album.getSongsList();
        for(int i = 0; i<songList.size();i++){
            if(songList.get(i).getTitle().equals(titleOfSong)){
                System.out.println("Previous song playing is : "+songList.get(i+1).getTitle());
            }
        }
    }
}
