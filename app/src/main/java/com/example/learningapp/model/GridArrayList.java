package com.example.learningapp.model;

public class GridArrayList {
    private final Integer studyicon;
    private final String studyname;

    public GridArrayList(Integer studyicon, String studyname) {
        this.studyicon = studyicon;
        this.studyname = studyname;
    }

    public Integer getStudyicon() {
        return studyicon;
    }

    public String getStudyname() {
        return studyname;
    }
}
