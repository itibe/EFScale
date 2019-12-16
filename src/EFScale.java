
public class EFScale {
	// Ian Tibe
	// Data fields
	private int windSpeed;
	
	//constants to define wind speed ranges
	private final int WINDSPEED_RANGE_1_LOW = 200;
	private final int EF_RATING_RANGE_1 = 5;
	private final int WINDSPEED_RANGE_2_LOW = 166;
	private final int WINDSPEED_RANGE_2_HIGH = 200;
	private final int EF_RATING_RANGE_2 = 4;
	private final int WINDSPEED_RANGE_3_LOW = 136;
	private final int WINDSPEED_RANGE_3_HIGH = 165;
	private final int EF_RATING_RANGE_3 = 3;
	private final int WINDSPEED_RANGE_4_LOW = 111;
	private final int WINDSPEED_RANGE_4_HIGH = 135;
	private final int EF_RATING_RANGE_4 = 2;
	private final int WINDSPEED_RANGE_5_LOW = 86;
	private final int WINDSPEED_RANGE_5_HIGH = 110;
	private final int EF_RATING_RANGE_5 = 1;
	private final int WINDSPEED_RANGE_6_LOW = 65;
	private final int WINDSPEED_RANGE_6_HIGH = 85;
	private final int EF_RATING_RANGE_6 = 0;

	// constructor
	EFScale() {

	}

	// getters and setters

	public void setWindSpeed(int windSpeed) {
		if (windSpeed < 65) {
			throw new IllegalArgumentException("Please enter A wind speed 65 or above");
		}

		this.windSpeed = windSpeed;
	}

	public int getWINDSPEED_RANGE_6_LOW() {
		return WINDSPEED_RANGE_6_LOW;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	// helper method
	public int getEFScale() {
		int scale = 0;

		if (windSpeed > WINDSPEED_RANGE_1_LOW) {
			scale = EF_RATING_RANGE_1;
		} else if (windSpeed >= WINDSPEED_RANGE_2_LOW && windSpeed <= WINDSPEED_RANGE_2_HIGH) {
			scale = EF_RATING_RANGE_2;
		} else if (windSpeed >= WINDSPEED_RANGE_3_LOW && windSpeed <= WINDSPEED_RANGE_3_HIGH) {
			scale = EF_RATING_RANGE_3;
		} else if (windSpeed >= WINDSPEED_RANGE_4_LOW && windSpeed <= WINDSPEED_RANGE_4_HIGH) {
			scale = EF_RATING_RANGE_4;
		} else if (windSpeed >= WINDSPEED_RANGE_5_LOW && windSpeed <= WINDSPEED_RANGE_5_HIGH) {
			scale = EF_RATING_RANGE_5;
		} else if (windSpeed >= WINDSPEED_RANGE_6_LOW && windSpeed <= WINDSPEED_RANGE_6_HIGH) {
			scale = EF_RATING_RANGE_6;
		}

		return scale;

	}

}
