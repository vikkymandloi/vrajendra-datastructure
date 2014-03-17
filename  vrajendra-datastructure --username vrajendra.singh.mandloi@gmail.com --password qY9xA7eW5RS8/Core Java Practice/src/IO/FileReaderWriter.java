package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	/* File reading and file Writing are best suited for reading text from files. 
	 * these classes are been suggested by Sun micro-system itself.
	*/
	public static void Fileread() throws IOException, FileNotFoundException {
		File filePath = new File("D://text3.txt");
		FileReader reader = new FileReader(filePath.getAbsolutePath());
		
		File filePath2 = new File("D://text5.txt");
		FileWriter writer = new FileWriter(filePath2.getAbsolutePath());
		
		int i= 0;
		while((i=reader.read()) != -1)
			writer.append((char)i);
		reader.close();
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		Fileread();
	}
}
