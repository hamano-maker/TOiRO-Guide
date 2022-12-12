package model;

import dao.guideDAO;

public class GuideUpdateLogic {

	// 空のインスタンス生成
	boolean guide = false;

	// データベースからとってきた情報をdbPassに入れてリターンし空で用意していたインスタンスを更新
	public boolean guideUp(Guide g) {

		guideDAO dao = new guideDAO();
		guide = dao.guideUpdate(g);

		return guide;
	}

}
