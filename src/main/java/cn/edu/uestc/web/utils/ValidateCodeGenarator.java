package cn.edu.uestc.web.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author :glb
 * @date :Created in 15:19 2019/6/19
 * @discription :the genarator of validate code
 */
public class ValidateCodeGenarator {

    // 定义验证码图片的属性并赋予默认值
    private int width = 160;
    private int height = 60;
    private int fontCnt = 4;
    private int lineCnt = 10;
    private OutputStream os;

    private static char[] chars = "23456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private static String[] fontType = new String[] {"Courier", "Arial", "Verdana", "Times", "Tahoma", "Georgia"};
    private static int[] fontStyle = new int[] {Font.BOLD, Font.ITALIC, Font.PLAIN, Font.BOLD|Font.ITALIC};

    public ValidateCodeGenarator(OutputStream os) {
        this.os = os;
    }
    public ValidateCodeGenarator(OutputStream os, int width, int height, int fontCnt) {
        this.width = width;
        this.height = height;
        this.fontCnt = fontCnt;
        this.os = os;
    }
    /**
     * 画验证码图
     */
    public void drawValidateCode(OutputStream os) throws IOException {
        BufferedImage bi = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setColor(new Color(245, 245, 245));
        g.fillRect(0,0, this.width, this.height);
        addInterferenceLines(g, lineCnt);
        int imgSize = height < width/fontCnt ? height : width / fontCnt;
        BufferedImage[] charImgs = new BufferedImage[this.fontCnt];
        char[] codes = generateCode(fontCnt);
        for(int i=0; i<fontCnt; i++) {
            charImgs[i] = generateBufImg(codes[i], imgSize);
            g.drawImage(charImgs[i], null, (int)(imgSize*0.85)*i,0);
        }
        g.dispose();
        ImageIO.write(bi, "gif", os);
    }

    /**
     * 为验证码图片添加随机干扰线
     * @param g
     * @param lineCnt
     */
    private void addInterferenceLines(Graphics2D g, int lineCnt) {
        g.setColor(new Color(50,50,50));
        for (int i=0;i<lineCnt;i++) {
            int x1 = (int)(Math.random()*1000)%width;
            int x2 = (int)(Math.random()*1000)%width;
            int y1 = (int)(Math.random()*1000)%height;
            int y2 = (int)(Math.random()*1000)%height;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 随机生成验证码字符
     * @param fontCnt
     * @return
     */
    private char[] generateCode(int fontCnt) {
        char[] ret = new char[fontCnt];
        for(int i=0;i<fontCnt;i++) {
            ret[i] = chars[(int)(Math.random()*1000)%chars.length];
        }
        return ret;
    }

    /**
     * 生成对应验证码的图片
     * @param ch
     * @return
     */
    private BufferedImage generateBufImg(char ch, int imgSize) {
        String code = String.valueOf(ch);
        BufferedImage bi = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        Color background = new Color(255,255,255,0);
        Color beforeground = generateRandomColor();
        g.setColor(background);
        g.fillRect(0,0,imgSize,imgSize);
        g.setColor(beforeground);
        String fontType = generateRandomFontType();
        int fontSize = generateRandomFontSize(imgSize);
        int fontStyle = generateRandomFontStyle();
        g.setFont(new Font(fontType, fontStyle, fontSize));
        double arch = generateRandomArch();
        int x = (imgSize - fontSize) / 2;
        int y = (imgSize - fontSize) / 2 + fontSize;
        g.rotate(arch, imgSize/2, imgSize/2);
        g.drawString(code, x, y);
        g.dispose();
        return bi;
    }

    /**
     * 随机生成RGB值在0~200之间的颜色
     * @return
     */
    private Color generateRandomColor() {
        int r = (int)(Math.random() * 1000) % 200;
        int g = (int)(Math.random() * 1000) % 200;
        int b = (int)(Math.random() * 1000) % 200;
        Color color = new Color(r,g,b);
        return color;
    }

    /**
     * 随机生成字体的字体类型
     * @return
     */
    private String generateRandomFontType() {
        return fontType[(int)(Math.random()*1000)%fontType.length];
    }

    /**
     * 随机生成字体的样式
     * @return
     */
    private int generateRandomFontStyle() {
        return fontStyle[(int)(Math.random()*1000)%fontStyle.length];
    }

    /**
     * 随机生成字体大小
     * @param imgSize
     * @return
     */
    private int generateRandomFontSize(int imgSize) {
        int max = (int)(0.85 * imgSize);
        int min = (int)(0.75 * imgSize);
        return (int)(Math.random()*1000) % (max - min + 1) + min;
    }

    /**
     * 随机生成旋转角度
     * @return
     */
    private double generateRandomArch() {
        return ((int)(Math.random()*1000)%2 == 0 ? 1 : -1)*(Math.random());
    }

    public static void main(String[] args){
        try{
        FileOutputStream fos = new FileOutputStream("./vcode.gif");
        ValidateCodeGenarator validateCodeGenarator = new ValidateCodeGenarator(fos);
        validateCodeGenarator.drawValidateCode(fos);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
