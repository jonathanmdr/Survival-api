package br.com.survival.domain.service.mock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;

public class MockData {
	
	private MockData() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String getRandomCode() {
		return UUID.randomUUID().toString();
	}
	
	public static BigDecimal getRandomBigDecimal() {
		BigDecimal min = BigDecimal.valueOf(100D);
		BigDecimal max = BigDecimal.valueOf(5000D);
		
	    BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
	    return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
	}
	
	public static OffsetDateTime getRandomDateTime() {
		OffsetDateTime startDateTime = OffsetDateTime.parse("2019-12-01T00:00:00+00:00");
	    OffsetDateTime latestDateTime = OffsetDateTime.now();	    
	    Random random = new Random(0);
	        
		long differenceInSeconds = startDateTime.until(latestDateTime, ChronoUnit.SECONDS);
        long seconds = nextLong(random, differenceInSeconds);
        return startDateTime.plusSeconds(seconds);
	}
	
	private static long nextLong(Random rng, long n) {
        long bits, val;
        
        do {
           bits = (rng.nextLong() << 1) >>> 1;
           val = bits % n;
        } while (bits - val + (n - 1) < 0L);
        
        return val;
    } 

}
