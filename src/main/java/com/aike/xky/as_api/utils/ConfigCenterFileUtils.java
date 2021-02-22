package com.aike.xky.as_api.utils;

import com.aike.xky.as_api.entity.ConfigCenterEntity;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/22 2:52 下午
 */
public class ConfigCenterFileUtils {
    private static final String APPEND = "file/as/";
    private static String targetDir = PropertyUtil.getDocPath(APPEND);
    private static final String CND_PREFIX = PropertyUtil.getCNDPrefix(APPEND);

    public static void saveContent(ConfigCenterEntity entity) {
        String fileName = genFileName(entity.getNamespance(), entity.getVersion());
        entity.setOriginalUrl(realSaveContent(fileName, entity.getContent()));
        entity.setJsonUrl(realSaveContent(fileName + ".json", JsonUtils.object2Json(entity.getContentMap())));
    }

    private static String genFileName(String namespace, String version) {
        return namespace + "_" + version;
    }

    private static String realSaveContent(String fileName, String content) {
        FileOutputStream fileOutputStream = null;
        File tempFile = null;
        String cdnUrl = null;
        try {
            File targetFile = new File(targetDir, fileName);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            tempFile = File.createTempFile(fileName, ".temp", targetFile.getParentFile());
            fileOutputStream = new FileOutputStream(tempFile);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            tempFile.renameTo(targetFile);
            cdnUrl = CND_PREFIX + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtils.close(fileOutputStream);
            FileUtils.deleteFile(tempFile);
        }
        return cdnUrl;
    }
}
