package tipos;


public enum Tipo {

	ACCION, BANQUETES, LOCURA, TERROR;


	public static boolean isValidEnum(final Class<Tipo> enumClass, final String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(enumClass, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}
	}