package net.hycrafthd.validation;

public final class Validate {
	
	public static final boolean isNull(Object object) {
		return object == null;
	}
	
	public static final boolean notNull(Object object) {
		return !isNull(object);
	}
	
	public static final <T> T notNullEx(T object) {
		return notNullEx(object, "The validated object is null");
	}
	
	public static final <T> T notNullEx(T object, String message) {
		return notNullEx(object, message, new Object[0]);
	}
	
	public static final <T> T notNullEx(T object, String message, Object... format) {
		if (isNull(object)) {
			throw new NullPointerException(String.format(message, format));
		}
		return object;
	}
	
	public static final boolean isEmpty(String string) {
		return string.isEmpty();
	}
	
	public static final boolean notEmpty(String string) {
		return !isEmpty(string);
	}
	
	public static final <T> boolean isEmpty(T[] array) {
		return array.length == 0;
	}
	
	public static final <T> boolean notEmpty(T[] array) {
		return !isEmpty(array);
	}
	
	public static final boolean isNullOrEmpty(String string) {
		return isNull(string) || string.isEmpty();
	}
	
	public static final boolean notNullOrEmpty(String string) {
		return !notNullOrEmpty(string);
	}
	
	public static final String notNullOrEmptyEx(String string) {
		return notNullOrEmptyEx(string, "The validated object is null!", new Object[0]);
	}
	
	public static final String notNullOrEmptyEx(String string, String message, Object... format) {
		if (isNull(string)) {
			throw new NullPointerException(String.format(message, format));
		}
		if (isEmpty(string)) {
			throw new IllegalArgumentException(String.format(message, format));
		}
		return string;
	}
	
}
