package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics extends GenericsParent {
	private void uncheckedTypeOperation() {
		// 7-1. 未検査の総称型操作
		List<Integer> a = new ArrayList(Arrays.asList(1));
	}

	private void rawTypeReference() {
		// 7-2. raw型の使用
		List a;
	}

	// 7-3. finalな型で制約された総称型パラメーター
	private <T extends String> T finalParameterBound() {
		return null;
	}

	private void redundantSpecificationOfTypeArguments() {
		// 7-4. 冗長な型引数(1.7以上)
		List<Integer> a = new ArrayList<Integer>();
	}

	@Override
	// 7-2. raw型の使用
	// 7-5. raw APIが原因で避けられない総称型問題を無視 にチェックなし
	public void unavoidableGenericTypeProblems(ArrayList list) {
	}
}
