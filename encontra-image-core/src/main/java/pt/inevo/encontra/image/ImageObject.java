package pt.inevo.encontra.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import pt.inevo.encontra.index.AbstractObject;
import pt.inevo.encontra.storage.IEntry;
import pt.inevo.encontra.storage.StorableObject;

/**
 * Image Object for the EnConTRA API
 * @author ricardo
 */
public class ImageObject<ID extends Serializable> extends StorableObject<ID,BufferedImage,String> {
    private String imagePath;

    public ImageObject() {
        super();
    }
    public ImageObject(ID identifier,BufferedImage image){
        super(identifier, image);
    }


    public void setImage(String imagePath){
        try {
            this.imagePath=imagePath;
            BufferedImage image = ImageIO.read(new File(imagePath));
            setObject(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getValue() {
        return this.imagePath;
    }

    @Override
    public void setValue(String imagePath) {
        setImage(imagePath);
    }
}
