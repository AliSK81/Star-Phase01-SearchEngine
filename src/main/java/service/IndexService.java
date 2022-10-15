package service;

import lombok.AllArgsConstructor;
import model.InvertedIndex;

import java.util.Set;

@AllArgsConstructor
public class IndexService {

    private final InvertedIndex index;

    public Set<Integer> find(String word) {
        return index.getMap().get(word);
    }
}
