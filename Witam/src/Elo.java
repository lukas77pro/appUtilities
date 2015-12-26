import java.util.Calendar;
import java.util.GregorianCalendar;

public class Elo {
	public static void main(String[] args) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);

		int monthDays = getDaysOfMonth(calendar);
		int prevMonthDays = getDaysOfPreviousMonth(calendar);
		int firstDay = getFirstDayOfMouth(calendar);
		
		for (int i=0; i<6; i++) {
			for (int j=0; j<7; j++) {
				int dayNumber = i*7 + j;
				if (dayNumber - firstDay >= monthDays) {
					System.out.format("%2d ", dayNumber - monthDays - firstDay + 1);
					//enabled = false
				} else if (j >= firstDay || dayNumber >= 7) {				
					System.out.format("%2d ", dayNumber - firstDay + 1);
				} else {
					System.out.format("%2d ", prevMonthDays - firstDay + j + 1);
					//enabled = false
				}
			}		
			System.out.println();
		}

	}

	private static int getFirstDayOfMouth(Calendar calendar) {
		Calendar newCalendar = (Calendar) calendar.clone();
		newCalendar.set(Calendar.DAY_OF_MONTH, 1);
		int day = newCalendar.get(Calendar.DAY_OF_WEEK) - 2;
		if (day < 0) {
			day = day + 7;
		}
		return day;
	}

	private static int getDaysOfPreviousMonth(Calendar calendar) {
		Calendar newCalendar = (Calendar) calendar.clone();
		int month = calendar.get(Calendar.MONTH) - 1;
		if (month < 0) {
			month = 11;
			int year = calendar.get(Calendar.YEAR) - 1;
			newCalendar.set(Calendar.YEAR, year);
		}
		newCalendar.set(Calendar.MONTH, month);

		System.out.println(calendar.getTime());
		System.out.println(newCalendar.getTime());

		return getDaysOfMonth(newCalendar);
	}

	private static int getDaysOfMonth(Calendar calendar) {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
