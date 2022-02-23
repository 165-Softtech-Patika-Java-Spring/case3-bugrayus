package com.case3bugrayus.model.request;

import lombok.Data;

@Data
public class CreateAddressRequestModel {
    int doorNumber;
    int apartmentNumber;
    String name;
    int countryId;
    int cityId;
    int districtId;
    int quarterId;
    int streetId;
}
