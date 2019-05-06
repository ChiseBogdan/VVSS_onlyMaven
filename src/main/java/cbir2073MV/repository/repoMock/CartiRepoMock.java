package cbir2073MV.repository.repoMock;


import cbir2073MV.model.Carte;
import cbir2073MV.repository.repoInterfaces.CartiRepoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepoMock implements CartiRepoInterface {

	private List<Carte> carti;
	
	public CartiRepoMock(){
		carti = new ArrayList<Carte>();

		carti.add(Carte.getCarteFromString("Povesti;Mihai Eminescu,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
		carti.add(Carte.getCarteFromString("Poezii;Sadoveanu;1973;Corint;poezii"));
		carti.add(Carte.getCarteFromString("Enigma Otiliei;George Calinescu;1948;Litera;enigma,otilia"));
		carti.add(Carte.getCarteFromString("Dale carnavalului;Caragiale Ion;1948;Litera;caragiale,carnaval"));
		carti.add(Carte.getCarteFromString("Intampinarea crailor;Mateiu Caragiale;1948;Litera;mateiu,crailor"));
		carti.add(Carte.getCarteFromString("Test;Calinescu,Tetica;1992;Pipa;am,casa"));

	}

	public void eliminaToateCartile(){
		carti.removeAll(carti);
	}
	
	@Override
	public void adaugaCarte(Carte c) {
		carti.add(c);
	}

	private boolean cautaCarteDupaAutori(List<String> lref, String ref){

		boolean flag = false;

		int j = 0;
		while(j<lref.size()){
			if(lref.get(j).toLowerCase().contains(ref.toLowerCase())){
				flag = true;
				break;
			}
			j++;
		}

		return flag;

	}
	
	@Override
	public List<Carte> cautaCarte(String ref) {

		List<Carte> cartiGasite = new ArrayList<Carte>();
		List<Carte> carti = getCarti();

		int i=0;

		if(carti.size() == 0){
			return cartiGasite;
		}

		if(ref.equals("")){
			return cartiGasite;
		}

		while (i<carti.size()){

			List<String> lref = carti.get(i).getReferenti();

			boolean flag = cautaCarteDupaAutori(lref, ref);

			if(flag == true){
				cartiGasite.add(carti.get(i));
			}
			i++;
		}
		return cartiGasite;
	}

	@Override
	public List<Carte> getCarti() {
		return carti;
	}

	@Override
	public void modificaCarte(Carte nou, Carte vechi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carte> getCartiOrdonateDinAnul(String an) {
		List<Carte> toateCartile = getCarti();
		List<Carte> cartiOrdonareDinAnulResult = new ArrayList<Carte>();
		for(Carte c:toateCartile){
			if(c.getAnAparitie().equals(an) == true){
				cartiOrdonareDinAnulResult.add(c);
			}
		}
		
		Collections.sort(cartiOrdonareDinAnulResult,new Comparator<Carte>(){

			@Override
			public int compare(Carte a, Carte b) {
				if(a.getTitlu().compareTo(b.getTitlu())==0){
					return a.getReferenti().get(0).compareTo(b.getReferenti().get(0));
				}
				
				return a.getTitlu().compareTo(b.getTitlu());
			}
		
		});
		
		return cartiOrdonareDinAnulResult;
	}

}
