package com.sys.systemctl;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
public class Test {
    public static void main(String[] args) throws Exception{
        // 此方法仅适用于JdK1.6及以上版本
       // Desktop.getDesktop().browse(new URL("//www.jb51.net/").toURI());
        Robot robot = new Robot();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    robot.delay(3000);
                    Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
                    int width = (int) d.getWidth();
                    int height = (int) d.getHeight();
                    Image image = robot.createScreenCapture(new Rectangle(0, 0, width,height));
                    BufferedImage bi = new BufferedImage(width, height,
                            BufferedImage.TYPE_INT_RGB);
                    //上传图片

                    Graphics g = bi.createGraphics();
                    g.drawImage(image, 0, 0, width, height, null);
                    // 保存图片
                    try {
                        String s = UUID.randomUUID().toString().replace("-","").toLowerCase();
                        ImageIO.write(bi, "jpg", new File("d:/ccc/"+s+".jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }
}
