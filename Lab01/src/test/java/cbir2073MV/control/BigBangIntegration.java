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

public class BigBangIntegration {

    private BibliotecaCtrlTest bibliotecaCtrlTest;
    private CartiRepoMockTest cartiRepoMockTest;
    private FuncThreeTest funcThreeTest;

    private CartiRepoInterface repo;

    @Before
    public void setUp() throws Exception {

        bibliotecaCtrlTest = new BibliotecaCtrlTest();
        bibliotecaCtrlTest.setUp();

        cartiRepoMockTest = new CartiRepoMockTest();
        cartiRepoMockTest.setUp();

        funcThreeTest = new FuncThreeTest();
        funcThreeTest.setUp();

        repo = new CartiRepoMock();
    }

    @After
    public void tearDown() throws Exception {
    }

    // testing add a book
    @Test
    public void testingModuleA(){

        bibliotecaCtrlTest.adaugaCarte_ECP_Valid();
    }

    // testing search a book by an author
    @Test
    public void testingModuleB(){

        cartiRepoMockTest.cautaCarte_Valid();
    }

    // testing show all books from a given year
    @Test
    public void testingModuleC(){

        funcThreeTest.ECP_valid_test_showTheBooksFromASpecificYear();
    }

    public void runAllSeparateModules(){
        testingModuleA();
        testingModuleB();
        testingModuleC();
    }

    @Test
    public void combiningAllModules(){

        Carte carte = new Carte();
        carte.setAnAparitie("2007");
        carte.setTitlu("Nu stiu");
        carte.setEditura("Humanitar");

        List<String> autori = new ArrayList<>();
        autori.add("Bogdan Chise");

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("Cheie");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(cuvinteCheie);

        int beforeAdding = repo.getCarti().size();
        repo.adaugaCarte(carte);
        int afterAdding = repo.getCarti().size();
        assertTrue(beforeAdding == afterAdding - 1);


        List<Carte> result = repo.cautaCarte("Bogdan Chise");

        assertTrue(result.size() == 1);


        List<Carte> resultViewing = repo.getCartiOrdonateDinAnul("2007");

        assertTrue(resultViewing.size() == 1);
    }


}
