package cbir2073MV.repository.repoInterfaces;

import cbir2073MV.model.Carte;

import java.util.List;

public interface CartiRepoInterface {
	void adaugaCarte(Carte c);
	void modificaCarte(Carte nou, Carte vechi);
	List<Carte> cautaCarte(String ref);
	List<Carte> getCarti();
	List<Carte> getCartiOrdonateDinAnul(String an);
	void eliminaToateCartile();
}
