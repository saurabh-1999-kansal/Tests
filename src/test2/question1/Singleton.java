package test2.question1;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
// volatile keyword guarantee visibility of changes to variable across threads
	private static volatile Singleton singleton = null;

	private Singleton() {

		if (singleton != null) {

			throw new IllegalStateException();// so that our code does not break by reflection

		}

	}

	public static Singleton getSingleton() {
//we try to go for lazy implementation instead of eager implementation
		if (singleton == null) {
//we try to go for synchronized block instead of synchronized method(because there can be lot of code which not bee synchronized)
			synchronized (Singleton.class) {
//here we are doing double lock checking 
				if (singleton == null) {

					singleton = new Singleton();

				}

			}

		}

		return singleton;

	}

//jvm will not go for deserialization if we have this readResolve method

	private Object readResolve() {

		return singleton;

	}

	@Override

	protected Object clone() throws CloneNotSupportedException {
//in cloning also we are returning the same singleton so that someone could not break our code by cloning
		return singleton;

		// throw new CloneNotSupportedException();

	}

}
