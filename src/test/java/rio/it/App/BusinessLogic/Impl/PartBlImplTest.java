package rio.it.App.BusinessLogic.Impl;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rio.it.App.Service.AccountService;
import rio.it.App.Service.PartService;

/**
 * Created by chien on 08/05/2018.
 */
public class PartBlImplTest {

    @InjectMocks
    private PartBlImpl partBl;
    @Mock
    private AccountService accountService;
    @Mock
    private PartService partService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}