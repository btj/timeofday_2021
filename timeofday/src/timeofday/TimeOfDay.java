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
	 * @invar The hours are between zero and 23
	 *     | 0 <= hours && hours <= 23
	 * @invar The minutes are between zero and 59
	 *     | 0 <= minutes && minutes <= 59
	 */
	private int hours;
	private int minutes;
	
	/**
	 * @basic
	 */
	public int getHours() { 
		return hours;
	}

	/**
	 * @basic
	 */
	public int getMinutes() {
		return minutes;
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
		
		this.hours = hours;
		this.minutes = minutes;
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
		
		this.hours = hours;
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
		
		this.minutes = minutes;
	}
}
