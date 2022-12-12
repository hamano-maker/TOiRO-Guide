package shared;

import java.text.DateFormat;

public class Check {

	// 入力された文字が全部カタカナかをチェックする
	public static boolean isFullKana(String str) {
		 if (str != null && str.length() > 0) {
			 return str.matches("^[\\u30A0-\\u30FF]+$");
		 } else {
			 return false;
		 }
	}

	// 入力された文字が1.2.3かをチェックする
	public static boolean isGenderNum(String str) {
		 if (str != null && str.length() > 0) {
			 return str.matches("[1-3]");
		 } else {
			 return false;
		 }
	}

	// 入力された文字が全部数字かをチェックする
	public static boolean isFullNum(String str) {
		 if (str != null && str.length() > 0) {
			 return str.matches("^[0-9]+$|-[0-9]+$");
		 } else {
			 return false;
		 }
	}

	// 存在する日付かどうかをチェックする
	public static boolean checkDate(String strDate) {
	    if (strDate == null || strDate.length() != 10) {
	        throw new IllegalArgumentException(
	                "引数の文字列["+ strDate +"]" +
	                "は不正です。");
	    }
	    strDate = strDate.replace('-', '/');
	    DateFormat format = DateFormat.getDateInstance();
	    // 日付/時刻解析を厳密に行うかどうかを設定する。
	    format.setLenient(false);
	    try {
	        format.parse(strDate);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}

}
