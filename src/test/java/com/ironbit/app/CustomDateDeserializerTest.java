package com.ironbit.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.ironbit.app.utillities.CustomDateDeserializer;

class CustomDateDeserializerTest {
	@Mock
    private JsonParser jsonParser;

    @Mock
    private DeserializationContext deserializationContext;

    
	@Test
	@SuppressWarnings("deprecation")
    public void testDeserialize() throws Exception {
        MockitoAnnotations.initMocks(this);
        String dateStr = "15-05-1990";
        when(jsonParser.getText()).thenReturn(dateStr);
        CustomDateDeserializer dateDeserializer = new CustomDateDeserializer();
        Date date = dateDeserializer.deserialize(jsonParser, deserializationContext);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        assertEquals(dateFormat.parse(dateStr), date);
    }
    
    @Test
    @SuppressWarnings("deprecation")
    public void testDeserializeWithParseException() throws Exception {
    	MockitoAnnotations.initMocks(this);
	    String dateStr = "formatoincorrecto";
	    when(jsonParser.getText()).thenReturn(dateStr);
	    CustomDateDeserializer dateDeserializer = new CustomDateDeserializer();
	    assertThrows(RuntimeException.class, () -> {
	    	jsonParser.getText();
	        dateDeserializer.deserialize(jsonParser, deserializationContext);
	    });
    }
}
