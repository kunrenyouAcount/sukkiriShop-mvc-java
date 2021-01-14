package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageTest {

	public static void main(String[] args) {

	}
	/**
	* イメージ→バイト列に変換
	* @param img イメージデータ
	* @param format フォーマット名
	* @return バイト列
	*/
	public static byte[] getBytesFromImage(BufferedImage img, String format) throws IOException{

	if(format == null) {
	format = "png";
	}
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ImageIO.write(img, format, baos);
	return baos.toByteArray();
	}

	/**

	* バイト列→イメージを作成
	* @param bytes
	* @return イメージデータ
	*/
	public static BufferedImage getImageFromBytes(byte[] bytes) throws IOException{
	ByteArrayInputStream baos = new ByteArrayInputStream(bytes);
	BufferedImage img = ImageIO.read(baos);
	return img;
	}
}
