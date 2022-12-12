package model;

public class Place {
	private int place_id;
	private String place;

	public Place() {}

	public Place(int place_id, String place) {
		this.place_id = place_id;
		this.place = place;
	}

	public String getPlace() {
		return place;
	}

	public int getPlace_id() {
		return place_id;
	}

}
