package dk.kb.api.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

public abstract class ImageHash {
    private static final Logger log = LoggerFactory.getLogger(ImageHash.class);
    private URL imgURL;
    private Path hashPath;
    private int noBit;
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Path getHashPath() {
        return hashPath;
    }

    public int getNoBit() {
        return noBit;
    }

    public URL getImgURL() {
        return imgURL;
    }

    public void setNoBit(int noBit) {
        this.noBit = noBit;
    }

    public void setHashPath(Path hashPath) {
        this.hashPath = hashPath;
    }

    public ImageHash(String imgURL, Integer start, Integer end) {
        try {
            this.imgURL = new URL(imgURL);
            this.start = start == null ? 1 : start;
            this.end = end == null ? 16 : end;
        } catch (MalformedURLException e) {
            log.error("A file error appeared", e);
        }
    }
}
