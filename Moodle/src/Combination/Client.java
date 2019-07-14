//designpatterns.composite.Factory.Client.java
package Combination;

/**
 * 组合模式
 */
public class Client {
	public static void main(String args[]) {
        //针对抽象构件编程
		AbstractFile school,school1,teach1,teach2,office1,office2,office3,office4,office5,office6,office7,office8;
		school = new School("北京总部");
		school1 = new BranchSchool("湖南分校");

		teach1 = new TeachSchool("长沙教学点");
		teach2 = new TeachSchool("湘潭教学点");

		office1 = new Office("北京--教务办公室");
		office2 = new Office("北京--行政办公室");
		office3 = new Office("湖南--教务办公室");
		office4 = new Office("湖南--行政办公室");
		office5 = new Office("长沙--教务办公室");
		office6 = new Office("长沙--行政办公室");
		office7 = new Office("湘潭--教务办公室");
		office8 = new Office("湘潭--行政办公室");

		school.add(school1);
		school.add(office1);
		school.add(office2);
		school1.add(teach1);
		school1.add(teach2);
		school1.add(office3);
		school1.add(office4);
		teach1.add(office5);
		teach1.add(office6);
		teach2.add(office7);
		teach2.add(office8);

		
        //从“Sunny的资料”结点开始进行杀毒操作
		school.pass();
	}
}