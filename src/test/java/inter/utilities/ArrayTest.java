package inter.utilities;

import com.google.gson.Gson;

public class ArrayTest {

    public static void main(String[] args) {
        Geo geo = new Geo();
        geo.setLat("-37.3159");
        geo.setLng("81.1496");
        Gson gson = new Gson();
        String userWithAddressJson = gson.toJson(geo);
        System.out.println("User with address JSON" + userWithAddressJson);
        Address address = new Address();
        address.setStreet("Kulas Light");
        address.setSuite("Apt. 556");
        address.setGeo(geo);
        address.setZipcode("92998-3874");
        address.setCity("Gwenborough");
        String addresswithGeoJson = gson.toJson(address);
        System.out.println("address with geo JSON" + addresswithGeoJson);
        Company company = new Company();
        company.setBs("harness real-time e-markets");
        company.setCatchPhrase("Multi-layered client-server neural-net");
        company.setName("Romaguera-Crona");
        Example example = new Example();
        example.setAddress(address);
        example.setCompany(company);
        example.setEmail("asr@april.biz");
        example.setName("Mohamed");
        example.setUsername("Mo");
        example.setPhone("1-770-736-8031 x56442");
        example.setWebsite("hildegard.org");
        String exampleJson = gson.toJson(example);
        System.out.println("example JSON" + exampleJson);
}
}
