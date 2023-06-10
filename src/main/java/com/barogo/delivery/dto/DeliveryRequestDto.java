package com.barogo.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequestDto {
    @NotBlank
    @Size(max = 50)
    private String orderShopAddress;
    @NotBlank
    @Size(max = 100)
    private String orderShopAddressDetail;
}
