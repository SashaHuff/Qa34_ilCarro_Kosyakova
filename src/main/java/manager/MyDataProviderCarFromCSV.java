package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviderCarFromCSV {
    @DataProvider
    public Iterator<Object[]> carCSV() throws IOException {
        List<Object []> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\alexa\\Documents\\GitHub\\Qa34_ilCarro_Kosyakova\\Qa34_ilCarro_Kosyakova\\src\\test\\resources\\car.csv")));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{Car.builder()
                    .address(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .engine(split[4])
                    .fuel(split[5])
                    .gear(split[6])
                    .wD(split[7])
                    .doors(split[8])
                    .seats(split[9])
                    .carClass(split[10])
                    .fuelConsumption(split[11])
                    .carRegNumber(split[12])
                    .price(split[13])
                    .distanceIncluded(split[14])
                    .features(split[15])
                    .about(split[16])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}

