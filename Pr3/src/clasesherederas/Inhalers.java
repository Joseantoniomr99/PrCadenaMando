package clasesherederas;

import java.io.IOException;
import com.google.gson.stream.JsonReader;

import salud.isa.gsonMedDB.CadenaMando;

public class Inhalers extends CadenaMando{
	private static final String INHALERS_TAGNAME = "inhalers";
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEPARATOR = ";";
	
	
	public Inhalers(CadenaMando cadenamando) {
		super(cadenamando);
	}

	public String ReadElement(JsonReader reader) throws IOException {
		String inhaler_Name = null;
		String inhaler_Image = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				inhaler_Name = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				inhaler_Image = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return inhaler_Name + FIELD_SEPARATOR + inhaler_Image;
	}
	
	public StringBuffer RecorrerTipoLista(JsonReader reader, String titulo) throws IOException {
		StringBuffer resultado;
		if (titulo.equals(INHALERS_TAGNAME)) {
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
