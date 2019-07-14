//designpatterns.composite.VideoFile.java
package Combination;

import java.util.ArrayList;

public class BranchSchool extends AbstractFile {
	private String name;
	private ArrayList<AbstractFile> teachList = new ArrayList<AbstractFile>();

	public BranchSchool(String name) {
		this.name = name;
	}

	public void add(AbstractFile file) {
	   teachList.add(file);
	}

	public void remove(AbstractFile file) {
		teachList.remove(file);
	}
	
	public AbstractFile getChild(int i) {

		return teachList.get(i);
	}

	@Override
	public void pass() {
		System.out.println("文件下发到----" + name );

		for (Object obj:teachList) {
			((AbstractFile)obj).pass();
		}
	}

}