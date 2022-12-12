package model;

import dao.guideDAO;

public class GuideSignUpLogic {

	public boolean guide(Guide Guide) {
		//最初は情報がないのでfalse
		boolean result = false;
		// DAOを呼び出す
		guideDAO dao = new guideDAO();
		//DAOに新規登録で入れた情報をDAOに渡して実行しうまくインサートできるとtrueが帰ってきてresultに入る
		result = dao.createGuide(Guide);

		return result;

	}

}
