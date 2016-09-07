/*
 * Copyright (c) 2016 Boyter Online Services
 *
 * Use of this software is governed by the Fair Source License included
 * in the LICENSE.TXT file
 */


package com.searchcode.app.dto;

import com.searchcode.app.config.Values;

public class CodeFacetYear {
    public String languageName = Values.EMPTYSTRING;
    public int count = 0;
    public boolean selected = false;

    public CodeFacetYear(String languageName, int count) {
        this.setYear(languageName);
        this.setCount(count);
    }

    public String getYear() {
        return languageName;
    }

    public void setYear(String languageName) {
        this.languageName = languageName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
