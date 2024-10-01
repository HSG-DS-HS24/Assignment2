package com.example.searchengine;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearcherTest extends TestBase {

    @Test
    public void testSearch(){
        Searcher searcher = new Searcher();
        Set<String> urls = new HashSet<>(searcher.search("producer", flippedIndexFileName));
        assertEquals(urls, createSet("https://api.interactions.ics.unisg.ch/hypermedia-environment/a8d56d8a4950615d", "https://api.interactions.ics.unisg.ch/hypermedia-environment/a2527e4d6a6b89e2"));
    }

}
