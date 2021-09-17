package check;

import constants.Constants;

public class Check {
	
	private static String firstName = "井上";
	private static String lastName = "輝成";
	
	private static String printName(String firstName, String lastName) {
		return firstName + lastName;
	}
	
	public static void main(String[] args) {
		
		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		RobotPet rpet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		
		System.out.println("printNameメソッド → " + printName(firstName,lastName));
		pet.introduce();
		rpet.introduce();
	}
}