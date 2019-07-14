//designpatterns.composite.Folder.java
package Combination;

import java.util.ArrayList;

public class School extends AbstractFile {
	//定义集合fileList，用于存储AbstractFile类型的成员
	private ArrayList<AbstractFile> SchoolList=new ArrayList<AbstractFile>();
	private String name;
		
	public School(String name) {
		this.name = name;
	}
	
	public void add(AbstractFile file) {
		SchoolList.add(file);
	}
	
	public void remove(AbstractFile file) {
		SchoolList.remove(file);
	}
	
	public AbstractFile getChild(int i) {
		return (AbstractFile)SchoolList.get(i);
	}

	@Override
	public void pass() {
		System.out.println("文件下发到----" + name);  //模拟杀毒

		//递归调用成员构件的killVirus()方法
		for(Object obj : SchoolList) {
			((AbstractFile)obj).pass();
		}
	}

}