package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedInputStr {
/* Buffered input and output stream to increase the efficiency of reading and writing files.
*/
	public static void main(String[] args) throws Exception {
		File filePath = new File("D://text3.txt");
		FileInputStream in = new FileInputStream(filePath.getAbsolutePath());
		BufferedInputStream bis = new BufferedInputStream(in);
		
		File filePath2 = new File("D://text4.txt");
		FileOutputStream fout = new FileOutputStream(filePath2.getAbsolutePath());
		BufferedOutputStream bos = new BufferedOutputStream(fout);
		
		int i=0;
		while((i=bis.read())!=-1){
			bos.write((char)i);
		}
		
		bos.close();
		bis.close();
		System.out.println("success");
	}
}
