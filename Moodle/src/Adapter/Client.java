
package Adapter;

/**
 * 适配器模式
 */
public class Client {
	public static void main(String args[]) {
		AnimalController animal ;
		animal = (AnimalController) XMLUtil.getBean();
		animal.move();
		animal.speak();
		animal.catchs();
	}
}