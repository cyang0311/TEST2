//designpatterns.builder.AngelBuilder.java
package Builder;

public class NotebookBuilder extends ActorBuilder {
	@Override
	public void buildType() {
		actor.setType("Notebook");
	}

	@Override
	public void buildMemory() {
		actor.setMemory("Notebook---Memory");
	}

	@Override
	public void buildCPU() {
		actor.setCPU("Notebook---CPU");
	}

	@Override
	public void buildHardDisk() {
		actor.setHardDisk("Notebook---Disk");
	}

	@Override
	public void buildHost() {
		actor.setHost("Notebook---Host");
	}

	@Override
	public void buildDisplay() {
		actor.setDisplay("Notebook---Display");
	}

}