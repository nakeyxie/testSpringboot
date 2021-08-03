/*
package com.xiechy.Date;





import com.xiechy.testConnect.JsonUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

*/
/**
 * @ClassName TestDateTime
 * @Description TODO
 * @Author xcy
 * @Date 2020/8/12 14:55
 *//*

public class TestDateTime {

    @Test
    public void test(){
        sendCoup(1L);
    }

    @Test
    public void testDate(){
         Date date =DateTime.now().millisOfDay().withMinimumValue().toDate();
        System.out.println(date);
    }


    private boolean todaySend(Coupon coupon) {
        List<String> sendDates = new ArrayList<>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Date startDate = coupon.getStartDate();
        String date3 = sf.format(getDayAfter(startDate, 2));
        String date6 = sf.format(getDayAfter(startDate, 5));
        String date7 = sf.format(getDayAfter(startDate, 6));
        sendDates.add(date7);
        sendDates.add(date3);
        sendDates.add(date6);
        String now = sf.format(new Date());
        if (sendDates.contains(now)) {
            return true;
        }
        return false;
    }

    */
/**
     * 获取日期后N天
     *
     * @param date
     * @return
     *//*

    public static Date getDayAfter(Date date,int num) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DATE);
        gregorianCalendar.set(Calendar.DATE, day + num);
        return gregorianCalendar.getTime();
    }

    public void sendCoup(Long userId) {
        DateTime date = DateTime.now().millisOfDay().withMinimumValue();
        Date endDateTime = date.plusDays(7).toDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDateTime);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date endDate = calendar.getTime();
        List<Coupon> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Coupon coupon = Coupon.builder()
                    .userId(userId).srcNo(String.valueOf(userId))
                    .amount(BigDecimal.valueOf(4.99))
                    .limitAmount(BigDecimal.valueOf(5L))
                    .promotionId(33L)
                    .startDate(date.toDate())
                    .endDate(endDate)
                    .status(Coupon.Status.INIT.code())
                    .createDate(new Date())
                    .updateDate(new Date())
                    .build();
            System.out.println(coupon);
            todaySend(coupon);
            System.out.println("coupon[" + i + "]:" + JsonUtils.toJSONString(coupon));
            date = date.plusDays(1);
            result.add(coupon);
        }
        System.out.println(result);
        String date1 ="";
        String a ="{\"amount\": \""+3+"\", \"date\": \""+date+"\"}";

    }
}
*/
