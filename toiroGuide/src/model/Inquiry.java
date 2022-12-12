package model;

public class Inquiry {

	// 問い合わせID
	private int inquiry_id;
	// 問い合わせ内容
	private String inquiry_content;
	// 解決フラグ
	private int resolution;
	// ユーザーID
	private int user_id;
	// ガイド会社ID
	private int guide_company_id;
	// メモ
	private String memo;
	// 受付日時
	private String reception_date;
	// メールアドレス
	private String address;
	// 電話番号
	private String phone_number;
	// ユーザー名
	private String user_name;

	public Inquiry() {}

	public Inquiry(String memo,int resolution,int inquiry_id) {

		this.memo = memo;
		this.resolution = resolution;
		this.inquiry_id = inquiry_id;

	}

	public Inquiry(int inquiry_id, String inquiry_content, int resolution, int user_id, String user_name,
			int guide_company_id, String memo, String reception_date, String address, String phone_number) {

		this.inquiry_id = inquiry_id;
		this.inquiry_content = inquiry_content;
		this.resolution = resolution;
		this.user_id = user_id;
		this.user_name = user_name;
		this.reception_date = reception_date;
		this.guide_company_id = guide_company_id;
		this.memo = memo;
		this.address = address;
		this.phone_number = phone_number;

	}

	public int getInquiry_id() {
		return inquiry_id;
	}

	public String getInquiry_content() {
		return inquiry_content;
	}

	public int getResolution() {
		return resolution;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getReception_date() {
		return reception_date;
	}

	public int getGuide_company_id() {
		return guide_company_id;
	}

	public String getMemo() {
		return memo;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getUser_name() {
		return user_name;
	}

}
