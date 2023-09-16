package modules;

public class Module {
	
	// 5-1. APIリーク
	public ApiLeak apiLeak() {
		return new ApiLeak();
	}
	
	private class ApiLeak {
	}
}
