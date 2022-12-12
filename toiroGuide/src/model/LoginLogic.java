package model;

import dao.LoginDAO;

public class LoginLogic {

	// 空のインスタンス生成
	GuideCompany loginUser = new GuideCompany();

	// データベースからとってきた情報をdbPassに入れてリターンし空で用意していたインスタンスを更新
	public GuideCompany guideDb(GuideCompany user) {

		LoginDAO dao = new LoginDAO();
		GuideCompany loginUser = new GuideCompany();
		loginUser = dao.findAll(user);

		return loginUser;
	}

	public boolean execute(GuideCompany gdb, GuideCompany user) {

		if (gdb.getPass().equals(user.getPass())) {
			return true;
	    }
			return false;
	}
}