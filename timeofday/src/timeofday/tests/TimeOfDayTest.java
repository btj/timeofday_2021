package timeofday.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import timeofday.TimeOfDay;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay timeOfDay = new TimeOfDay(9, 54);
		assertEquals(9, timeOfDay.getHours());
		assertEquals(54, timeOfDay.getMinutes());
		
		timeOfDay.setHours(10);
		assertEquals(10, timeOfDay.getHours());
		assertEquals(54, timeOfDay.getMinutes());
		
		timeOfDay.setMinutes(45);
		assertEquals(10, timeOfDay.getHours());
		assertEquals(45, timeOfDay.getMinutes());
	}

}
