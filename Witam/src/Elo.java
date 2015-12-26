import java.util.Calendar;
import java.util.GregorianCalendar;

public class Elo {
	public static void main(String[] args) {
		Calendar calendar = GregorianCalendar.getInstance();

		for (int i = 0; i < 4; i++) {
			System.out.println(getDaysOfPreviousMonth(calendar));
			System.out.println(getDaysOfMonth(calendar));
			System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
			calendar.set(Calendar.DAY_OF_MONTH, 
					calendar.get(Calendar.DAY_OF_MONTH) + 1);
			System.out.println();
		}

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
