package com.example.douglas.empresas;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Douglas on 02/08/2017.
 */

public class Empresa {

    /**
     * É criada a classe Empresa, com os campos necessários gerados pela chamda no WebSerice
     * a utilização da serealização permite que salve o estado do objeto, utilizando quando necessário.
     */

    @SerializedName("id")
    private int id;

    @SerializedName("enterprise_name")
    private String enterpriseName;

    @SerializedName("description")
    private String description;

    @SerializedName("email_enterprise")
    private String email;

    @SerializedName("facebook")
    private String facebook;

    @SerializedName("twitter")
    private String twitter;

    @SerializedName("linkedin")
    private String linkedin;

    @SerializedName("phone")
    private String phone;

    @SerializedName("own_enterprise")
    private Boolean ownEnterprise;

    @SerializedName("photo")
    private String photo;

    @SerializedName("value")
    private float value;

    @SerializedName("shares")
    private String shares;

    @SerializedName("share_price")
    private float sharePrice;

    @SerializedName("own_shares")
    private Boolean ownShares;

    @SerializedName("city")
    private String city;

    @SerializedName("country")
    private String country;


    @SerializedName("enterprise_type")
    private EmpresaTipo enterpriseType;


    public Empresa(int id, String enterpriseName, String description,
                   String email, String facebook, String twitter, String linkedin, String phone,
                   Boolean ownEnterprise, String photo, float value, String shares,
                   float sharePrice, Boolean ownShares, String city, String country,
                   EmpresaTipo enterpriseType) {
        this.id = id;
        this.enterpriseName = enterpriseName;
        this.description = description;
        this.email = email;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedin = linkedin;
        this.phone = phone;
        this.ownEnterprise = ownEnterprise;
        this.photo = photo;
        this.value = value;
        this.shares = shares;
        this.sharePrice = sharePrice;
        this.ownShares = ownShares;
        this.city = city;
        this.country = country;
        this.enterpriseType = enterpriseType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getOwnEnterprise() {
        return ownEnterprise;
    }

    public void setOwnEnterprise(Boolean ownEnterprise) {
        this.ownEnterprise = ownEnterprise;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public float getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(float sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Boolean getOwnShares() {
        return ownShares;
    }

    public void setOwnShares(Boolean ownShares) {
        this.ownShares = ownShares;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public EmpresaTipo getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EmpresaTipo enterpriseType) {
        this.enterpriseType = enterpriseType;
    }


}
