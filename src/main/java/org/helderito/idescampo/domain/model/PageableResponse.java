package org.helderito.idescampo.domain.model;
/*
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.helderito.idescampo.config.jackson.descerialization.CustomSortDeserialization;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PageableResponse<T> extends PageImpl<T> {

    private boolean last;
    private boolean first;
    private boolean totalPages;

    public PageableResponse(@JsonProperty("content")List<T> content,
                            @JsonProperty("number")int page,
                            @JsonProperty("size") int size,
                            @JsonProperty("totalElements") long totalElements,
                            @JsonProperty("sort")@JsonDeserialize(using = CustomSortDeserialization.class) Sort sort) {
        super(content, new PageRequest(page,size,sort),totalElements);
    }

    public PageableResponse() {
        super(new ArrayList<>());
    }
}
*/