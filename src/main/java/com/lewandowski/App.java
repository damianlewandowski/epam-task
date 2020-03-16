package com.lewandowski;

import com.lewandowski.extension.ExtensionFactory;
import com.lewandowski.extension.IExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("At least 1 file needs to be passed.\nUsage: java -jar App fileA fileB fileC");
        }

        ExtensionExtractor extensionExtractor = new ExtensionExtractor();

        List<File> files = new ArrayList<>();
        List<IExtension> extensions = ExtensionFactory.createAllSupportedExtensions(extensionExtractor);

        for (String filename : args) {
            File file = new File(filename);
            files.add(file);
        }


        for (File file : files) {
            boolean isExtensionSupported = false;

            for (IExtension extension : extensions) {
                if (extension.isExtensionLegit(file)) {
                    isExtensionSupported = true;
                }
            }

            if (!isExtensionSupported) {
                throw new IllegalArgumentException("Extension is not supported.");
            }
        }


    }
}
