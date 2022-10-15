package service;

import config.Constants;
import model.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DocReader {
    private static DocReader instance;

    public static DocReader getInstance() {
        if (instance == null) {
            instance = new DocReader();
        }
        return instance;
    }

    public List<Document> readDocs() throws IOException {
        File dir = new File(Constants.docsDir);

        List<Document> docs = new ArrayList<>();

        for (String docName : Objects.requireNonNull(dir.list())) {

            Path docPath = Path.of(dir + "/" + docName);
            String docContent = String.join(" ", Files.readAllLines(docPath));
            Integer docId = Integer.parseInt(docName);

            docs.add(Document.builder()
                    .id(docId)
                    .content(docContent)
                    .build()
            );
        }

        return docs;
    }
}