package cbir2073MV.control;

import cbir2073MV.model.Carte;
import cbir2073MV.repository.repoInterfaces.CartiRepoInterface;
import cbir2073MV.repository.repoMock.CartiRepoMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TopDownIntegration {

    private BigBangIntegration bigBangIntegration;
    private CartiRepoInterface repo;

    private Carte setUpABook(String autor, String an){
        Carte carte = new Carte();
        carte.setAnAparitie(an);
        carte.setTitlu("Nu stiu");
        carte.setEditura("Humanitar");

        List<String> autori = new ArrayList<>();
        autori.add(autor);

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("Cheie");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(cuvinteCheie);

        return carte;
    }

    @Before
    public void setUp() throws Exception {

        bigBangIntegration = new BigBangIntegration();
        bigBangIntegration.setUp();

        repo = new CartiRepoMock();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testingEverySeparateModule(){
        bigBangIntegration.runAllSeparateModules();
    }

    @Test
    public void testingModuleA(){

        int beforeAdding = repo.getCarti().size();
        repo.adaugaCarte(setUpABook("Oana", "2001"));
        int afterAdding = repo.getCarti().size();
        assertTrue(beforeAdding == afterAdding - 1);

    }

    @Test
    public void testingModuleAAndModuleB(){

        List<Carte> oldBooks = repo.getCarti();

        int beforeAdding = repo.getCarti().size();
        repo.adaugaCarte(setUpABook("Bogdan Chise", "2019"));
        int afterAdding = repo.getCarti().size();
        assertTrue(beforeAdding == afterAdding - 1);


        List<Carte> allBooks = repo.getCarti();
        List<Carte> result = repo.cautaCarte("Bogdan Chise");

        assertTrue(result.size() == 1);

    }

    @Test
    public void testingModuleABC(){

        int beforeAdding = repo.getCarti().size();
        Carte carte = setUpABook("Bogdan IO", "2020");
        repo.adaugaCarte(carte);
        int afterAdding = repo.getCarti().size();
        assertTrue(beforeAdding == afterAdding - 1);

        List<Carte> result = repo.cautaCarte("Bogdan IO");

        assertTrue(result.size() == 1);

        List<Carte> resultViewing = repo.getCartiOrdonateDinAnul("2020");

        assertTrue(resultViewing.size() == 1);
    }
}
