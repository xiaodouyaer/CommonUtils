package com.liuchaoya.commonutils.tools;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by LiuChaoya on 2017/11/15 16:48.
 * email  1090969255@qq.com
 */

public class StringNullAdapter extends TypeAdapter<String> {

    @Override
    public String read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return "";
        }
        return reader.nextString();
    }

    @Override
    public void write(JsonWriter writer, String value) throws IOException {
        if (value == null) {
            writer.value("");
            return;
        }
        writer.value(value);
    }
}
