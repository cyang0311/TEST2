//designpatterns.adapter.DogAnimalAdapter.java
package Adapter;

//警车适配器，充当适配器
public class DogAnimalAdapter extends AnimalController {
	private DogSound sound;  //定义适配者PoliceSound对象
	private DogCatchs catchs;   //定义适配者PoliceLamp对象
	
	public DogAnimalAdapter() {
		sound = new DogSound();
		catchs = new DogCatchs();
	}


	@Override
	public void speak() {
		sound.alarmSound();
	}

	@Override
	public void catchs() {
		catchs.alarmLamp();
	}
}