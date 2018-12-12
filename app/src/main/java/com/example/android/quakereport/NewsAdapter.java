package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR = " of ";

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);


        TextView primarySectionView = listItemView.findViewById(R.id.section);

        String formattedSectionView = currentNews.getArticleTitle();

        primarySectionView.setText(formattedSectionView);


        TextView newsTitleView = listItemView.findViewById(R.id.articleTitle);

        String formattedNewsTitle = currentNews.getName();

        newsTitleView.setText(formattedNewsTitle);


        // Find the TextView with view ID location offset
        TextView newsUrlView = (TextView) listItemView.findViewById(R.id.url);

        String formattedUrlView = currentNews.getArticleTitle();

        newsUrlView.setText(formattedUrlView);

   return listItemView;
    }
}
