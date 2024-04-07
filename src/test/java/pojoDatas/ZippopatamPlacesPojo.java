package pojoDatas;

public class ZippopatamPlacesPojo {

    /*
    "places": [
              {
                "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
              }
              ]

              POJO --> Plain Old Java Object
              Expected dataları yada Actual dataları depolamak icin kullanırız.

              POJO olusturma stepleri;

              1) Private Field ler olusturma
              2) Parametresiz Constructor
              3) Parametreli Constructor
              4) Getter and Setter
              5) toString()

     */

    private String placeName;
    private String longitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;

    public ZippopatamPlacesPojo(){


    }

    public ZippopatamPlacesPojo(String placeName, String longitude, String state, String stateAbbreviation, String latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }

       public String getPlaceName() {
        return placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getState() {
        return state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "ZippopatamPlacesPojo{" +
                "placeName='" + placeName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", stateAbbreviation='" + stateAbbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
