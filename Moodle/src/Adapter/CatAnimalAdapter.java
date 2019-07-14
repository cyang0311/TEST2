//designpatterns.adapter.CatAnimalAdapter.java
package Adapter;

//救护车适配器，充当适配器
public class CatAnimalAdapter extends AnimalController {
	private CatSpeak sound;  //定义适配者AmbulanceSound对象
	private CatCatchs catchs;    //定义适配者AmbulanceLamp对象
	
	public CatAnimalAdapter() {
		sound = new CatSpeak();
		catchs = new CatCatchs();
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