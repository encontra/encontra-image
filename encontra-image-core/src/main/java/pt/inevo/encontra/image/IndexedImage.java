package pt.inevo.encontra.image;

import pt.inevo.encontra.index.IndexedObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 * Image Object for the EnConTRA API
 * @author ricardo
 */
public class IndexedImage<ID extends Serializable> extends IndexedObject<ID,BufferedImage> {
    private String imagePath;
    
    public IndexedImage() {
        super();
    }
    public IndexedImage(BufferedImage image){
        this.object=image;
    }


    public IndexedImage(String imagePath){
        try {
            this.imagePath=imagePath;
            object = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
