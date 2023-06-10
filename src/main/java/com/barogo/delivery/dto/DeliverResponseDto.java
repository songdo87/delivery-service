package com.barogo.delivery.dto;

import com.barogo.delivery.domain.Delivery;
import com.barogo.delivery.domain.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class DeliverResponseDto {
    private Long id;
    private String sellerShopName;
    private String sellerName;
    private String sellerShopAddress;
    private String sellerShopAddressDetail;
    private String orderShopAddress;
    private String orderShopAddressDetail;
    private String orderPhone;
    private BigDecimal totalAmount;
    private String date;
    private DeliveryStatus status;
    private String memo;

    public static DeliverResponseDto toResponse(Delivery delivery) {
        return DeliverResponseDto.builder()
                .id(delivery.getId())
                .sellerShopName(delivery.getSellerShopName())
                .sellerName(delivery.getSellerName())
                .sellerShopAddress(delivery.getSellerShopAddress())
                .sellerShopAddressDetail(delivery.getSellerShopAddressDetail())
                .orderShopAddress(delivery.getOrderShopAddress())
                .orderShopAddressDetail(delivery.getOrderShopAddressDetail())
                .orderPhone(delivery.getOrderPhone())
                .totalAmount(delivery.getTotalAmount())
                .date(delivery.getDate())
                .status(delivery.getStatus())
                .memo(delivery.getMemo())
                .build();
    }
}