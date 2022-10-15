import model.Document;
import model.InvertedIndex;
import model.SearchQuery;
import model.builder.IndexBuilder;
import model.builder.QueryBuilder;
import service.DocReader;
import service.IndexService;
import service.SearchService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchEngine {

    public static void run() throws IOException {
        List<Document> docs = DocReader.getInstance().readDocs();

        InvertedIndex index = new IndexBuilder(docs).build();

        IndexService indexService = new IndexService(index);

        SearchService searchService = new SearchService(indexService);

        Scanner sc = new Scanner(System.in);

        String query = "-";
        while (!query.equals("")) {
            System.out.print("Enter query: ");
            query = sc.nextLine();

            SearchQuery searchQuery = new QueryBuilder(query).build();

            try {
                System.out.println(
                        searchService.find(searchQuery)
                );
            } catch (NullPointerException ignored) {
                System.out.println("No result.");
            }
        }
    }

}
