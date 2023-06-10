package com.barogo.delivery.ui;

import com.barogo.delivery.aplication.DeliveryService;
import com.barogo.delivery.dto.DeliverResponseDto;
import com.barogo.delivery.dto.DeliveryConditionDto;
import com.barogo.delivery.dto.DeliveryRequestDto;
import com.barogo.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/delivery")
@RestController
public class DeliveryController {
    private final DeliveryService deliveryService;

    /**
     * 배송조회
     */
    @GetMapping("/history")
    public ResponseEntity<List<DeliverResponseDto>> findAllHistory(DeliveryConditionDto condition, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok().body(
                deliveryService.findAllHistory(user.getUserId(), condition)
                        .stream()
                        .map(DeliverResponseDto::toResponse)
                        .collect(Collectors.toList())
        );
    }

    /**
     * 배송지 변경
     */
    @PutMapping("/{id}")
    public ResponseEntity<DeliverResponseDto> modifyDeliveryAddress(@PathVariable Long id,
                                                                    @RequestBody @Valid DeliveryRequestDto deliveryRequestDto,
                                                                    @AuthenticationPrincipal User user) {
        return ResponseEntity.ok()
                .body(DeliverResponseDto
                        .toResponse(deliveryService.modifyDeliveryAddress(id, user.getUserId(), deliveryRequestDto)));
    }
}
