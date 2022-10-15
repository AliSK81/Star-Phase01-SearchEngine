package service;

import lombok.AllArgsConstructor;
import model.SearchQuery;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class SearchService {
    private final IndexService indexService;

    public HashSet<Integer> find(SearchQuery query) {
        HashSet<Integer> searchResult = new HashSet<>();

        findAll_of_these_words(query, searchResult);
        findAny_of_these_words(query, searchResult);
        removeNone_of_these_words(query, searchResult);

        return searchResult;
    }

    private void findAll_of_these_words(SearchQuery query, Set<Integer> searchResult) {
        for (String word : query.getAll_of_these_words()) {
            if (searchResult.isEmpty()) {
                searchResult.addAll(indexService.find(word));
            } else {
                searchResult.retainAll(indexService.find(word));
            }
        }
    }

    private void findAny_of_these_words(SearchQuery query, Set<Integer> searchResult) {
        for (String word : query.getAny_of_these_words()) {
            searchResult.addAll(indexService.find(word));
        }
    }

    private void removeNone_of_these_words(SearchQuery query, Set<Integer> searchResult) {
        for (String word : query.getNone_of_these_words()) {
            for (Integer docId : indexService.find(word)) {
                searchResult.remove(docId);
            }
        }
    }
}
