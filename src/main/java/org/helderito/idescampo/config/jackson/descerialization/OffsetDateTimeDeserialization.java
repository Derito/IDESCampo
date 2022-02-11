package org.helderito.idescampo.config.jackson.descerialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.helderito.idescampo.util.JavaTimeUtil;

import java.io.IOException;
import java.time.OffsetTime;

public class OffsetDateTimeDeserialization extends StdDeserializer<OffsetTime> {

    private static final long serialVersionUID = 1L;

    public OffsetDateTimeDeserialization() {
        super(OffsetTime.class);
    }

    @Override
    public OffsetTime deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        return OffsetTime.parse(parser.readValueAs(String.class), JavaTimeUtil.OFF_SET_DATE_TIME_FORMATTER);
    }
}
