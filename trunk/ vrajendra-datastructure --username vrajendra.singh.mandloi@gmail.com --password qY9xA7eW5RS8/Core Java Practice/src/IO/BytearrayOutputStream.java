package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BytearrayOutputStream {

	public void bytearrayOutputStr() throws Exception{
		File filePath = new File("D://text1.txt");
		FileOutputStream out = new FileOutputStream(filePath.getAbsolutePath());
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		bout.write("Hello how are you, Great this is Awsm".getBytes());
		bout.writeTo(out);
		bout.flush();
		bout.close();
		out.close();
		System.out.println("File Writing Done");
	}
	
	public static void main(String[] args) throws Exception{
		new BytearrayOutputStream().bytearrayOutputStr();
	}
}
