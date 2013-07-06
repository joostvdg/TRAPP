package org.jiji.trapp.web.config;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * @author iColumbo@IRN
 * 
 */
public class Iso8601Serializer extends JsonSerializer<DateTime>
{

    private final DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

    @Override
    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
        gen.writeString(formatter.print(value));
    }

    @Override
    public Class<DateTime> handledType() {
        return DateTime.class;
    }
}