package programmingproblem;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 2-21. 'equals()'をオーバーライドしているが'hashCode()'がオーバーライドされていないクラス
public class ProgrammingProblem extends ProgrammingProblemParent {
	private void comparingIdentical(int a) {
		// 2-1. 同じ値の比較('x == x')
		if (a == a) {
		}
	}

	private void noEffectAssignment(int a) {
		// 2-2. 効果のない代入(例:「x = x」)
		a = a;
	}

	private void possibleAccidentalBooleanAssignment(boolean a, boolean b) {
		// 2-3. 予期しない論理代入の可能性(たとえば、'if(a = b)')
		if (a = b) {
		}
	}

	private void autoboxing(int a, Integer b) {
		// 2-4. ボクシングおよびアンボクシング変換
		// ボクシング変換
		Integer c = a;
		// アンボクシング変換
		int d = b;
	}

	private void noImplicitStringConversion() {
		// 2-5. ストリング連結での文字列配列の使用
		String a = "hello" + new char[] { 'w', 'o', 'r', 'l', 'd' };
	}

	private void varargsArgumentNeedCast() {
		// 2-6. 可変長引数の型の一致が不正確
		Arrays.asList(null);
	}

	private void unlikelyCollectionMethodArgumentType() {
		Map<String, String> a = new HashMap<>();
		// 2-7. ありそうもない'Object'を使用するコレクション・メソッドの引数型
		a.get(1);
	}
	
	private void unlikelyCollectionMethodArgumentTypeStrict(Object o) {
		Map<?, ?> a = new HashMap<>();
		// 2-7-1. 予想される型に対して厳密な分析を実行する にチェックあり
		a.get(o);
	}

	private void unlikelyEqualsArgumentType(Collection<Path> aaa) {
		// 2-8. ありそうもないequals()メソッドの引数型
		"abc".equals(1);
	}

	private void emptyStatement() {
		// 2-9. 空のステートメント
		;
	}

	private void unusedObjectAllocation() {
		// 2-10. 未使用のオブジェクト割り振り
		new ArrayList<>();
	}

	private enum Color {
		RED, GREEN, BLUE
	}

	private void incompleteEnumSwitch(Color color) {
		// 2-11. enumの不完全な'switch'ケース
		switch (color) {
		case RED:
			System.out.println("赤");
			break;
		case GREEN:
			System.out.println("緑");
			break;
		}

		// 2-11-1. 'default'ケースが存在する場合も知らせる にチェックあり
		switch (color) {
		case RED:
			System.out.println("赤");
			break;
		case GREEN:
			System.out.println("緑");
			break;
		default:
			System.out.println("その他");
		}
	}

	private void missingDefaultCase(Color color) {
		// 2-12. 'default'ケースが欠落した'switch'
		switch (color) {
		case RED:
			System.out.println("赤");
			break;
		case GREEN:
			System.out.println("緑");
			break;
		}
	}

	private void fallthroughCase(Color color) {
		switch (color) {
		case RED:
			System.out.println("赤");
		// 2-13. 'switch'文のcaseのフォールスルー
		case GREEN:
			System.out.println("緑");
			break;
		}
	}

	private void hiddenCatchBlock() {
		try {
			throw new CharConversionException();
		} catch (CharConversionException e) {
		// 2-14. 隠れたcatchブロック
		} catch (IOException e) {
		}
	}

	private void finallyBlockNotCompletingNormally() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			throw e;
		// 2-15. 'finally'が正常に完了しない
		} finally {
			try {
				reader.close();
				return;
			} catch (IOException e) {
				throw e;
			}
		}
	}

	private void deadCode() {
		if (true) {
		// 2-16. デッド・コード(例:'if (false)')
		} else {
		}
	}

	private void unclosedCloseable() throws IOException {
		// 2-17. リソース・リーク
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			throw e;
		}
	}
	
	// 2-18. 潜在的なリソース・リーク は実装方法不明

	// 2-19. serialVersionUIDなしのシリアライズ可能クラス
	private class MissingSerialVersion implements Serializable {
	}

	@Override
	// 2-20. 継承されたメソッドのsynchronized修飾子の欠落
	protected void synchronizedMethod() {
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
