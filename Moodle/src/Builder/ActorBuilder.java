//designpatterns.builder.ActorBuilder.java
package Builder;

public abstract class ActorBuilder {
	protected Actor actor = new Actor();

	public abstract void buildType();
	public abstract void buildMemory();
	public abstract void buildCPU();
	public abstract void buildHardDisk();
	public abstract void buildHost();
	public abstract void buildDisplay();

    //工厂方法，返回一个完整的游戏角色对象
	public Actor createActor() {
		return actor;
	}
}