package clasesherederas;

import java.io.IOException;
import com.google.gson.stream.JsonReader;


import salud.isa.gsonMedDB.CadenaMando;

public class RescueMedPres extends CadenaMando {
	
	private static final String MEDPRESENTATION_TAGNAME = "medicinePresentations";
	private static final String MEDREF_FIELD_TAGNAME = "medicineRef";
	private static final String ACTINGREF_FIELD_TAGNAME = "activeIngRef";
	private static final String INHREF_FIELD_TAGNAME = "inhalerRef";
	private static final String DOSE_FIELD_TAGNAME = "dose";

	private static final String FIELD_SEPARATOR = ";";

	public RescueMedPres(CadenaMando cadenamando) {
		super(cadenamando);
	}

	public String ReadElement(JsonReader reader) throws IOException {
		String medRef = null;
		String aiRef = null;
		String inhRef = null;
		String dose = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(MEDREF_FIELD_TAGNAME)) {
				medRef = reader.nextString();
			} else if (name.equals(ACTINGREF_FIELD_TAGNAME)) {
				aiRef = reader.nextString();
			} else if (name.equals(INHREF_FIELD_TAGNAME)) {
				StringBuffer res = new StringBuffer();
				reader.beginArray();
				while (reader.hasNext()) {
					res.append(reader.nextString()).append(",");
				}
				reader.endArray();
				res.deleteCharAt(res.length() - 1);
				inhRef = new String(res);
			} else if (name.equals(DOSE_FIELD_TAGNAME)) {
				StringBuffer res = new StringBuffer();
				reader.beginArray();
				while (reader.hasNext()) {
					res.append(reader.nextString()).append(",");
				}
				reader.endArray();
				res.deleteCharAt(res.length() - 1);
				dose = new String(res);
			} else {
				reader.skipValue();
			}

		}
		return medRef + FIELD_SEPARATOR + aiRef + FIELD_SEPARATOR + inhRef + FIELD_SEPARATOR + dose;
	}
	
	public StringBuffer RecorrerTipoLista(JsonReader reader, String titulo) throws IOException {
		StringBuffer resultado;
		if (titulo.equals(MEDPRESENTATION_TAGNAME)) {
			resultado = super.RecorrerArray(reader, titulo);
		}
		else if (sig!=null) {
				resultado = super.RecorrerTipoLista(reader, titulo);
			} else {
				reader.skipValue();
				resultado = new StringBuffer("");
			}
		return resultado;
		
	}

	

}
