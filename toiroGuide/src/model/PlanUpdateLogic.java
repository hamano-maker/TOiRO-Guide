package model;

import dao.PlanDAO;

public class PlanUpdateLogic {

	// 空のインスタンス生成
	boolean plan = false;

	// データベースからとってきた情報をdbPassに入れてリターンし空で用意していたインスタンスを更新
	public boolean planUp(Plan p) {

		PlanDAO dao = new PlanDAO();
		plan = dao.planUpdate(p);

		return plan;
	}

}
