package salud.isa.gsonMedDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import salud.isa.gsonMedDB.CadenaMando;
import com.google.gson.stream.JsonReader;

/**
 * Created by jmalvarez on 11/5/16.
 * http://developer.android.com/intl/es/training/basics/network-ops/xml.html
 */
public class DatabaseJSonReader {


	CadenaMando cm;
	
	public DatabaseJSonReader(CadenaMando cadenamando) {
		cm = cadenamando;
	}
	
	public void setCadenaMando(CadenaMando cadenamando) {
		cm = cadenamando;
	}

	public String parse(String jsonFileName) throws IOException {

		InputStream usersIS = new FileInputStream(new File(jsonFileName));
		JsonReader reader = new JsonReader(new InputStreamReader(usersIS, "UTF-8"));

		reader.beginObject();
		StringBuffer readData = new StringBuffer();
		
		while (reader.hasNext()) {
			String titulo = reader.nextName();
			readData.append(titulo.toUpperCase()).append("\n").append(RecorrerTipoLista(reader, titulo)).append("\n");
			
		}

		reader.endObject();
		reader.close();
		usersIS.close();

		return new String(readData);
	}

	private Object RecorrerTipoLista(JsonReader reader, String titulo) throws IOException {
		return cm.RecorrerTipoLista(reader, titulo);
	}

	

	

}