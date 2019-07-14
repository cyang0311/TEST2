//designpatterns.builder.ActorController.java
package Builder;

public class ActorController {
    //逐步构建复杂产品对象
	public Actor construct(ActorBuilder ab) {
		Actor actor;
		ab.buildType();
		ab.buildMemory();
		ab.buildCPU();
		ab.buildHardDisk();
		ab.buildHost();
		ab.buildDisplay();

		actor=ab.createActor();
		return actor;
	}
}