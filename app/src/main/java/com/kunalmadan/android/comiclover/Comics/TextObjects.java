package com.kunalmadan.android.comiclover.Comics;

/**
 * Created by KUNAL on 08-Sep-16.
 */
public class TextObjects {
    private String text;

    private String language;

    private String type;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+", language = "+language+", type = "+type+"]";
    }
}
