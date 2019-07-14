//designpatterns.builder.DevilBuilder.java
package Builder;

public class ServerBuilder extends ActorBuilder {
	@Override
	public void buildType() {
		actor.setType("Server");
	}

	@Override
	public void buildMemory() {
		actor.setMemory("Server---Memory");
	}

	@Override
	public void buildCPU() {
		actor.setCPU("Server---CPU");
	}

	@Override
	public void buildHardDisk() {
		actor.setHardDisk("Server---Disk");
	}

	@Override
	public void buildHost() {
		actor.setHost("Server---Host");
	}

	@Override
	public void buildDisplay() {
		actor.setDisplay("Server---Display");
	}
}