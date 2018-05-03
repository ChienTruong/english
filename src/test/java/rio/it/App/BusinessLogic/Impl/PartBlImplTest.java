package rio.it.App.BusinessLogic.Impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Service.AccountService;
import rio.it.App.Service.PartQuestionService;
import rio.it.App.Service.PartService;

import java.util.*;

/**
 * Created by chien on 30/04/2018.
 */
public class PartBlImplTest {

    @InjectMocks
    private PartBlImpl partBl;
    @Mock
    private AccountService accountService;
    @Mock
    private PartService partService;
    @Mock
    private PartQuestionService partQuestionService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.partBl.setRandom(new Random());
    }

    @Test
    public void test() {
        // input
        String namePart = "one";
        String nameUser = "admin";
        // prepare
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            idList.add(Long.valueOf(i + 1));
        }
        Map<Long, Integer> mapCount = new HashMap<>();
        mapCount.put(1L, 1);
        Long id = 1L;
        // result
        PartQuestionModel partQuestionModel = new PartQuestionModel();
        // mock
        Mockito.when(this.partService.checkExist(namePart)).thenReturn(true);
        Mockito.when(this.partService.getAllIdOfListPartQuestion(namePart)).thenReturn(idList);
//        Mockito.when(this.accountService.getHistoryOfUser(nameUser)).thenReturn(mapCount);
        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(idList.get(integerArgumentCaptor.capture())).thenReturn(id);
        Mockito.when(this.partQuestionService.getById(id)).thenReturn(partQuestionModel);
        Assert.assertEquals(partQuestionModel, this.partBl.getPartQuestionRandom(namePart, nameUser));
    }
}