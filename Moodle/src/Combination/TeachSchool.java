//designpatterns.composite.ImageFile.java
package Combination;

import java.util.ArrayList;

public class TeachSchool extends AbstractFile {
	private String name;
	private ArrayList<AbstractFile> officeList = new ArrayList<AbstractFile>();

	public TeachSchool(String name) {
		this.name = name;
	}

	public void add(AbstractFile file) {
	   officeList.add(file);
	}

	public void remove(AbstractFile file) {
		officeList.remove(file);
	}
	
	public AbstractFile getChild(int i) {
		return officeList.get(i);
	}

	@Override
	public void pass() {
		System.out.println("文件下发到----" + name );
		for (Object obj:officeList) {
			((AbstractFile)obj).pass();
		}
	}
}