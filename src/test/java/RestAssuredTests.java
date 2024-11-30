import models.countries.CountryData;
import models.objects.ObjectModel;
import models.objects.ObjectRequestBuilder;
import org.junit.jupiter.api.Test;
import steps.RestAssuredSteps;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static paths.EndpointPaths.*;

public class RestAssuredTests extends RestAssuredSteps {

    @Test
    void testGetCountrySpain() {

        List<CountryData> spainResponse = sendGetRequest(spain).jsonPath().getList("", CountryData.class);
        assertThat(spainResponse.get(0).getName().getCommon()).isEqualTo("Spain");
        assertThat(spainResponse.get(0).getName().getOfficial()).isEqualTo("Kingdom of Spain");
        assertThat(spainResponse.get(0).getIndependent()).isEqualTo(true);
        assertNotNull(spainResponse.get(0).getArea());
        assertThat(spainResponse.get(0).getContinents().size()).isEqualTo(1);
        assertThat(spainResponse.get(0).getContinents().get(0)).isEqualTo("Europe");
    }

    @Test
    void testGetCountriesIndependent() {

        List<CountryData> independentResponse = sendGetRequest(independentCountries).jsonPath().getList("", CountryData.class);
        assertThat(independentResponse.size()).isEqualTo(194);
    }

    @Test
    void testGetCountriesRegionEurope() {

        List<CountryData> europeResponse = sendGetRequest(europe).jsonPath().getList("", CountryData.class);
        assertThat(europeResponse.size()).isEqualTo(53);
    }

    @Test
    void testPostObjectRequest() {

        ObjectModel dataRequest = ObjectRequestBuilder.defaultObject();
        String response = sendPostRequest(objects, dataRequest);
        assertThat(response).isEqualTo("Hello world from Spring Boot");
    }
}
