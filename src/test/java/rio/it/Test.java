package rio.it;

import org.springframework.mock.web.MockMultipartFile;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Util.Impl.DoVerify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 17/04/2018.
 */
public class Test {
    private static final DoVerify doVerifyPartOne = new DoVerify(false, true, true, true, true, true, true, 10, 1, 1, 1, 4);
    private static final DoVerify doVerifyPartTwo = new DoVerify(false, true, true, true, true, true, true, 30, 1, 1, 0, 3);

    //    private static final DoVerify doVerifyPartTwo = new DoVerify();
//    private static final DoVerify doVerifyPartThree = new DoVerify();
//    private static final DoVerify doVerifyPartFour = new DoVerify();
//    private static final DoVerify doVerifyPartFive = new DoVerify();
//    private static final DoVerify doVerifyPartSix = new DoVerify();
//    private static final DoVerify doVerifyPartSeven = new DoVerify();
    @org.junit.Test
    public void test() {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("dsa","dfdsaf.fsdaf.sdaf.sad.fsad.f.sad.fs.f.sa.fs.df.sad.f.sa.fs.df.s.fas.fas.f..s.a.txt", "dsa", "dsada".getBytes());
        String[]  s =  mockMultipartFile.getOriginalFilename().split("\\.");

        System.out.println(s[s.length - 1]);
    }
}
