package pt.inevo.encontra.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Image Object for the EnConTRA API
 * @author ricardo
 */
public class Image {
    private String imagePath;
    private BufferedImage image;
    
    public Image() {
        super();
    }
    public Image(BufferedImage image){
        this.image=image;
    }


    public Image(String imagePath){
        try {
            this.imagePath=imagePath;
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
