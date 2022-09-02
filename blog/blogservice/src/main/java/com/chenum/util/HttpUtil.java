package com.chenum.util;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpUtil {

    CloseableHttpClient client = HttpClientBuilder.create().build();

}
