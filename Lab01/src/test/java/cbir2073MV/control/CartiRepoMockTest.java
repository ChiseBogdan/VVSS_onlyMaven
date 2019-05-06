package cbir2073MV.control;

import cbir2073MV.model.Carte;
import cbir2073MV.repository.repoInterfaces.CartiRepoInterface;
import cbir2073MV.repository.repoMock.CartiRepoMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartiRepoMockTest {

    private CartiRepoInterface repo;

    @Before
    public void setUp() throws Exception {

        repo = new CartiRepoMock();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void cautaCarte_Non_Valid() {

        repo.eliminaToateCartile();

        List<Carte> cartiGasite = repo.cautaCarte("");

        assertTrue(cartiGasite.size() == 0);
    }

//    @Test
//    public void cautaCarte_Non_Valid2() {
//
//        List<Carte> cartiGasite = repo.cautaCarte("");
//
//        assertTrue(cartiGasite.size() == 0);
//    }

    @Test
    public void cautaCarte_Valid() {

        List<Carte> cartiGasite = repo.cautaCarte("Ion");

        assertTrue(cartiGasite.size() == 2);
    }

}