package pojoDatas;

import pojoDatas.ZippopatamPlacesPojo;

public class ZippopotamPojos {

    /*
    {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
              {
                "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
              }
              ]
    }
     */

    private String postCode;
    private String country;
    private String countryAbbreviation;

    private ZippopatamPlacesPojo zippopatamPlacesPojo;

    public ZippopotamPojos(){

    }

    public ZippopotamPojos(String postCode, String country, String countryAbbreviation, ZippopatamPlacesPojo zippopatamPlacesPojo) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.zippopatamPlacesPojo=zippopatamPlacesPojo;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }
    public ZippopatamPlacesPojo getZippopatamPlacesPojo(){
        return zippopatamPlacesPojo;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }
    public void setZippopatamPlacesPojo(){
        this.zippopatamPlacesPojo=zippopatamPlacesPojo;
    }

    @Override
    public String toString() {
        return "ZippopotamPojos{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbreviation='" + countryAbbreviation + '\'' +
                ", zippopatamPlacesPojo=" + zippopatamPlacesPojo +
                '}';
    }
}
