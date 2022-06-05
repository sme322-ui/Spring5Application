package com.example.spring5application;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberAccount extends JsonArrayFormatVisitor.Base {

    private String id;
    private String username;
    private String password;
    private String salt;
    private String create_by;
    private String update_by;

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getUpdate_by() {
        return update_by;
    }
}