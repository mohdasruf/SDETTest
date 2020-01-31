package inter.glueCode;


import com.google.gson.Gson;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import inter.utilities.*;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class StepDef extends Utils {


    private Response response;

    @Then("^response status code should be (\\d+)$")
    public void responseStatusCodeShouldBe(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }


    @And("^response should include the following \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void responseShouldIncludeTheFollowing(String Name, String Email, String Street, String City, String Suite, String Zipcode, String Lat, String Long, String Phone, String Website) throws Throwable {
        String name = response.jsonPath().get("name");
        String email = response.jsonPath().get("email");
        String street = response.jsonPath().get("address.street");
        String city = response.jsonPath().get("address.city");
        String suite = response.jsonPath().get("address.suite");
        String zipcode = response.jsonPath().get("address.zipcode");
        String lat = response.jsonPath().get("address.geo.lat");
        String lng = response.jsonPath().get("address.geo.lng");
        String phone = response.jsonPath().get("phone");
        String website = response.jsonPath().get("website");

        Assert.assertEquals("Correct name was returned", Name, name);
        Assert.assertEquals("Correct email was returned", Email, email);
        Assert.assertEquals("Correct street was returned", Street, street);
        Assert.assertEquals("Correct city was returned", City, city);
        Assert.assertEquals("Correct suite was returned", Suite, suite);
        Assert.assertEquals("Correct zipcode was returned", Zipcode, zipcode);
        Assert.assertEquals("Correct latitude was returned", Lat, lat);
        Assert.assertEquals("Correct longitude was returned", Long, lng);
        Assert.assertEquals("Correct phone was returned", Phone, phone);
        Assert.assertEquals("Correct website was returned", Website, website);

    }

    @Given("^the baseURI is set$")
    public void theBaseURIIsSet() {
        Utils.setBaseURI();
    }

    @Given("^I make a get request to the \"([^\"]*)\" using \"([^\"]*)\"$")
    public void iMakeAGetRequestToTheUsing(String endpoint, String Id) throws Throwable {
        request();
        response = request.get("/" + endpoint + "/" + Id);
    }

    @Given("^I make a post request to the \"([^\"]*)\" using \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iMakeAPostRequestToTheUsing(String endpoint, String Name, String Username, String Email, String Street, String City, String Suite, String zipcode, String Lat, String Long, String Phone, String Website, String CompanyName, String CatchPhrase, String Bs) throws Throwable {
        request();
        Geo geo = new Geo();
        geo.setLat(Lat);
        geo.setLng(Long);
        Address address = new Address();
        address.setStreet(Street);
        address.setSuite(Suite);
        address.setGeo(geo);
        address.setZipcode(zipcode);
        address.setCity(City);
        Company company = new Company();
        company.setBs(Bs);
        company.setCatchPhrase(CatchPhrase);
        company.setName(CompanyName);
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress(address);
        userInfo.setCompany(company);
        userInfo.setEmail(Email);
        userInfo.setName(Name);
        userInfo.setUsername(Username);
        userInfo.setPhone(Phone);
        userInfo.setWebsite(Website);
        Gson gson = new Gson();
        String exampleJson = gson.toJson(userInfo);
        request.body(exampleJson);
        response = request.post(endpoint);
    }

    @Given("^I make a put request to the \"([^\"]*)\" using \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iMakeAPutRequestToTheUsing(String endpoint, String Name, String Username, String Email, String Street, String City, String Suite, String zipcode, String Lat, String Long, String Phone, String Website, String CompanyName, String CatchPhrase, String Bs, String Id) throws Throwable {
        request();
        Geo geo = new Geo();
        geo.setLat(Lat);
        geo.setLng(Long);
        Address address = new Address();
        address.setStreet(Street);
        address.setSuite(Suite);
        address.setGeo(geo);
        address.setZipcode(zipcode);
        address.setCity(City);
        Company company = new Company();
        company.setBs(Bs);
        company.setCatchPhrase(CatchPhrase);
        company.setName(CompanyName);
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress(address);
        userInfo.setCompany(company);
        userInfo.setEmail(Email);
        userInfo.setName(Name);
        userInfo.setUsername(Username);
        userInfo.setPhone(Phone);
        userInfo.setWebsite(Website);
        Gson gson = new Gson();
        String exampleJson = gson.toJson(userInfo);
        request.body(exampleJson);
        response = request.put(endpoint + "/" + Id);
        System.out.println("response :" + response.asString());
    }

    @Given("^I make a search request to the \"([^\"]*)\" using \"([^\"]*)\"$")
    public void iMakeASearchRequestToTheUsing(String endpoint, String emailId) throws Throwable {
        request();
        response = request.get(endpoint + "?" + "email" + "=" + emailId);
    }


    @And("^response in the list should include the following \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void responseInTheListShouldIncludeTheFollowing(String Name, String Email, String Street, String City, String Suite, String Zipcode, String Lat, String Long, String Phone, String Website) throws Throwable {
        String name = response.jsonPath().get("name[0]");
        String email = response.jsonPath().get("email[0]");
        String street = response.jsonPath().get("address.street[0]");
        String city = response.jsonPath().get("address.city[0]");
        String suite = response.jsonPath().get("address.suite[0]");
        String zipcode = response.jsonPath().get("address.zipcode[0]");
        String lat = response.jsonPath().get("address.geo.lat[0]");
        String lng = response.jsonPath().get("address.geo.lng[0]");
        String phone = response.jsonPath().get("phone[0]");
        String website = response.jsonPath().get("website[0]");

        Assert.assertEquals("Correct name was returned", Name, name);
        Assert.assertEquals("Correct email was returned", Email, email);
        Assert.assertEquals("Correct street was returned", Street, street);
        Assert.assertEquals("Correct city was returned", City, city);
        Assert.assertEquals("Correct suite was returned", Suite, suite);
        Assert.assertEquals("Correct zipcode was returned", Zipcode, zipcode);
        Assert.assertEquals("Correct latitude was returned", Lat, lat);
        Assert.assertEquals("Correct longitude was returned", Long, lng);
        Assert.assertEquals("Correct phone was returned", Phone, phone);
        Assert.assertEquals("Correct website was returned", Website, website);

    }

}


