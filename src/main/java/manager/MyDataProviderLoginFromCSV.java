package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviderLoginFromCSV {
    @DataProvider
    public Iterator<Object[]> loginCSV() throws IOException {
        List<Object []> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\src\\test\\resources\\login.csv")));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}

