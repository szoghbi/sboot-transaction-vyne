package br.com.votorantim.flex.base.parcelas.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateUtilTest {

	@Test
	void testConvertDateToLocalDate() {
		Date currentDate = new Date();
		LocalDate currentLocalDate = DateUtil.convertDateToLocalDate(currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);

		assertEquals(currentLocalDate.getDayOfMonth(), cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(currentLocalDate.getMonthValue(), cal.get(Calendar.MONTH) + 1);
		assertEquals(currentLocalDate.getYear(), cal.get(Calendar.YEAR));
	}

	@Test
	void testConvertDateToLocalDateTime() {
		Date currentDate = new Date();
		LocalDateTime currentLocalDateTime = DateUtil.convertDateToLocalDateTime(currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);

		assertEquals(currentLocalDateTime.getDayOfMonth(), cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(currentLocalDateTime.getMonthValue(), cal.get(Calendar.MONTH) + 1);
		assertEquals(currentLocalDateTime.getYear(), cal.get(Calendar.YEAR));
		assertEquals(currentLocalDateTime.getHour(), cal.get(Calendar.HOUR_OF_DAY));
		assertEquals(currentLocalDateTime.getMinute(), cal.get(Calendar.MINUTE));
		assertEquals(currentLocalDateTime.getSecond(), cal.get(Calendar.SECOND));
	}

	@Test
	void testGetCurrentDateWithoutTime() {
		Date currentDate = DateUtil.getCurrentDateWithoutTime();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);

		assertEquals(currentDate.getTime(), cal.getTime().getTime());
	}

	@Test
	void testConvertLocalDateTimeToDate() {
		LocalDateTime currentLocalDate = LocalDateTime.now();
		Date currentDate = DateUtil.convertLocalDateTimeToDate(currentLocalDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);

		assertEquals(currentLocalDate.getDayOfMonth(), cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(currentLocalDate.getMonthValue(), cal.get(Calendar.MONTH) + 1);
		assertEquals(currentLocalDate.getYear(), cal.get(Calendar.YEAR));
		assertEquals(currentLocalDate.getHour(), cal.get(Calendar.HOUR_OF_DAY));
		assertEquals(currentLocalDate.getMinute(), cal.get(Calendar.MINUTE));
		assertEquals(currentLocalDate.getSecond(), cal.get(Calendar.SECOND));
	}

	@Test
	void testConvertLocalDateToDate() {
		LocalDate currentLocalDate = LocalDate.now();
		Date currentDate = DateUtil.convertLocalDateToDate(currentLocalDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);

		assertEquals(currentLocalDate.getDayOfMonth(), cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(currentLocalDate.getMonthValue(), cal.get(Calendar.MONTH) + 1);
		assertEquals(currentLocalDate.getYear(), cal.get(Calendar.YEAR));
	}

}
