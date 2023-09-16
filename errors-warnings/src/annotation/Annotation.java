package annotation;

public class Annotation extends AnnotationParent implements AnnotationInterface {

	// 8-1. '@Override'注釈の欠落
	public void missingOverrideAnnotation() {
	}
	
	// 8-1-1. インターフェース・メソッドの実装を含める(1.6以上) にチェックあり
	public void missingOverrideAnnotationForInterfaceMethodImplementation() {
	}

	/**
	 * @deprecated
	 */
	// 8-2. '@Deprecated'注釈の欠落
	private void missingDeprecatedAnnotation() {
	}

	// 8-4. '@SuppressWarnings'で処理されないトークン
	@SuppressWarnings(value = { "test" })
	private void unhandledWarningToken() {
	}

	// 8-5. '@SuppressWarnings'注釈の使用可能化
	@SuppressWarnings("deprecation")
	private void suppressWarnings() {
		Character.isJavaLetter('a');
	}

	// 8-5. '@SuppressWarnings'注釈の使用可能化 にチェックあり
	// 8-5-1. 未使用の'@SuppressWarnings'トークン
	@SuppressWarnings("deprecation")
	private void unusedWarningToken() {
	}

	// 6-7. 未使用のprivateメンバー を"無視"に設定
	// 8-5. '@SuppressWarnings'注釈の使用可能化 にチェックあり
	// 8-5-2. 関連するオプションが'無視'に設定され、完全には認識されない'未使用'ステータス
	@SuppressWarnings("unused")
	private void suppressWarningsNotFullyAnalysed() {
	}

	@SuppressWarnings("all")
	private void suppressOptionalErrors(int a) {
		// 2-1. 同じ値の比較('x == x')
		// 8-5. '@SuppressWarnings'注釈の使用可能化 にチェックあり
		// 8-5-3. '@SuppressWarnings'でオプション・エラーを抑制 にチェックなし
		if (a == a) {
		}
	}
	
	@Override
	public Class<? extends java.lang.annotation.Annotation> annotationType() {
		return null;
	}
}
