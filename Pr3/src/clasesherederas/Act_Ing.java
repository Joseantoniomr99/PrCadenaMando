package clasesherederas;

import java.io.IOException;
import com.google.gson.stream.JsonReader;

import salud.isa.gsonMedDB.CadenaMando;

public class Act_Ing extends CadenaMando{
	
	private static final String ACTINGREDIENTS_TAGNAME = "activeIngredients";
	private static final String NAME_FIELD_TAGNAME = "name";

	public Act_Ing(CadenaMando cadenamando) {
		super(cadenamando);
	}

	public String ReadElement(JsonReader reader) throws IOException {
		String ingName = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				ingName = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return ingName;
	}
	
	public StringBuffer RecorrerTipoLista(JsonReader reader, String titulo) throws IOException {
		StringBuffer resultado;
		if (titulo.equals(ACTINGREDIENTS_TAGNAME)) {
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
