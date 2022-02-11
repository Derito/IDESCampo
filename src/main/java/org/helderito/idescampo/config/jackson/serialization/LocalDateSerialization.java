package org.helderito.idescampo.config.jackson.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.helderito.idescampo.util.JavaTimeUtil;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateSerialization extends StdSerializer<LocalDate> {
    private static final long serialVersionUID = 1L;

    public LocalDateSerialization() {
        super(LocalDate.class);
    }

    @Override
    public void serialize(final LocalDate value, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeString(value.format(JavaTimeUtil.LOCAL_DATE_FORMATTER));
    }
}
