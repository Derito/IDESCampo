package org.helderito.idescampo.config.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.helderito.idescampo.config.jackson.descerialization.LocalDateDeserialization;
import org.helderito.idescampo.config.jackson.descerialization.OffsetDateTimeDeserialization;
import org.helderito.idescampo.config.jackson.serialization.LocalDateSerialization;
import org.helderito.idescampo.config.jackson.serialization.OffsetDateTimeSerialization;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Configuration
public class ObjectMapperConfig implements Jackson2ObjectMapperBuilderCustomizer {


    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        jacksonObjectMapperBuilder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .serializerByType(LocalDate.class, new LocalDateSerialization())
                .serializerByType(OffsetDateTime.class, new OffsetDateTimeSerialization())
                .deserializerByType(LocalDate.class, new LocalDateDeserialization())
                .deserializerByType(OffsetDateTime.class, new OffsetDateTimeDeserialization());
    }
}
