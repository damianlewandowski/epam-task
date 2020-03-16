package com.lewandowski.extension;

import com.lewandowski.ExtensionExtractor;

import java.util.ArrayList;
import java.util.List;

public class ExtensionFactory {
    public static List<IExtension> createAllSupportedExtensions(ExtensionExtractor extensionExtractor) {
        List<IExtension> extensions = new ArrayList<>();

        int[] pngMagicNumbers = {0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};
        Extension pngExtension = new Extension("png", pngMagicNumbers, extensionExtractor);

        int[] jpgMagicNumbers = {0xff, 0xd8, 0xff, 0xe0};
        Extension jpgExtension = new Extension("jpg", jpgMagicNumbers, extensionExtractor);

        int[] gifMagicNumbers = {0x47, 0x49, 0x46, 0x38};
        Extension gifExtension = new Extension("gif", gifMagicNumbers, extensionExtractor);

        extensions.add(pngExtension);
        extensions.add(jpgExtension);
        extensions.add(gifExtension);

        return extensions;
    }
}
