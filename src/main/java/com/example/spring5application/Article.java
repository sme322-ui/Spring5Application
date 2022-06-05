package com.example.spring5application;

import org.hibernate.mapping.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;

public class Article implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique=true)
    @NotEmpty(message="標題不能為空")
    private String title;

    @Column(columnDefinition = "enum('圖','圖文','文')")
    private String type;

    private Boolean available = Boolean.FALSE;
    @Size(min = 0,max=20)
    private String keyword;
    @Size(max=255)
    private String description;
    @Column(nullable = false)
    private String body;

    @Transient
    private List keywordLists;
    private List getkeywordlist(){
        return (List) Arrays.asList(this.keyword.trim().split("|"));
    }

    public void setKeywordlists(List keywordlists){
        this.keywordLists = keywordlists;
    }

}
