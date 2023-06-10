package com.barogo.delivery.aplication;

import com.barogo.common.exception.NotFoundEntityException;
import com.barogo.delivery.domain.Delivery;
import com.barogo.delivery.domain.DeliveryStatus;
import com.barogo.delivery.dto.DeliveryConditionDto;
import com.barogo.delivery.dto.DeliveryRequestDto;
import com.barogo.delivery.exception.DeliveryValidateException;
import com.barogo.delivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    /**
     * 주문내역 조회
     */
    public List<Delivery> findAllHistory(String userId, DeliveryConditionDto condition) {

        if (condition.isGreaterPeriod(3)) {
            throw new IllegalArgumentException();
        }

        return deliveryRepository.findAllByUserIdAndDateBetween(userId, condition.getStartDate(), condition.getEndDate());
    }

    /**
     * 배송지 변경
     */
    public Delivery modifyDeliveryAddress(Long id, String userId, DeliveryRequestDto deliveryRequestDto) {
        //전달 받은 실제 주소지가 존재하는지 예외처리 필요

        //해당 유저, 주문 아이디로 배달 건이 있는지 체크
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);

        validateDelivery(delivery, userId);

        delivery.updateAddress(deliveryRequestDto);

        return delivery;
    }

    public void validateDelivery(Delivery delivery, String userId) {
        // 배달 준비 중 인 경우만 가능하다.
        if (delivery.getStatus() != DeliveryStatus.WAITING) {
            throw new DeliveryValidateException();
        }
        // 자신의 배달 만 수정 할 수 있다.
        if (!delivery.getUserId().equals(userId)) {
            throw new DeliveryValidateException();
        }
    }
}
