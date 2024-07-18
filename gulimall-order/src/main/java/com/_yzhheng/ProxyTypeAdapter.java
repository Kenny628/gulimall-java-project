package com._yzhheng;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Proxy;

public class ProxyTypeAdapter extends TypeAdapter<Proxy> {

    @Override
    public void write(JsonWriter out, Proxy value) throws IOException {
        out.beginObject();
        out.name("type").value(value.type().toString());
        // Serialize other fields as needed
        out.endObject();
    }

    @Override
    public Proxy read(JsonReader in) throws IOException {
        in.beginObject();
        Proxy.Type type = null;
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "type":
                    type = Proxy.Type.valueOf(in.nextString());
                    break;
                // Deserialize other fields as needed
            }
        }
        in.endObject();
        return new Proxy(type, null); // Use the deserialized fields to construct the Proxy object
    }

    // Register the custom TypeAdapter
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(Proxy.class, new ProxyTypeAdapter())
            .create();

}
