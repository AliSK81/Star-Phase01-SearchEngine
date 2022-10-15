package model.builder;

import model.SearchQuery;

public class QueryBuilder {
    private final SearchQuery searchQuery;

    public QueryBuilder(String query) {
        searchQuery = new SearchQuery();
        String[] words = query.split(" ");

        for (String word : words) {
            if (word.startsWith("+")) {
                searchQuery.getAny_of_these_words().add(word.substring(1).toUpperCase());
            } else if (word.startsWith("-")) {
                searchQuery.getNone_of_these_words().add(word.substring(1).toUpperCase());
            } else {
                searchQuery.getAll_of_these_words().add(word.toUpperCase());
            }
        }
    }

    public SearchQuery build() {
        return searchQuery;
    }
}

