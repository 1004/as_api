package com.aike.xky.as_api.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/22 2:56 下午
 */
public class FileUtils {
    public static final void close(Closeable closeable){
        if (closeable != null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static final void deleteFile(File file){
        if (file != null && file.exists()){
            file.delete();
        }
    }
}
