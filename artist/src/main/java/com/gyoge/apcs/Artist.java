// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.net.URL;
import java.util.Objects;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
public class Artist implements Comparable<Artist> {

    private String artistName;
    private String songName;

    private String artistImage;
    private long songSales;
    private ImageIcon imageIcon;

    public Artist(String artistName, String songName, String artistImage, Long songSales) {
        this.artistName = artistName;
        this.songName = songName;
        this.artistImage = artistImage;
        this.songSales = songSales;

        URL resource = this.getClass().getResource("/" + artistImage);
        if (resource == null) {
            throw new RuntimeException("File not found: /" + artistImage);
        }
        this.imageIcon = new ImageIcon(resource);
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public int compareTo(Artist other) {
        if (this.songSales > other.songSales) return 1;
        else if (this.songSales < other.songSales) return -1;
        else return this.artistName.compareTo(other.artistName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(getArtistName(), artist.getArtistName())
            && Objects.equals(getSongName(), artist.getSongName())
            && Objects.equals(getArtistImage(), artist.getArtistImage())
            && Objects.equals(getSongSales(), artist.getSongSales());
    }

    @Override
    public String toString() {
        return "Artist{"
            + "artistName='"
            + artistName
            + '\''
            + ", songName='"
            + songName
            + '\''
            + ", artistImage='"
            + artistImage
            + '\''
            + ", songSales="
            + songSales
            + '}';
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

    public long getSongSales() {
        return songSales;
    }

    public void setSongSales(long songSales) {
        this.songSales = songSales;
    }
}
