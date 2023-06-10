package com.barogo.delivery.domain;

import com.barogo.common.constants.MessageConstant;
import com.barogo.delivery.dto.DeliveryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String userId;
    @Column(nullable = false, length = 50)
    private String sellerShopName;
    @Column(nullable = false, length = 50)
    private String sellerName;
    @Column(nullable = false, length = 100)
    private String sellerShopAddress;
    @Column(nullable = false, length = 100)
    private String sellerShopAddressDetail;
    @Column(nullable = false, length = 100)
    private String orderShopAddress;
    @Column(nullable = false, length = 100)
    private String orderShopAddressDetail;
    @Column(nullable = false, length = 11)
    private String orderPhone;
    @Column(nullable = false, precision = 19)
    private BigDecimal totalAmount;
    @Column(nullable = false, length = 8)
    private String date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private DeliveryStatus status;
    @Column(nullable = false, length = 100)
    private String memo;

    public void updateAddress(DeliveryRequestDto deliveryRequestDto) {
        this.orderShopAddress = deliveryRequestDto.getOrderShopAddress();
        this.orderShopAddressDetail = deliveryRequestDto.getOrderShopAddressDetail();
    }
}
