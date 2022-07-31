package manager;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviderLogin {
    @DataProvider
    public Iterator<Object[]> dataLogin(){
        List<Object []> list = new ArrayList<>();
        list.add(new Object[]{"huff1@gmail.com","Hhuff11234$"});
        list.add(new Object[]{"huff@gmail.com","Hhuff1234$"});
        list.add(new Object[]{"alex1@gmail.com","Aalex1234"});
        list.add(new Object[]{"joe@gmail.com","Dow1234+"});
        list.add(new Object[]{"alice@gmail.com","Ffox12345$"});
        list.add(new Object[]{"regi@gmail.com","Ffive1234$"});
        list.add(new Object[]{"two@gmail.com","Sshon12345$"});
        return list.iterator();
    }
}
