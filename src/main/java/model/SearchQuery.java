package model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SearchQuery {
    private final Set<String> all_of_these_words = new HashSet<>();
    private final Set<String> any_of_these_words = new HashSet<>();
    private final Set<String> none_of_these_words = new HashSet<>();
}
