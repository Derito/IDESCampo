package org.helderito.idescampo.config.jackson.descerialization;
/*
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.data.domain.Sort;

import java.io.IOException;

public class CustomSortDeserialization extends JsonDeserializer<Sort> {
    @Override
    public Sort deserialize(JsonParser jParser, DeserializationContext desContext) throws IOException{


        ArrayNode node = jParser.getCodec().readTree(jParser);
        Sort.Order[] orders = new Sort.Order[node.size()];
        int i = 0;
        for(JsonNode jNode : node){
            orders[i] = new Sort.Order(Sort.Direction.valueOf(jNode.get("direction").asText()),
            jNode.get("property").asText());
            i++;
        }
        return new Sort(orders);

    }
}
*/