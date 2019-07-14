//designpatterns.builder.Client.java
package Builder;

/**
 * 建造者模式
 */
public class Client {
	public static void main(String args[]) {
		ActorBuilder ab; //针对抽象建造者编程
		ab = (ActorBuilder)XMLUtil.getBean(); //反射生成具体建造者对象

        ActorController ac = new ActorController();
		Actor actor;
		actor = ac.construct(ab); //通过指挥者创建完整的建造者对象

		String type = actor.getType();
		System.out.println(type + "的属性：");
		System.out.println("内存：" + actor.getMemory());
		System.out.println("CPU：" + actor.getCPU());
		System.out.println("硬盘：" + actor.getHardDisk());
		System.out.println("主机：" + actor.getHost());
		System.out.println("显示器：" + actor.getDisplay());
	}
}