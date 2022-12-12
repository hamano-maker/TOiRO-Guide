package model;

import java.io.Serializable;

public class GuideCompany implements Serializable {

  private int guide_company_id; // ガイド会社ID
  private String pass; // パスワード
  private String company_name; // ガイド会社名
  private String master_id; // マスターID

  public GuideCompany() {
  }

  public GuideCompany(String company_name) {
	  this.company_name = company_name;
  }

  public GuideCompany(String master_id, String pass) {
    this.master_id = master_id;
    this.pass = pass;
  }

  public GuideCompany(int guide_company_id, String pass, String company_name) {
	  this.guide_company_id = guide_company_id;
	  this.pass = pass;
	  this.company_name = company_name;
  }

  public String getMaster_id() {
    return master_id;
  }

  public String getPass() {
    return pass;
  }

  public String getCompany_name() {
    return company_name;
  }

  public int getGuide_company_id() {
	return guide_company_id;
}

}