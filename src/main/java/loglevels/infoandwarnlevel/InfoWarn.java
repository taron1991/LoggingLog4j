package loglevels.infoandwarnlevel;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class InfoWarn {

    private static final Logger logger = LoggerFactory.getLogger(InfoWarn.class);

    public boolean saveFile(FileData file) {
        logger.info("сохраняем файл " + file.getName());
        boolean resultOK = SaveUtils.save(file);
        if (resultOK) {
            return;
        }

        logger.warn("проблема с записью файла " + file.getName());
        String filename = Dialog.selectFile();
        boolean result = SaveUtils.save(file, filename);
        return result;
    }
}
