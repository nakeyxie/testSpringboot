package com.xiechy.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Coupon {

    private Long id;

    private Long promotionId;

    private String srcNo;

    private Long userId;

    private BigDecimal amount;

    private BigDecimal limitAmount;

    private Integer status;

    private String orderNo;

    private Date startDate;

    private Date endDate;

    private Date createDate;

    private Date updateDate;

    public enum Status {
        INIT(0), LOCK(1), PAY(2), REFUND(3), OUTDATE(4);
        private final int code;

        Status(int code) {
            this.code = code;
        }

        public int code() {
            return this.code;
        }
    }

    public enum Type {

    }
}
