package model;

public class Plan {

	private String planName;
	private String planContent;
	private int place;
	private int money;
	private int capacity;
	private int guide_id;
	// セレクトで取ってきた情報を入れるためにつっくた
	private int plan_id;
	private String plan_name;
	private String place_name;
	private String name_kanji;

	public Plan() {}

	public Plan(int plan_id) {
		this.plan_id = plan_id;
	}

	public Plan(String planName, String planContent, int place, int money ,int capacity, int guide_id, String name_kanji) {
		this.planName = planName;
		this.planContent = planContent;
		this.place = place;
		this.money = money;
		this.capacity = capacity;
		this.guide_id = guide_id;
		this.name_kanji = name_kanji;
	}

	public Plan(String planName, String planContent, int place, int money ,int capacity, int guide_id) {
		this.planName = planName;
		this.planContent = planContent;
		this.place = place;
		this.money = money;
		this.capacity = capacity;
		this.guide_id = guide_id;
	}

	public Plan(int plan_id, String plan_name, String place_name, String name_kanji) {
		this.plan_id = plan_id;
		this.plan_name = plan_name;
		this.place_name = place_name;
		this.name_kanji = name_kanji;
	}

	public Plan(int plan_id, String planName, String planContent,String place_name,int money ,int capacity,String name_kanji,int place,int guide_id) {
		this.plan_id = plan_id;
		this.planName = planName;
		this.planContent = planContent;
		this.place_name = place_name;
		this.money = money;
		this.capacity = capacity;
		this.name_kanji = name_kanji;
		this.place = place;
		this.guide_id = guide_id;
	}

	public Plan(int plan_id, String planName, String planContent,int place,int money ,int capacity,int guide_id) {
		this.plan_id = plan_id;
		this.planName = planName;
		this.planContent = planContent;
		this.place = place;
		this.money = money;
		this.capacity = capacity;
		this.guide_id = guide_id;
	}

	//プラン名が見えるほう
	public String getPlanName() {
		return planName;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public String getPlanContent() {
		return planContent;
	}

	public int getPlace() {
		return place;
	}

	public int getMoney() {
		return money;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getGuide() {
		return guide_id;
	}

	public int get_Id() {
		return plan_id;
	}

	public String getPlace_name() {
		return place_name;
	}

	public String getName_kanji() {
		return name_kanji;
	}

}
