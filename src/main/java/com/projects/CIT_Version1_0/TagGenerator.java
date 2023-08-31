package com.projects.CIT_Version1_0;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagGenerator {

    private Set<String> loadStopwords(String filename) throws IOException {
        Set<String> stopwords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                TagGenerator.class.getResourceAsStream("/" + filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stopwords.add(line.trim());
            }
        }
        return stopwords;
    }

    private String removeNonAlphabeticCharacters(String word) {
        return word.replaceAll("[^a-zA-Z0-9]", "");
    }

    public Set<String> generateTags(String inputText) {
        Set<String> stopwords;
        try {
            stopwords = loadStopwords("stopwords.txt");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load stopwords", e);
        }

        String[] lines = inputText.split("\\.");
        StringBuilder filteredText = new StringBuilder();

        for (String line : lines) {
            String[] words = line.split("\\s+");
            StringBuilder filteredLine = new StringBuilder();

            for (String word : words) {
                word = word.toLowerCase().trim();
                word = removeNonAlphabeticCharacters(word);

                if (!word.isEmpty() && !stopwords.contains(word)) {
                    filteredLine.append(word).append(" ");
                }
            }

            String filteredLineStr = filteredLine.toString().trim();
            if (!filteredLineStr.isEmpty()) {
                filteredText.append(filteredLineStr).append(" ");
            }
        }

        Set<String> tags = new HashSet<>();

        for (String tag : filteredText.toString().split(" ")) {
            tags.add("#" + tag);
        }

        return tags;
    }
}
