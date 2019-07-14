//designpatterns.composite.TextFile.java
package Combination;

public class Office extends AbstractFile {
	private String name;
	
	public Office(String name) {
		this.name = name;
	}
	
	public void add(AbstractFile file) {
	   System.out.println("对不起，不支持该方法！");
	}
	
	public void remove(AbstractFile file) {
		System.out.println("对不起，不支持该方法！");
	}
	
	public AbstractFile getChild(int i) {
		System.out.println("对不起，不支持该方法！");
		return null;
	}

	@Override
	public void pass() {
		System.out.println("文件下发到----" + name );
	}

}