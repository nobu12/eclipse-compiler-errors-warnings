package unnecessarycode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
// 6-6. 未使用のインポート
// ファイル保存時に不要なインポートが自動削除される場合があるため、コメントアウトしている
// 警告確認時はコメントアウトを外す必要がある
// import java.util.regex.Matcher;

//6-12. 冗長なスーパー・インターフェース
public class UnNecessaryCode extends UnNecessaryCodeParent implements UnNecessaryCodeInterface {

	private void unusedLocal() {
		// 6-1. ローカル変数の値が未使用
		int a;
	}

	// 6-2. メソッド・パラメーターの値が未使用
	private void unusedParameter(int a) {
	}

	@Override
	// 6-2-1. オーバーライドしたメソッドの実装を無視 にチェックなし
	public void unusedParameterWhenOverridingConcrete(int a) {
	}

	// 6-3. 未使用の型パラメーター
	private <E> void unusedTypeParameter(List<?> list) {
	}

	/**
	 * 
	 * @param <E>
	 * @param list
	 */
	// 6-3. 未使用の型パラメーター
	// 6-4. '@param'タグで未使用の文書化されたパラメーターを無視 にチェックなし
	private <E> void unusedParameterIncludeDocCommentReference(List<?> list) {
	}

	private void unusedExceptionParameter() {
		try (BufferedReader twrReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));) {
			String line;
			while ((line = twrReader.readLine()) != null) {
				System.out.println(line);
			}
		// 6-5. 例外パラメーターの値が未使用
		} catch (IOException e) {
		}
	}
	
	// 6-7. 未使用のprivateメンバー
	private int a;

	private void unnecessaryElse() {
		if (true) {
			return;
		// 6-8. 不要な'else'ステートメント
		} else {
		}
	}

	private void unnecessaryTypeCheck() {
		// 6-9. 不要なキャストまたは'instansof'操作
		int a = (int) 1;
	}

	// 6-10. 不要な例外スロー宣言
	private void unusedDeclaredThrownException() throws IOException {
	}

	@Override
	// 6-10-1. オーバーライドしたメソッドの実装を無視 にチェックなし
	public void unusedDeclaredThrownExceptionWhenOverriding() throws IOException {
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	// 6-10-2. '@throws'または'@exception'で文書化された例外を無視 にチェックなし
	private void unusedDeclaredThrownExceptionIncludeDocCommentReference() throws IOException {
	}

	// 6-10-3. 'Exception'および'Throwable'を無視 にチェックなし
	private void unusedDeclaredThrownExceptionExemptExceptionAndThrowable() throws Exception {
	}

	// 6-11. 未使用の'break'または'continue'ラベル
	private void unusedLabel() {
		label: for (int i = 1; i < 10; i++) {
		}
	}
}
