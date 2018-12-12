/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public final class QueryUtils {

    private static final String ANOTHER_JSON_RESPONSE = "{\"results\":[" +
            "{\"id\":\"politics/2018/sep/17/election-debates-commission-needed-says-sky-news\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-09-16T23:01:06Z\",\"webTitle\":\"Election debates commission needed, says Sky News\",\"webUrl\":\"https://www.theguardian.com/politics/2018/sep/17/election-debates-commission-needed-says-sky-news\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/sep/17/election-debates-commission-needed-says-sky-news\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"australia-news/2018/nov/26/tobacco-gambling-and-alcohol-donations-rise-during-critical-debates\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-11-26T17:00:45Z\",\"webTitle\":\"Tobacco, gambling and alcohol donations 'rise during critical debates'\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/nov/26/tobacco-gambling-and-alcohol-donations-rise-during-critical-debates\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/nov/26/tobacco-gambling-and-alcohol-donations-rise-during-critical-debates\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"australia-news/2018/aug/13/turnbulls-energy-policy-hangs-in-the-balance-as-euthanasia-debate-given-precedence\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-08-12T18:00:08Z\",\"webTitle\":\"Energy policy hangs in balance, as Senate debates euthanasia\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/aug/13/turnbulls-energy-policy-hangs-in-the-balance-as-euthanasia-debate-given-precedence\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/aug/13/turnbulls-energy-policy-hangs-in-the-balance-as-euthanasia-debate-given-precedence\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/dec/01/may-v-corbyn-on-brexit-the-debate-over-the-debate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-12-01T07:00:15Z\",\"webTitle\":\"May v Corbyn on Brexit: the debate over the debate\",\"webUrl\":\"https://www.theguardian.com/politics/2018/dec/01/may-v-corbyn-on-brexit-the-debate-over-the-debate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/dec/01/may-v-corbyn-on-brexit-the-debate-over-the-debate\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/dec/04/bbc-itv-plan-rival-brexit-debates-corbyn-may-cant-agree-format\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-12-04T10:17:38Z\",\"webTitle\":\"Rival Brexit debates planned as Corbyn and May can't agree on format\",\"webUrl\":\"https://www.theguardian.com/politics/2018/dec/04/bbc-itv-plan-rival-brexit-debates-corbyn-may-cant-agree-format\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/dec/04/bbc-itv-plan-rival-brexit-debates-corbyn-may-cant-agree-format\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"australia-news/2018/nov/22/not-a-soft-on-crime-option-nsw-debates-plan-for-indigenous-sentencing-court\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-11-21T17:00:16Z\",\"webTitle\":\"'Not a soft-on-crime option': NSW debates plan for Indigenous sentencing court\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/nov/22/not-a-soft-on-crime-option-nsw-debates-plan-for-indigenous-sentencing-court\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/nov/22/not-a-soft-on-crime-option-nsw-debates-plan-for-indigenous-sentencing-court\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"world/2018/nov/06/canada-debates-assisted-death-laws\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-11-06T10:00:27Z\",\"webTitle\":\"Canada debates assisted death laws after woman is forced to end life early\",\"webUrl\":\"https://www.theguardian.com/world/2018/nov/06/canada-debates-assisted-death-laws\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/nov/06/canada-debates-assisted-death-laws\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"media/2018/jun/13/the-rev-colin-morris-obituary-letter\",\"type\":\"article\",\"sectionId\":\"media\",\"sectionName\":\"Media\",\"webPublicationDate\":\"2018-06-13T15:00:17Z\",\"webTitle\":\"Letter: Invoking the Rev Colin Morris law of TV debates\",\"webUrl\":\"https://www.theguardian.com/media/2018/jun/13/the-rev-colin-morris-obituary-letter\",\"apiUrl\":\"https://content.guardianapis.com/media/2018/jun/13/the-rev-colin-morris-obituary-letter\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"politics/2018/may/10/tories-accused-of-subverting-democracy-by-not-tabling-brexit-debates\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-05-10T16:09:05Z\",\"webTitle\":\"Tories accused of 'subverting democracy' by not tabling Brexit debates\",\"webUrl\":\"https://www.theguardian.com/politics/2018/may/10/tories-accused-of-subverting-democracy-by-not-tabling-brexit-debates\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/may/10/tories-accused-of-subverting-democracy-by-not-tabling-brexit-debates\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}," +
            "{\"id\":\"world/2018/may/04/project-fantasy-german-exam-question-debates-brexit-reality\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-05-04T15:19:29Z\",\"webTitle\":\"Project Fantasy? German exam question debates Brexit reality\",\"webUrl\":\"https://www.theguardian.com/world/2018/may/04/project-fantasy-german-exam-question-debates-brexit-reality\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/may/04/project-fantasy-german-exam-question-debates-brexit-reality\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}]}}";

    private QueryUtils() {
    }

    public static ArrayList<News> extractEarthquakes() {
        ArrayList<News> news = new ArrayList<>();
        try {

//            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONObject baseJsonResponse  = new JSONObject(ANOTHER_JSON_RESPONSE);
            JSONArray newsArray = baseJsonResponse.getJSONArray("results");

            for (int i = 0; i < newsArray.length(); i++) {

                JSONObject currentNews = newsArray.getJSONObject(i);


                String articleTitle = currentNews.getString("webTitle");

                String articleName = currentNews.getString("sectionName");

                String url = currentNews.getString("webUrl");

                News theNews = new News(articleTitle, articleName, url);

                news.add(theNews);
            }

        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return news;
    }

}
