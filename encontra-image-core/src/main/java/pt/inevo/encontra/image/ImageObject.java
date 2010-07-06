package pt.inevo.encontra.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pt.inevo.encontra.index.AbstractObject;

/**
 * Image Object for the EnConTRA API
 * @author ricardo
 */
public class ImageObject<I> extends AbstractObject<I,BufferedImage> {
    public ImageObject() {
        super();
    }
    public ImageObject(I identifier,BufferedImage image){
        super(identifier, image);
    }


    public void setImage(String imagePath){
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            setObject(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
