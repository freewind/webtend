package webtend;

public class Helper {

	public static void notNull(Object obj, String fieldName) {
		if (obj == null) {
			throw new IllegalArgumentException(fieldName + " should not be null");
		}
	}

	public static RuntimeException logWrap(Throwable e) {
		return logWrap(e.toString(), e);
	}

	public static RuntimeException logWrap(String message, Throwable e) {
		Webtend.logger.error(message, e);
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	public static RuntimeException logWrap(String message) {
		Webtend.logger.error(message);
		return new RuntimeException(message);
	}

}
