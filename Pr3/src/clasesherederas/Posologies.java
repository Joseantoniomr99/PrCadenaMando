package clasesherederas;

import java.io.IOException;
import salud.isa.gsonMedDB.CadenaMando;
import com.google.gson.stream.JsonReader;

public class Posologies extends CadenaMando {

	private static final String POSOLOGIES_TAGNAME = "posologies";
	private static final String DESCRIPTION_FIELD_TAGNAME = "description";
	
	public Posologies(CadenaMando cadenamando) {
		super(cadenamando);
	}
	
	public String ReadElement(JsonReader reader) throws IOException {
		String posologie_Name = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(DESCRIPTION_FIELD_TAGNAME)) {
				posologie_Name = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return posologie_Name;
	}
	
	public StringBuffer RecorrerTipoLista(JsonReader reader, String titulo) throws IOException {
		StringBuffer resultado;
		if (titulo.equals(POSOLOGIES_TAGNAME)) {
			resultado = super.RecorrerArray(reader, titulo);
		}

		else {
			if (sig != null) {
				resultado = super.RecorrerTipoLista(reader, titulo);
			} else {
				reader.skipValue();
				resultado = new StringBuffer("");
			}
		}
		return resultado;
	}
	
}
