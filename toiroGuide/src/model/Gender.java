package model;

public class Gender {

	private int gender_id;
	private String genderType;

	public Gender() {}

	public Gender(String genderType, int gender_id) {
		this.genderType = genderType;
		this.gender_id = gender_id;
	}

	public String getGenderType() {
		return genderType;
	}

	public int getGender_id() {
		return gender_id;
	}

}
