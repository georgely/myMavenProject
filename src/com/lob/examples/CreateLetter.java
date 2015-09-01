package com.lob.examples;

import java.util.Map;

import com.google.common.collect.Maps;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.LetterRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.LetterResponse;

public class CreateLetter extends BaseExample{
	public static void main(final String[] args) throws Exception {
        final String apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc"; // Replace this API key with your own.
        final LobClient client = AsyncLobClient.createDefault(apiKey);

        // Creating an Address Object
        final AddressRequest exampleAddressRequest = AddressRequest.builder()
            .name("Joe Smith")
            .line1("104, Printing Boulevard")
            .city("Boston")
            .state("MA")
            .country("us")
            .zip("12345")
            .build();
        final AddressResponse exampleAddressResponse = client.createAddress(exampleAddressRequest).get();
	
	
        //Creating Letter
        // Request with HTML
        final Map<String, String> data = Maps.newHashMap();
        data.put("name", "Harry");
        
        final LetterRequest letterRequest = LetterRequest.builder()
          .description("Demo Letter")
          .to(AddressRequest.builder()
            .name("Harry Zhang")
            .line1("123 Test Street")
            .city("Mountain View")
            .state("CA")
            .zip("94041")
            .country("US")
            .build())
          .from(AddressRequest.builder()
            .name("Ami Wang")
            .line1("123 Test Avenue")
            .city("Seattle")
            .state("WA")
            .zip("94041")
            .country("US")
            .build())
          .file("<html style='padding-top: 3in; margin: .5in;'>HTML Letter for {{name}}</html>")
          .color(true)
          .build();
        
        final LetterResponse letter = client.createLetter(letterRequest).get();
        
        printResponse("letter Response", letter);
	
	}
}
