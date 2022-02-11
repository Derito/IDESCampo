package org.helderito.idescampo.config.jackson.descerialization;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.helderito.idescampo.util.JavaTimeUtil;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateDeserialization extends StdDeserializer<LocalDate> {
    private static final long serialVersionUID = 1L;

    public LocalDateDeserialization() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(final JsonParser parser, final DeserializationContext deserializationContext) throws IOException, JacksonException {
        return LocalDate.parse(parser.readValueAs(String.class), JavaTimeUtil.LOCAL_DATE_FORMATTER);
    }
}
