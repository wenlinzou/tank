package test;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * description：
 *
 * @author wenlinzou
 * @date 2021/1/4
 */
public class ImageTest {

    @Test
    public void test() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("/Users/xxx/Desktop/WechatIMG24.jpeg"));
            assertNotNull(bufferedImage);

            BufferedImage bufferedImage1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            //this.getClass()
            assertNotNull(bufferedImage1);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        fail("Not yet implemented");
    }

}
