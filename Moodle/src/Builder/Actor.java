//designpatterns.builder.Actor.java
package Builder;

public class Actor {
	private String Type;
	private String CPU; //角色类型
	private String memory; //性别
	private String hardDisk; //脸型
	private String host; //服装
	private String display; //发型

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String CPU) {
		this.CPU = CPU;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
