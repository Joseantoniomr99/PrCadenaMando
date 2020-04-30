package clasesherederas;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

import salud.isa.gsonMedDB.CadenaMando;

public class MedPresentation extends CadenaMando{
	
	private static final String MEDICINES_TAGNAME = "medicines";
	private static final String NAME_FIELD_TAGNAME = "name";
	
	public MedPresentation(CadenaMando cadenamando) {
		super(cadenamando);
	}
	
	public String ReadElement(JsonReader reader) throws IOException {
		// reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
				String medName = null;
				while (reader.hasNext()) {
					String name = reader.nextName();
					if (name.equals(NAME_FIELD_TAGNAME)) {
						medName = reader.nextString();
					} else {
						reader.skipValue();
					}
				}

				return medName;
	}
	
	public StringBuffer RecorrerTipoLista(JsonReader reader, String tipo) throws IOException {
		StringBuffer resultado;
		if(tipo.equals(MEDICINES_TAGNAME)) {
			resultado = super.RecorrerArray(reader, tipo);
		}
		else if(sig!=null) {
			resultado = super.RecorrerTipoLista(reader,tipo);
		}
		else {
			reader.skipValue();
			resultado = new StringBuffer("");
		}
		return resultado;
	}

}
