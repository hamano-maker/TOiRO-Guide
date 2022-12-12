package model;

public class Guide {

	private String kanjiName;
	private String kanaName;
	private String birthday;
	private int gender;
	private int guide_id;
	private String gender2;


	public Guide() {

	}

	public Guide(int guide_id, String kanjiName) {
		this.guide_id = guide_id;
		this.kanjiName = kanjiName;
	}

	public Guide(String kanjiName,String kanaName,String birthday,int gender) {
		this.kanjiName = kanjiName;
		this.kanaName = kanaName;
		this.birthday = birthday;
		this.gender = gender;
	}

	public Guide(int guide_id, String kanjiName,String kanaName,String birthday,int gender) {
		this.guide_id = guide_id;
		this.kanjiName = kanjiName;
		this.kanaName = kanaName;
		this.birthday = birthday;
		this.gender = gender;
	}

	public Guide(int guide_id, String kanjiName,String kanaName,String birthday,String gender2) {
		this.guide_id = guide_id;
		this.kanjiName = kanjiName;
		this.kanaName = kanaName;
		this.birthday = birthday;
		this.gender2 = gender2;
	}

	public Guide(int guide_id, String kanjiName,String kanaName,String birthday,int gender,String gender2) {
		this.guide_id = guide_id;
		this.kanjiName = kanjiName;
		this.kanaName = kanaName;
		this.birthday = birthday;
		this.gender = gender;
		this.gender2 = gender2;
	}

	public String getKanjiName() {
		return kanjiName;
	}
	public String getKanaName() {
		return kanaName;
	}
	public String getBirthday() {
		return birthday;
	}
	public int getGender() {
		return gender;
	}

	public int getGuide_id() {
		return guide_id;
	}

	public String getGender2() {
		return gender2;
	}

}
