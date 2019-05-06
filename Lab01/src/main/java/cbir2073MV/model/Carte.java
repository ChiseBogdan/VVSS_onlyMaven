package cbir2073MV.model;


import java.util.ArrayList;
import java.util.List;

public class Carte {
	
	private String titlu;
	private List<String> referenti;
	private String anAparitie;
	private List<String> cuvinteCheie;
	private String editura;
	
	public Carte(){
		titlu = "";
		referenti = new ArrayList<String>();
		anAparitie = "";
		cuvinteCheie = new ArrayList<String>();
		editura = "";
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public List<String> getReferenti() {
		return referenti;
	}

	public void setReferenti(List<String> ref) {
		this.referenti = ref;
	}

	public String getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(String anAparitie) {
		this.anAparitie = anAparitie;
	}

	public List<String> getCuvinteCheie() {
		return cuvinteCheie;
	}

	public void setCuvinteCheie(List<String> cuvinteCheie) {
		this.cuvinteCheie = cuvinteCheie;
	}
	

	public void deleteCuvantCheie(String cuvant){
			for(int i=0;i<cuvinteCheie.size();i++){
				if(cuvinteCheie.get(i).equals(cuvant)){
					cuvinteCheie.remove(i);
					return;
				}
			}
	}
	
	public void deleteReferent(String ref){
			for(int i=0;i<referenti.size();i++){
				if(referenti.get(i).equals(ref)){
					referenti.remove(i);
					return;
				}
			}
	}
	
	public void deleteTotiReferentii(){
		referenti.clear();
	}
	
	public void adaugaCuvantCheie(String cuvant){
		cuvinteCheie.add(cuvant);
	}
	
	public void adaugaReferent(String ref){
		referenti.add(ref);
	}
	
	public boolean cautaDupaCuvinteCheie(List<String> cuvinte){
		for(String c:cuvinteCheie){
			for(String cuv:cuvinte){
				if(c.equals(cuv))
					return true;
			}
		}
		return false;
	}
	 
	public boolean cautaDupaAutor(String autor){
		for(String a:referenti){
			if(a.contains(autor))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String ref = "";
		String cuvCheie = "";
		
		for(int i=0;i<referenti.size();i++){
			if(i==referenti.size()-1)
				ref+=referenti.get(i);
			else
				ref+=referenti.get(i)+",";
		}
		
		for(int i=0;i<cuvinteCheie.size();i++){
			if(i==cuvinteCheie.size()-1)
				cuvCheie+=cuvinteCheie.get(i);
			else
				cuvCheie+=cuvinteCheie.get(i)+",";
		}
		
		return titlu+";"+ref+";"+anAparitie+";"+cuvCheie;
	}
	
	public static Carte getCarteFromString(String carte){
		Carte c = new Carte();
		String []atr = carte.split(";");
		String []referenti = atr[1].split(",");
		String []cuvCheie = atr[4].split(",");
		
		c.titlu=atr[0];
		for(String s:referenti){
			c.adaugaReferent(s);
		}
		c.anAparitie = atr[2];
		for(String s:cuvCheie){
			c.adaugaCuvantCheie(s);
		}
		
		return c;
	}
	
}
