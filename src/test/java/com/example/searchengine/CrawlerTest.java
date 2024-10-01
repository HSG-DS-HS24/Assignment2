package com.example.searchengine;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class CrawlerTest extends TestBase{

    @BeforeAll
    public void crawl(){
        Crawler c = generateCrawler();
        c.crawl(startUrl);

    }

    @Test
    public void testCrawlFirstUrl(){
        try {
            System.out.println("test crawl");
            CSVReader csvReader = new CSVReader(new FileReader(indexFileName));
            List<String[]> lines = csvReader.readAll();
            boolean hasUrl7ab162649f1bb44 = false;
            for (String[] line: lines){
                boolean b = testUrl(line, "/7ab162649f1bb44", createSet("update", "otherwise", "screensavers"));
                if (b){
                    hasUrl7ab162649f1bb44 = true;
                }
            }
            if (!hasUrl7ab162649f1bb44){
                fail();
            }
        } catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testCrawlSecondUrl(){
        try {
            System.out.println("test crawl 2");
            CSVReader csvReader = new CSVReader(new FileReader(indexFileName));
            List<String[]> lines = csvReader.readAll();
            boolean hasUrl1bd38608b1a6cf7e = false;
            for (String[] line: lines){
                boolean b = testUrl(line,"/1bd38608b1a6cf7e", createSet("blogs", "land", "medicine"));

                if (b){
                    hasUrl1bd38608b1a6cf7e = true;
                }

            }
            if ( !hasUrl1bd38608b1a6cf7e){
                fail();
            }
        } catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void testCrawlThirdUrl(){
        try {
            System.out.println("test crawl");
            CSVReader csvReader = new CSVReader(new FileReader(indexFileName));
            List<String[]> lines = csvReader.readAll();
            boolean hasUrl68b088f800b95e8c = false;
            for (String[] line: lines){
                boolean b = testUrl(line,"/68b088f800b95e8c", createSet("guinea", "robinson", "implementing"));

                if (b){
                    hasUrl68b088f800b95e8c = true;
                }

            }
            if ( !hasUrl68b088f800b95e8c){
                fail();
            }
        } catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }


    public boolean testUrl(String[] line, String url, Set<String> values){
        boolean b = false;
        if (line[0].equals(url)){
            Set<String> set = new HashSet<>(Arrays.asList(line).subList(1, line.length));
            assertEquals(set, values);
            b = true;
        }
        return b;
    }

    public abstract Crawler generateCrawler();
}
