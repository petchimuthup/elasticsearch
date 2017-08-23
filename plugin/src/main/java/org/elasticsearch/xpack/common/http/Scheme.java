/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.common.http;

import java.util.Locale;

public enum Scheme {

    HTTP("http", 80),
    HTTPS("https", 443);

    private final String scheme;
    private final int defaultPort;

    Scheme(String scheme, int defaultPort) {
        this.scheme = scheme;
        this.defaultPort = defaultPort;
    }

    public String scheme() {
        return scheme;
    }

    public int defaultPort() {
        return defaultPort;
    }

    public static Scheme parse(String value) {
        value = value.toLowerCase(Locale.ROOT);
        switch (value) {
            case "http":
                return HTTP;
            case "https":
                return HTTPS;
            default:
                throw new IllegalArgumentException("unsupported http scheme [" + value + "]");
        }
    }

    public String value() {
        return name().toLowerCase(Locale.ROOT);
    }
}
