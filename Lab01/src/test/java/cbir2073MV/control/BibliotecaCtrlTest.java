package cbir2073MV.control;

import cbir2073MV.model.Carte;
import cbir2073MV.repository.repoInterfaces.CartiRepoInterface;
import cbir2073MV.repository.repoMock.CartiRepoMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaCtrlTest {

    private CartiRepoInterface cr;
    private BibliotecaCtrl bc;
    private Carte carte;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        cr = new CartiRepoMock();
        bc = new BibliotecaCtrl(cr);
        carte = new Carte();
        setCarte();
    }

    private void setCarte() {

        carte.setEditura("Editura");
        carte.setAnAparitie("2008");
        carte.setTitlu("Titlu");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void adaugaCarteBVA_Valid_1() {

        List<String> autori = new ArrayList<>();
        autori.add("M");

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("cuvant");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(cuvinteCheie);


        try {
            int beforeAdding = bc.getCarti().size();
            bc.adaugaCarte(carte);
            int afterAdding = bc.getCarti().size();

            assertTrue(beforeAdding == afterAdding - 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void adaugaCarteBVA_Valid_2() {

        List<String> autori = new ArrayList<>();
        autori.add("Autori");

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("D");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(cuvinteCheie);


        try {
            int beforeAdding = bc.getCarti().size();
            bc.adaugaCarte(carte);
            int afterAdding = bc.getCarti().size();

            assertTrue(beforeAdding == afterAdding - 1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void adaugaCarteBVA_Non_Valid_2() throws Exception {

        List<String> autori = new ArrayList<>();
        autori.add("");

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("cuvant");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(cuvinteCheie);


        int beforeAdding = bc.getCarti().size();

        thrown.expect(Exception.class);
        thrown.expectMessage("Autor invalid!");

        bc.adaugaCarte(carte);
        int afterAdding = bc.getCarti().size();

        assertTrue(beforeAdding == afterAdding);


    }

    @Test
    public void adaugaCarteBVA_Non_Valid_1() throws Exception {

        List<String> autori = new ArrayList<>();
        autori.add("Autori");

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(cuvinteCheie);


        int beforeAdding = bc.getCarti().size();

        thrown.expect(Exception.class);
        thrown.expectMessage("Cuvant cheie invalid!");

        bc.adaugaCarte(carte);
        int afterAdding = bc.getCarti().size();

        assertTrue(beforeAdding == afterAdding);

    }


    @Test
    public void adaugaCarte_ECP_Non_Valid_2() throws Exception {

        List<String> autori = new ArrayList<>();
        autori.add("Autori");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(null);

        int beforeAdding = bc.getCarti().size();

        thrown.expect(Exception.class);
        thrown.expectMessage("Lista cuvinte cheie vida!");

        bc.adaugaCarte(carte);

        int afterAdding = bc.getCarti().size();
        assertTrue(afterAdding == beforeAdding);

    }

    @Test
    public void adaugaCarte_ECP_Non_Valid_1() throws Exception {

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("Cuvant");

        carte.setReferenti(null);
        carte.setCuvinteCheie(cuvinteCheie);

        int beforeAdding = bc.getCarti().size();

        thrown.expect(Exception.class);
        thrown.expectMessage("Lista autori vida!");

        bc.adaugaCarte(carte);


        int afterAdding = bc.getCarti().size();
        assertTrue(afterAdding == beforeAdding);

    }

    @Test
    public void adaugaCarte_ECP_Valid() {

        List<String> autori = new ArrayList<>();
        autori.add("Autori");

        List<String> cuvinteCheie = new ArrayList<>();
        cuvinteCheie.add("Cuvant");

        carte.setReferenti(autori);
        carte.setCuvinteCheie(cuvinteCheie);


        try {
            int beforeAdding = bc.getCarti().size();
            bc.adaugaCarte(carte);
            int afterAdding = bc.getCarti().size();

            assertTrue(beforeAdding == afterAdding - 1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}