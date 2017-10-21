package com.java.setname;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangName {
	public void ChangeName(List<String> list,String path) {
		File file=new File("F:\\WEBshuju\\sdf");
		File[] files=file.listFiles();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println(list.size());
		System.out.println(files.length);
		int i=0;
		while(i<list.size()){
			String newName=list.get(i);
			boolean flag=files[i].renameTo(new File(path+newName+".mp4"));
			System.out.println(flag);
			i++;
		}
	}
	
	public  List<String> getListName(String path) {
		int lineNum = 0;
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(new File(path+"\\目录.txt"));
			br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				lineNum++;
				if (lineNum != 1) {
					int length = str.length();
					if (length != 0) {
						str = str.substring(0, length - 5);
					}
					list.add(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
