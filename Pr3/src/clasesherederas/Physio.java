package clasesherederas;

import java.io.IOException;
import com.google.gson.stream.JsonReader;
import salud.isa.gsonMedDB.CadenaMando;

public class Physio extends CadenaMando{
	
	private static final String PHYSIOTHERAPIES_TAGNAME = "physiotherapies";
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEPARATOR = ";";
	
	public Physio(CadenaMando cadenamando) {
		super(cadenamando);
	}
	
	public String ReadElement(JsonReader reader) throws IOException {
		String physiotherapy_Name = null;
		String physiotherapy_Image = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				physiotherapy_Name = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				physiotherapy_Image = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return physiotherapy_Name + FIELD_SEPARATOR + physiotherapy_Image;
	}

	public StringBuffer RecorrerTipoLista(JsonReader reader, String titulo) throws IOException {
		StringBuffer resultado;
		if (titulo.equals(PHYSIOTHERAPIES_TAGNAME)) {
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
