package sda.jdbc.przyklad4;

public class Address {

    private int id;
    private String street;
    private String buildingNo;
    private String apartmentNo;
    private String city;
    private String postalCode;
    private Country country;

    public Address(int id, String street, String buildingNo, String apartmentNo, String city, String postalCode, Country country) {
        this.id = id;
        this.street = street;
        this.buildingNo = buildingNo;
        this.apartmentNo = apartmentNo;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", apartmentNo='" + apartmentNo + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country=" + country +
                '}';
    }
}
