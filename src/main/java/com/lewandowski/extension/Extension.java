package com.lewandowski.extension;

import com.lewandowski.ExtensionExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Extension implements IExtension {
    private String extension;
    private int[] magicNumbers;
    private ExtensionExtractor extensionExtractor;

    public Extension(final String extension, final int[] magicNumbers, ExtensionExtractor extensionExtractor) {
        this.extension = extension;
        this.magicNumbers = magicNumbers;
        this.extensionExtractor = extensionExtractor;
    }

    private boolean isByteEqual(byte fileByte, int magicNumber) {
        return Byte.toUnsignedInt(fileByte) == magicNumber;
    }

    public boolean isExtensionLegit(File file) {
        String filename = file.getName();

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filename);

            byte[] signature = new byte[4];
            fileInputStream.read(signature);

            for (int i = 0; i < signature.length; i++) {
                // Not supported by this object
                if (!isByteEqual(signature[i], magicNumbers[i])) {
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        String providedExtensionByTheUser = extensionExtractor.extractExtension(filename);

        // File's extension provided by the user is supported by this object
        if (providedExtensionByTheUser.equals(extension)) {
            System.out.println(String.format("A %s is %s.", providedExtensionByTheUser, extension));
            return true;
        }

        // Extension provided by the user is different than the extension this object supports
        // and yet they are the same.
        System.out.println(String.format("Extension is %s, while actually it's a %s.", providedExtensionByTheUser, extension));
        return true;
    }
}
