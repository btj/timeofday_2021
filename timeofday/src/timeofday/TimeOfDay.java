package timeofday;

/**
 * Each instance of this class stores a time of day, with one-minute granularity.
 * 
 * @invar The hours are between zero and 23
 *     | 0 <= getHours() && getHours() <= 23
 * @invar The minutes are between zero and 59
 *     | 0 <= getMinutes() && getMinutes() <= 59
 */
public class TimeOfDay {
	
	/**
	 * @invar The minutes since midnight are between 0 and 24 * 60 - 1
	 *     | 0 <= minutesSinceMidnight &&
	 *     | minutesSinceMidnight < 24 * 60
	 */
	private int minutesSinceMidnight;
	
	/**
	 * @basic
	 */
	public int getHours() { 
		return minutesSinceMidnight / 60;
	}

	/**
	 * @basic
	 */
	public int getMinutes() {
		return minutesSinceMidnight % 60;
	}
	
	/**
	 * Initializes this object with the given hours and minutes.
	 * 
	 * Contractueel:
	 * @pre The given hours have to be between 0 and 23
	 *     | 0 <= hours && hours <= 23
	 * @pre The given minutes have to be between 0 and 59
	 *     | 0 <= minutes && minutes <= 59
	 * 
	 * Defensief:
	 * @throws IllegalArgumentException if the hours are not between 0 and 23
	 *     | hours < 0 || 23 < hours
	 * @throws IllegalArgumentException if the minutes are not between 0 and 59
	 *     | minutes < 0 || 59 < minutes
	 * 
	 * @post This object's hours equal the given hours.
	 *     | getHours() == hours
	 * @post This object's minutes equal the given minutes.
	 *     | getMinutes() == minutes
	 */
	public TimeOfDay(int hours, int minutes) {
		// Defensief programmeren
		if (hours < 0 || 23 < hours)
			throw new IllegalArgumentException("Bad hours");
		if (minutes < 0 || 59 < minutes)
			throw new IllegalArgumentException("Bad minutes");
		
		minutesSinceMidnight = hours * 60 + minutes;
	}
	
	/**
	 * Sets this object's hours.
	 * 
	 * Contractueel:
	 * @pre The given hours are between 0 and 23
	 *     | 0 <= hours && hours <= 23
	 *     
	 * Defensief:
	 * @throws IllegalArgumentException if the given hours are not between 0 and 23
	 *     | hours < 0 || 23 < hours  
	 * 
	 * @post This object's hours equal the given hours
	 *     | getHours() == hours
	 * @post This object's minutes are unchanged
	 *     | getMinutes() == old(getMinutes())
	 */
	public void setHours(int hours) {
		// Defensief:
		if (hours < 0 || 23 < hours)
			throw new IllegalArgumentException("Bad hours");
		
		minutesSinceMidnight = hours * 60 + minutesSinceMidnight % 60;
	}
	
	/**
	 * Sets this object's minutes.
	 * 
	 * @throws IllegalArgumentException if the given minutes are not between 0 and 59
	 *     | minutes < 0 || 59 < minutes
	 * 
	 * @post This object's hours are unchanged
	 *     | getHours() == old(getHours())
	 * @post This object's minutes equal the given minutes
	 *     | getMinutes() == minutes
	 */
	public void setMinutes(int minutes) {
		if (minutes < 0 || 59 < minutes)
			throw new IllegalArgumentException("Bad minutes");
		
		minutesSinceMidnight = minutesSinceMidnight / 60 * 60 + minutes;
	}
}
