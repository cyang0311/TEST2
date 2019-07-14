//designpatterns.builder.HeroBuilder.java
package Builder;

public class DesktopBuilder extends ActorBuilder {
	@Override
	public void buildType() {
		actor.setType("Desktop");
	}

	@Override
	public void buildMemory() {
		actor.setMemory("Desktop---Memory");
	}

	@Override
	public void buildCPU() {
		actor.setCPU("Desktop---CPU");
	}

	@Override
	public void buildHardDisk() {
		actor.setHardDisk("Desktop---Disk");
	}

	@Override
	public void buildHost() {
		actor.setHost("Desktop---Host");
	}

	@Override
	public void buildDisplay() {
		actor.setDisplay("Desktop---Display");
	}
}