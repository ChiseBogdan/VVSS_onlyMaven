package cbir2073MV.control;

import cbir2073MV.model.Carte;
import cbir2073MV.repository.repoInterfaces.CartiRepoInterface;
import cbir2073MV.repository.repoMock.CartiRepoMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FuncThreeTest {

    private CartiRepoInterface repo;

    @Before
    public void setUp() throws Exception {

        repo = new CartiRepoMock();

    }

    @After
    public void tearDown() throws Exception {
    }

    // I used ECP and gave a string and a non string value
    @Test
    public void ECP_valid_test_showTheBooksFromASpecificYear(){
        List<Carte> result = repo.getCartiOrdonateDinAnul("1948");

        assertTrue(result.size() == 3);
    }

    @Test
    public void ECP_invalid_test(){
        List<Carte> result = repo.getCartiOrdonateDinAnul(null);

        assertTrue(result.size() == 0);
    }

}
