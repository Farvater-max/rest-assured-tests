package utils;

import lombok.experimental.UtilityClass;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@UtilityClass
public class BuildUrlUtils {

    public static final String BASE_URL_GET = "https://restcountries.com/v3.1/";
    public static final String BASE_URL_POST = "https://api.restful-api.dev/";

    public static String buildPostUrl(String endpoint) {
        StringBuilder url = new StringBuilder(BASE_URL_POST);
        url.append(endpoint);

        return url.toString();
    }

    public static String buildGetUrl(String endpoint) {
        StringBuilder url = new StringBuilder(BASE_URL_GET);
        url.append(endpoint);

        return url.toString();
    }

    /**
     * Creates a full URL by appending the endpoint and query parameters to the base URL.
     *
     * @param endpoint The endpoint to append to the base URL (e.g., "name").
     * @param params   A map of query parameters and their values.
     * @return The full URL as a string.
     */
    public static String buildGetUrl(String endpoint, Map<String, String> params) {
        StringBuilder url = new StringBuilder(BASE_URL_GET);
        if (endpoint != null && !endpoint.isEmpty()) {
            url.append(endpoint);
        }

        if (params != null && !params.isEmpty()) {
            url.append("?");
            params.forEach((key, value) -> {
                String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8);
                String encodedValue = URLEncoder.encode(value, StandardCharsets.UTF_8);
                url.append(encodedKey).append("=").append(encodedValue).append("&");
            });
            url.setLength(url.length() - 1);
        }

        return url.toString();
    }
}
