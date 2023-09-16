package deprecatedapi;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DeprecatedApi extends DeprecatedApiParent {
	private void deprecation() {
		// 4-1. 使用すべきではないAPI
		Character.isJavaLetter('a');
	}
	
	
	@Deprecated
	public void deprecationInDeprecatedCode() {
		// 4-1-1. 使用すべきではないコード内での使用すべきではないAPIの使用を知らせる にチェックあり
		super.deprecationWhenOverridingDeprecatedMethod();
	}
	
	@Override
	// 4-1-2. 使用すべきではないメソッドのオーバーライドまたは実装を知らせる にチェックあり
	public void deprecationWhenOverridingDeprecatedMethod() {
	}
	
	// 4-2. 除去とマークされた廃止予定のAPI は実装方法不明
	
	private void forbiddenReference() throws URISyntaxException {
		// 4-3. 禁止された参照(アクセス・ルール)
		// ビルドパスのアクセスルールに追加が必要
		URI uri = new URI("https://qiita.com");
	}
	
	private void discouragedReference() throws MalformedURLException  {
		// 4-4. 阻止された参照(アクセス・ルール)
		// ビルドパスのアクセスルールに追加が必要
		URL url = new URL("https://qiita.com");
	}
}
