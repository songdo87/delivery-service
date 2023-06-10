package com.barogo.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static com.barogo.common.utils.DateUtils.DATE_FORMATTER_REGEX;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class DeliveryConditionDto {
    @NotBlank
    @Pattern(regexp = DATE_FORMATTER_REGEX)
    @Size(max = 8)
    private String startDate;
    @NotBlank
    @Pattern(regexp = DATE_FORMATTER_REGEX)
    @Size(max = 8)
    private String endDate;

    public boolean isGreaterPeriod(int gap) {
        Period period = Period.between(LocalDate.parse(startDate, DateTimeFormatter.BASIC_ISO_DATE),
                        LocalDate.parse(endDate, DateTimeFormatter.BASIC_ISO_DATE));
        return period.getDays() > gap;
    }
}