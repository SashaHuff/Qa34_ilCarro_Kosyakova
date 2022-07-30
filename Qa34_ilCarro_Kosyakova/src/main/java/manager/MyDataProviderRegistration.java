package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviderRegistration {
    @DataProvider
    public Iterator<Object[]> dataReg(){
        List<Object []> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("Two").setLastName("Dow").setEmail("twodow@gmail.com").setPassword("Ttwo1234$")});
        list.add(new Object[]{new User().setName("One").setLastName("Fox").setEmail("onefox@gmail.com").setPassword("OneFox12345$")});
 //       list.add(new Object[]{new User().setName("Shon").setLastName("Two").setEmail("two@gmail.com").setPassword("Sshon12345$")});
        return list.iterator();
    }
}
