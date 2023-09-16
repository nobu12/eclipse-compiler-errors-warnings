package unnecessarycode;

import java.io.IOException;

public class UnNecessaryCodeParent implements UnNecessaryCodeInterface {
	public void unusedParameterWhenOverridingConcrete(int a) {
	}
	
	public void unusedDeclaredThrownExceptionWhenOverriding() throws IOException {
	}

	@Override
	public void redundantSuperinterface() {
	}
}
