package org.helderito.idescampo.config.jackson.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.helderito.idescampo.util.JavaTimeUtil;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

public class OffsetDateTimeSerialization extends StdSerializer<OffsetTime> {

    private static final long serialVersionUID = 1L;

    public OffsetDateTimeSerialization() {
        super(OffsetTime.class);
    }

    @Override
    public void serialize(final OffsetTime value, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeString(value.format(JavaTimeUtil.OFF_SET_DATE_TIME_FORMATTER));
    }
}
