abstract class Shape {
	abstract double area();
}

class Circle extends Shape {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double area() {
		return Math.PI * radius * radius;
	}
}

class Rectangle extends Shape {
	double length, width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	double area() {
		return length * width;
	}
}

class Triangle extends Shape {
	double base, height;

	Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	double area() {
		return 0.5 * base * height;
	}
}

public class ShapeDemo {
	public static void main(String[] args) {
		Shape[] shapes = {
				new Circle(2),
				new Rectangle(4, 5),
				new Triangle(6, 3)
		};

		double total = 0;

		double largest = 0;

		for (Shape shape : shapes) {
			double a = shape.area();
			System.out.printf("%s area: %.2f%n", shape.getClass().getSimpleName(), a);

			total += a;

			if (a > largest) {
				largest = a;
			}

			System.out.printf("Running total: %.2f%n", total);
		}
		System.out.printf("Total area: %.2f%n", total);
		System.out.printf("Largest area: %.2f%n", largest);
	}
}
