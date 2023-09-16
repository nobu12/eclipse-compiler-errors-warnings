package codestyle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeStyle extends CodeStyleParent {

	private static final int CODE_STYLE = 0;

	private void indirectStaticAccess() {
		CodeStyle codeStyle = new CodeStyle();
		// 1-1. staticメンバーへの非staticアクセス
		int a = codeStyle.CODE_STYLE;
	}

	private void staticAccessReceiver() {
		// 1-2. staticメンバーへの間接アクセス
		int a = CodeStyle.CODE;
	}

	private int codeStyle;

	private void unqualifiedFieldAccess() {
		// 1-3. インスタンス・フィールドへの限定されていないアクセス
		int a = codeStyle;
	}

	private void syntheticAccessEmulation() {
		EnclosingClass ec = new EnclosingClass();
		// 1-4. エンクロージング型のアクセス不可メンバーへのアクセス
		// おそらくJava8以前のバージョンにしないとエラー/警告が起きない
		// 少なくともJava8のバージョンではエラー/警告が起きることを確認済み
		int a = ec.a;
	}

	class EnclosingClass {
		private int a;
		int b;
	}

	private void parameterAssignment(int a) {
		// 1-5. パラメータ代入
		a = 1;
	}

	private void nonExternalizedStringLiteral() {
		// 1-6. 外部化されていないString(欠落している/未使用の$NON-NLS$タグ)
		String a = "a";
		int b = 1; //$NON-NLS-1$
	}

	private void undocumentedEmptyBlock(boolean can) {
		// 1-7. 何も記述のない空のブロック
		if (true) {
		}
	}

	private void explicitlyClosedAutoCloseable() throws IOException {
		// 1-8. try-with-resourceで管理されていないリソース(1.7以上)
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw e;
			}
		}
	}

	// 1-9. コンストラクター名を持つメソッド
	private void CodeStyle() {
	}

	// 1-10. staticにできるメソッド
	private void reportMethodCanBeStatic() {
		int a = 1;
	}

	// 1-11. 潜在的にstaticにできるメソッド
	public void reportMethodCanBePotentiallyStatic() {
		int a = CodeStyle.CODE;
	}
}
