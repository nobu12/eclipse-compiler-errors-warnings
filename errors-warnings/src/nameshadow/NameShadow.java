package nameshadow;

import nameshadow.override.NameShadowParent;

public class NameShadow extends NameShadowParent {
	// 3-1. フィールド宣言が他のフィールドまたは変数を隠蔽
	private int a;

	private void localVariableHiding() {
		// 3-2. ローカル変数宣言が他のフィールドまたは変数を隠蔽
		int a;
	}

	// 3-2-1. コンストラクターまたはsetterメソッド・パラメーターを含む にチェックあり
	private NameShadow(int a) {
	}

	// 3-3. 型パラメーターが別の型を隠蔽
	private class Outer<T> {
		class Inner<T> {
		}
	}

	// 3-4. メソッドがパッケージ可視メソッドを非オーバーライド
	void overridingPackageDefaultMethod() {
	}
}
