package models.objects;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.Date;

public class ObjectRequestBuilder {

    private static final Faker FAKER = new Faker();

    public static ObjectModel defaultObject(){
        return new ObjectModel()
            .setName(FAKER.backToTheFuture().character())
                .setData(dataForObject());

    }

    private static ObjectData dataForObject(){
        return new ObjectData()
                .setYear(randomYear())
                .setPrice(999.99)
                .setCpu_model(FAKER.book().genre())
                .setHard_disk_size(FAKER.numerify("3056"));
    }

    private static int randomYear(){
        Date pastDate = FAKER.date().past(100 * 365, java.util.concurrent.TimeUnit.DAYS);
        int randomYear = pastDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .getYear();
        return randomYear;
    }
}
