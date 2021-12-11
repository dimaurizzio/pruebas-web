package usuario;


import tipos.Tipo;

public class NullUser extends Usuario {

	public static Usuario build() {
		return new NullUser();
	}
	
	public NullUser() {
		super("", 0, Tipo.ACCION, 0.0, 0, "", false, false);
	}
	
	public boolean isNull() {
		return true;
	}
	
}
