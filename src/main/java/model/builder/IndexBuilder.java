package model.builder;

import config.Constants;
import model.Document;
import model.InvertedIndex;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class IndexBuilder {

    private static InvertedIndex index;

    public IndexBuilder(List<Document> docs) {
        index = new InvertedIndex();

        for (Document doc : docs) {
            Scanner sc = new Scanner(doc.getContent()).useDelimiter(Constants.delim);

            while (sc.hasNext()) {
                String word = sc.next().toUpperCase();

                if (!Constants.delim.contains(word)) {
                    index.getMap().putIfAbsent(word, new HashSet<>());
                    index.getMap().get(word).add(doc.getId());
                }
            }
            sc.close();
        }
    }

    public InvertedIndex build() {
        return index;
    }

}
