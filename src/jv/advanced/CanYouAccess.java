package jv.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.Permission;

public class CanYouAccess {
	public static void main(String[] args) throws Exception {
		Do_Not_Terminate.forbidExit();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;

			// My code
			o = new CanYouAccess.Inner().new Private();
			Method meth = o.getClass().getDeclaredMethod("powerof2", Integer.TYPE);
			meth.setAccessible(true);
			String result = (String) meth.invoke(o, num);
			System.out.println(num + " is " + result);
			// end of my code

			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		}

		catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}

	static class Inner {
		@SuppressWarnings("unused")
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}
}

class Do_Not_Terminate {
	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}
