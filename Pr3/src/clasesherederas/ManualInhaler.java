package clasesherederas;

import java.io.IOException;
import salud.isa.gsonMedDB.CadenaMando;
import com.google.gson.stream.JsonReader;

public class ManualInhaler extends CadenaMando{

	private static final String USERMANUALINHL_TAGNAME = "userManualSteps";
	private static final String STITLE_FIELD_TAGNAME = "stepTitle";
	private static final String SIMAGE_FIELD_TAGNAME = "stepImage";
	private static final String STEXT_FIELD_TAGNAME = "stepText";
	private static final String INHREF_FIELD_TAGNAME = "inhalerRef";
	private static final String FIELD_SEPARATOR = ";";
	
	public ManualInhaler(CadenaMando cadenamando) {
		super(cadenamando);
	}
	
	
	
	public String ReadElement(JsonReader reader) throws IOException {
		String Title = null;
		String Image = null;
		String Text = null;
		String inhRef = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(STITLE_FIELD_TAGNAME)) {
				Title = reader.nextString();
			} else if (name.equals(SIMAGE_FIELD_TAGNAME)) {
				Image = reader.nextString();
			} else if (name.equals(STEXT_FIELD_TAGNAME)) {
				Text = reader.nextString();
			} else if (name.equals(INHREF_FIELD_TAGNAME)) {
				inhRef = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return Title + FIELD_SEPARATOR + Image + FIELD_SEPARATOR + Text + FIELD_SEPARATOR + inhRef;
	}
	
	public StringBuffer RecorrerTipoLista(JsonReader reader, String tipo) throws IOException {
		StringBuffer resultado;
		if(tipo.equals(USERMANUALINHL_TAGNAME)) {
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
