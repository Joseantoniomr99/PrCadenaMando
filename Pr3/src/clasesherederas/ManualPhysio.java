package clasesherederas;

import java.io.IOException;
import com.google.gson.stream.JsonReader;
import salud.isa.gsonMedDB.CadenaMando;

public class ManualPhysio extends CadenaMando {
	
	private static final String USERMANUALPHYSIO_TAGNAME = "userManualPhysioSteps";
	private static final String STITLE_FIELD_TAGNAME = "stepTitle";
	private static final String SIMAGE_FIELD_TAGNAME = "stepImage";
	private static final String STEXT_FIELD_TAGNAME = "stepText";
	private static final String PHYREF_FIELD_TAGNAME = "physioRef";
	private static final String FIELD_SEPARATOR = ";";
	
	public ManualPhysio(CadenaMando cadenamando) {
		super(cadenamando);
	}
	
	public String ReadElement(JsonReader reader) throws IOException {
		String Title = null;
		String Image = null;
		String Text = null;
		String physioRef = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(STITLE_FIELD_TAGNAME)) {
				Title = reader.nextString();
			} else if (name.equals(SIMAGE_FIELD_TAGNAME)) {
				Image = reader.nextString();
			} else if (name.equals(STEXT_FIELD_TAGNAME)) {
				Text = reader.nextString();
			} else if (name.equals(PHYREF_FIELD_TAGNAME)) {
				physioRef = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return Title + FIELD_SEPARATOR + Image + FIELD_SEPARATOR + Text + FIELD_SEPARATOR + physioRef;
	}
	
	public StringBuffer RecorrerTipoLista(JsonReader reader, String tipo) throws IOException {
		StringBuffer resultado;
		if(tipo.equals(USERMANUALPHYSIO_TAGNAME)) {
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
