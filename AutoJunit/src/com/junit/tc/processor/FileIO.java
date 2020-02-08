package com.junit.tc.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	public static void testFileWriter (String className, String content, String file) {
		BufferedWriter bwr=null;
		try{
			bwr=new BufferedWriter(new FileWriter(new File(file)));
			
			bwr.write(content);

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				bwr.flush();
				bwr.close();
			}catch(IOException e){

				e.printStackTrace();
			}

		}
	}
}
