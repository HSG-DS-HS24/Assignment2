package com.example.searchengine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@Component
public abstract class Crawler {

     final String indexFileName;

    private String baseUrl = "https://api.interactions.ics.unisg.ch/hypermedia-environment/";

    /**
     *
     * @param indexFileName the name of the file that is used as index.
     */
    protected Crawler(String indexFileName) {
        this.indexFileName = indexFileName;
    }

    /**
     *
     * @param url the url where the crawling starts
     */
    public abstract void crawl(String url);


    /**
     *
     * @param urlString
     * @return A list containing two sublists: the first one is the list of keywords present the Web page and the second one is a list of hyperlinks present in the Web page.
     */
    public  List<List<String>> getInfo(String urlString){
        List<String> keywords = new ArrayList<>();
        List<String> hyperlinks = new ArrayList<>();
        List<List<String>> returnList = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            Elements elements; //TODO: initialize elements based on the webpage at the given url.
            //TODO : Use elements to put the keywords in the webpage in the list keywords.
            //TODO : Use elements to the hyperlinks to other pages in the environment in the list hyperlinks.
        } catch (Exception e){
            e.printStackTrace();
        }
        returnList.add(keywords);
        returnList.add(hyperlinks);
        return returnList;
    }
}
