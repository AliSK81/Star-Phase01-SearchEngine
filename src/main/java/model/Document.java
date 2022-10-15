package model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Document {
    private Integer id;
    private String content;
}
