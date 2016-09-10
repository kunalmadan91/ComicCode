package com.kunalmadan.android.comiclover.Comics;

/**
 * Created by KUNAL on 08-Sep-16.
 */
public class Series {

    private String resourceURI;

    private String name;

    public String getResourceURI ()
    {
        return resourceURI;
    }

    public void setResourceURI (String resourceURI)
    {
        this.resourceURI = resourceURI;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [resourceURI = "+resourceURI+", name = "+name+"]";
    }
}
