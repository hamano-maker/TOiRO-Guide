package model;

import dao.PlanDAO;

public class PlanSignUpLogic {

	public boolean plan(Plan plan) {
		//最初は情報がないのでfalse
		boolean result = false;
		// DAOを呼び出す
		PlanDAO dao = new PlanDAO();
		//DAOに新規登録で入れた情報をDAOに渡して実行しうまくインサートできるとtrueが帰ってきてresultに入る
		result = dao.createPlan(plan);

		return result;

	}

}
