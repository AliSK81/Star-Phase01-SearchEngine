package model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Getter
public class InvertedIndex {
    private final Map<String, Set<Integer>> map = new HashMap<>();
}
