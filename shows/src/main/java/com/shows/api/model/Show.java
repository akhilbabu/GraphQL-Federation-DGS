package com.shows.api.model;

public class Show {
    private  String title;
    private  Integer releaseYear;
    
    private  Integer id;

    public Show(String title, Integer releaseYear,Integer id) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.setId(id);
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}