package salud.isa.gsonMedDB;

import java.io.FileNotFoundException;
import java.io.IOException;
import clasesherederas.*;
public class GsonDatabaseClient {

	public static void main(String[] args) {
		try{
			
			MedPresentation med = new MedPresentation(null);
			Act_Ing ai = new Act_Ing(med);
			Physio pt = new Physio(ai);
			Inhalers ih = new Inhalers(pt);
			Posologies ps = new Posologies(ih);
			//MedicinePresentations mp = new MedicinePresentations(ps);
			RescueMedPres rmp = new RescueMedPres(ps);
			ManualPhysio umps = new ManualPhysio(rmp);
			ManualInhaler ums = new ManualInhaler(umps);
			DatabaseJSonReader dbjp = new DatabaseJSonReader(ums);
			
			try {
				System.out.println(dbjp.parse("C:/Users/Usuario/Desktop/Mis cosas/Universidad/Java workspace/Pr3/datos.json"));
			} finally {
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
