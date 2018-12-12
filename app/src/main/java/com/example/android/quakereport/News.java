
package com.example.android.quakereport;

public class News {

  private String mName;
  private String mArticleTitle;

    /** Website URL of the earthquake */
    private String mUrl;

    public News(String name, String articleTitle, String url) {
       mName = name;
       mArticleTitle = articleTitle;
        mUrl = url;
    }


    public String getName() {
        return mName;
    }


    public String getArticleTitle() {
        return mArticleTitle;
    }

    public String getUrl() {
        return mUrl;
    }
}
