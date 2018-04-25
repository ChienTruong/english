package rio.it.Dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import rio.it.App.Entity.PartEntity;
import rio.it.App.Repository.PartRepository;
import rio.it.EnglishApplicationTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by chien on 16/04/2018.
 */
@Transactional
public class PartRepositoryImplTest extends EnglishApplicationTests {

    @Autowired
    private PartRepository partRepository;

    @Test
    public void testFindByName_Success() {
        String input = "Seven";
        String expected = "PartSeven";
        PartEntity partEntityResult = this.partRepository.findByName(input);
        Assert.assertThat(partEntityResult.getPartName(), is(equalTo(expected)));
    }

    @Test(expected = Exception.class)
    public void testFindByName_Error() {
        String input = "Eight";
        this.partRepository.findByName(input);
    }
}