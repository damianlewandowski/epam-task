package com.lewandowski;

public class ExtensionExtractor {
    public String extractExtension(String filename) {
        int lastIndexOf = filename.lastIndexOf(".");
        // No extension was passed, just the filename e.g. httpconf file
        if (lastIndexOf == -1) {
            return "";
        }
        return filename.substring(lastIndexOf + 1);
    }
}
