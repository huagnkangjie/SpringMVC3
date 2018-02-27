package test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoteFile {
	public static void readFile(String sourceFilePath, String encode) throws IOException{
		  File file = new File(sourceFilePath);
		  BufferedReader br=    new BufferedReader(
				     new InputStreamReader(new FileInputStream(sourceFilePath),encode));// utf-8编码
		  StringBuilder strBuilder = new StringBuilder();
		  String sLine = null;   
		  while((sLine = br.readLine()) != null){
		   strBuilder.append(sLine);
		   strBuilder.append("\r\n");
		  }
		  br.close();
		  System.out.println(strBuilder.toString());
		 }
		 
		public static String[] getFileNames(String path){
		  File dirFile = new File(path);
		  if(dirFile.isDirectory()){
		   File[] files = dirFile.listFiles();
		   String[] fileNames = new String[files.length];
		   for(int i=0;i<files.length;i++){
		    fileNames[i] = files[i].getAbsolutePath();
		   }
		   return fileNames;
		  }else{
		   return null;
		  }
		 }
		 
		public static void main(String[] args) throws IOException{
		  //读取单个文件
		  readFile("\\\\192.168.1.56\\F:\\1.txt","utf-8");
		 
		  //读取某个目录下所有文件
//		  String[] fileNames = getFileNames("\\\\192.168.0.100\\public\\aa");
//		  String encode = "utf-8";
//		  for(String fileName : fileNames){
//			   try {
//			    readFile(fileName, encode);
//			   } catch (IOException e) {
//			   e.printStackTrace();
//			   }
//		  }
		}
}
