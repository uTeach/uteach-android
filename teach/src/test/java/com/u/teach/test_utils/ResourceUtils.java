package com.u.teach.test_utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by saguilera on 1/19/17.
 */

public class ResourceUtils {

    public static <T> T fromRaw(String resource, Class<T> tClass) throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("./raw/" + resource);
        Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        return new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create().fromJson(reader, tClass);
    }

}
