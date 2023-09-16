package com.example.demo.nullanalysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;

public class NullAnalysis {
	private void nullReference() {
		String a = null;
		// 9-1. nullポインター・アクセス
		a.length();
	}

	private void potentialNullReference(String a) {
		boolean isNull = a == null;
		if (isNull) {
			// 9-2. 潜在的なnullポインター・アクセス
			a.length();
		}
	}
	
	private void redundantNullCheck() {
		String a = "test";
		int b = a.length();
		// 9-3. 冗長なnull検査
	    if (a == null) {
	    }
	}
	
	private void includeNullInfoFromAsserts(String a) {
	    assert a != null;
	    // 9-3. 冗長なnull検査
	    // 9-4. null分析で'assert'を含める
	    if (a != null) {
	    }
	}
	
	private void nullSpecViolation(@org.eclipse.jdt.annotation.NonNull String a) {
    	// 9-5-1. null仕様違反
    	a = null;
    }

	private void nullAnnotationInferenceConflict(boolean can) {
		@org.eclipse.jdt.annotation.NonNull
		String a = "a";
		String b = "b";
		
		if (can) {
			b = null;
		}
		
		// 9-5-2. null注釈およびnullインスタンスへの競合
		a = b;
    }
    
	private void nullUncheckedConversion(boolean can) {
		@org.eclipse.jdt.annotation.NonNull
		String a;
		
		if (can) {
			// 9-5-3. 非注釈型から@NonNull型への未検査変換
			a = nullUncheckedConversionSub();
		}
    }
    
	private String nullUncheckedConversionSub() {
    	return null;
    }
    
	private void annotatedTypeArgumentToUnannotated() {
    	List<@org.eclipse.jdt.annotation.NonNull String> a = new ArrayList<>();
    	List<String> b = new ArrayList<>();
    	
    	// 9-5-4. 注釈付きのパラメーター化された型から注釈の少ないタイプへの安全でない変換
    	b = a;
    }
    
	private class PessimisticNullAnalysisForFreeTypeVariables<T extends Number> {
		int consume(T a) {
			// 9-5-5. 自由型変数のための悲観的な分析によって検出された問題
			return a.intValue();
		}

		T provide() {
			// 9-5-5. 自由型変数のための悲観的な分析によって検出された問題
			return null;
		}
	}
	
	// 9-5-6. ライブラリーからの自由型変数の安全でない'@Nonnull'の解釈 は実装方法不明
	
	@NonNullByDefault
	private class RedundantNullAnnotation {
		// 9-5-7. 冗長なnull注釈
		@org.eclipse.jdt.annotation.NonNull
		public String redundantNullAnnotation() {
			return "a";
		}
	}
	
	@NonNullByDefault
	private class NonnullParameterAnnotationDroppedParent {
		public void nonnullParameterAnnotationDropped(String a) {
		}
	}
	
	private class NonnullParameterAnnotationDropped extends NonnullParameterAnnotationDroppedParent {
		@Override
		// 9-5-8. オーバーライドするメソッドで注釈が付けられていない'@NonNull'パラメーター
		// 9-5-11. null注釈の継承 にチェックを付けるとエラーがなくなる
		public void nonnullParameterAnnotationDropped(String a) {
		}
	}
	
	@org.eclipse.jdt.annotation.Nullable
	private Object a;

	private void syntacticNullAnalysisForFields() {
		if (a != null)
			// 9-2. 潜在的なnullポインター・アクセス
			// 9-5-12. フィールドの構文null分析を使用可能にする にチェックを付けるとエラーがなくなる
			a.toString();
	}
	
	// 9-5-13. すべてのビルド・パス・ロケーションで外部注釈を検索する は実装方法不明
}
