abstract class Media {
	String title;
	int lateDays;

	Media(String title, int lateDays) {
		this.title = title;
		this.lateDays = lateDays;
	}

	abstract double lateFee();
}

class Book extends Media {
	Book(String title, int lateDays) {
		super(title, lateDays);
	}

	double lateFee() {
		return lateDays * 2.0;
	}
}

class DVD extends Media {
	DVD(String title, int lateDays) {
		super(title, lateDays);
	}

	double lateFee() {
		return lateDays * 5.0;
	}
}

class Magazine extends Media {
	Magazine(String title, int lateDays) {
		super(title, lateDays);
	}

	double lateFee() {
		return lateDays * 1.0;
	}
}

public class MediaDemo {
	public static void main(String[] args) {
		Media[] items = {
				new Book("Java Book", 3), new DVD("Movie DVD", 2),
				new Magazine("Tech Magazine", 4)
		};

		double total = 0;

		for (Media item : items) {
			double fee = item.lateFee();
			System.out.println(item.title + ": Rs. " + fee);
			total += fee;
		}

		System.out.println("Total late fee: Rs. " + total);
	}
}
