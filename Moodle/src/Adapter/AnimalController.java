//designpatterns.adapter.AnimalController.java
package Adapter;

//汽车控制类，充当目标抽象类
public abstract class AnimalController {
	public void move() {
		System.out.println("动物移动！");
	}
	
	public abstract void speak(); //发出声音
	public abstract void catchs(); //灯光闪烁
}