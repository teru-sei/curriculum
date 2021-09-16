package check;

import constants.Constants;

public class Check {
	
	private static String firstName = "井上";
	private static String lastName = "輝成";
	
	private static String printName(String firstName, String lastName) {
		return firstName + lastName;
	}
	
	static Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
	static RobotPet rpet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
	
	
	public static void main(String[] args) {
		System.out.println("printNameメソッド → " + printName(firstName,lastName));
		pet.introduce();
		rpet.introduce();
	}
}