package ru.aston.trainee.team3_library.jwt;

import java.util.concurrent.ConcurrentHashMap;

public class TokenMapUtil {
    private static ConcurrentHashMap<String, String> tokenStorageMap = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, String> getTokenStorageConcurrentHashMap() {
        return tokenStorageMap;
    }
}
