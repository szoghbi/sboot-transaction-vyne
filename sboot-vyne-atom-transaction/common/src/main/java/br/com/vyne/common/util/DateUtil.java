package br.com.vyne.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public interface DateUtil {

	public static LocalDate convertDateToLocalDate(Date dateToConvertA) {
		return !Objects.isNull(dateToConvertA)
				? Instant.ofEpochMilli(dateToConvertA.getTime()).atZone(ZoneId.systemDefault()).toLocalDate()
				: null;
	}

}
