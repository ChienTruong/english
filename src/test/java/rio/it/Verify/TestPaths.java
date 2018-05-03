package rio.it.Verify;

import org.junit.Test;

/**
 * Created by CongN on 4/23/2018.
 */
public class TestPaths {
   private String osName = System.getProperty("os.name");
   private String osNamepath = osName.toLowerCase();
   private String pathName = null;

    @Test
    public void systemOpera(){
        if (osNamepath.contains("linux")){
            pathName = System.getProperty("user.home");

        }else if (osNamepath.contains("windows")){

            pathName = System.getProperty("user.home");

        }else if (osNamepath.contains("mac os")){
            pathName = System.getProperty("os.name")+System.getProperty("user.name");
        }
        System.out.println(pathName);
    }


}

