package com.searchcode.app.dto.searchcode;


/**
 * Represents a single code object inside the searchcode.com database
 */
public class Code {
    public int id;
    public String location;
    public String content;

    public Code(int id, String location, String content) {
        this.id = id;
        this.location = location;
        this.content = content;
    }
}
