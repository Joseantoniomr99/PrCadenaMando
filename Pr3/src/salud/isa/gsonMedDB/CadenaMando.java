package salud.isa.gsonMedDB;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class CadenaMando {

	protected CadenaMando sig;
	
	public CadenaMando(CadenaMando cadenamando) {
		sig=cadenamando;
	}
	
	public abstract String ReadElement(JsonReader r) throws IOException; 
	
	public StringBuffer RecorrerTipoLista(JsonReader reader,String titulo) throws IOException {
		return sig.RecorrerTipoLista(reader,titulo);
	}
	public StringBuffer RecorrerArray(JsonReader reader,String titulo) throws IOException {
		StringBuffer resultado = new StringBuffer();
		reader.beginArray();
		while(reader.hasNext()) {
			reader.beginObject();
			resultado.append(ReadElement(reader)).append("\n");
			reader.endObject();
		}
		resultado.append("\n");
		reader.endArray();
		
		return resultado;
	}
	
}
