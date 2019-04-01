package com.example.opet.appemailsenhacd;

/**
 * Created by opet on 01/04/2019.
 */

public class Filme {

    private String title;
    private Integer episode_id ;
    private String director;

    public Filme() {
    }

    public Filme(String title, Integer episode_id, String director) {
        this.title = title;
        this.episode_id = episode_id;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(Integer episode_id) {
        this.episode_id = episode_id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filme filme = (Filme) o;

        if (!title.equals(filme.title)) return false;
        if (!episode_id.equals(filme.episode_id)) return false;
        return director.equals(filme.director);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + episode_id.hashCode();
        result = 31 * result + director.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "title='" + title + '\'' +
                ", episode_id=" + episode_id +
                ", director='" + director + '\'' +
                '}';
    }
}
