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
<<<<<<< HEAD:encontra-lucene-engine/src/main/java/pt/inevo/encontra/lucene/ImageObject.java
public class ImageObject extends AbstractObject<String,BufferedImage> {

    public ImageObject(BufferedImage image, String identifier){
=======
public class ImageObject<I> extends AbstractObject<I,BufferedImage> {
    public ImageObject() {
        super();
    }
    public ImageObject(I identifier,BufferedImage image){
>>>>>>> 545adf864a876185843fe635cde7171cd5d26d22:encontra-image/encontra-image-core/src/main/java/pt/inevo/encontra/image/ImageObject.java
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
