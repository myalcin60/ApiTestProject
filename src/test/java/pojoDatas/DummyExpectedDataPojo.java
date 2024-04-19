package pojoDatas;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyExpectedDataPojo {
    /*
    {
    "status": "success",
    "data": {
        "name": "Kemal Sunal",
        "salary": "40000",
        "age": "27",

    },
    "message": "Successfully! Record has been added."
}
     */
    private String status;
    private DummyRestApiPojo data;

    private String message;

    public DummyExpectedDataPojo() {
    }

    public DummyExpectedDataPojo(String status, DummyRestApiPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiPojo getData() {
        return data;
    }

    public void setData(DummyRestApiPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyExpectedDataPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
