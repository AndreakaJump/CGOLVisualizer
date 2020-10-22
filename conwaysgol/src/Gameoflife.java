
import processing.core.PApplet;

public class Gameoflife extends PApplet {
	int arrLength = 25;
	int arrWidth = 25;
	int[][] arr = new int[arrLength][arrWidth];
	int mouseXpos;
	int mouseYpos;
	int a = 1;
	int size = 500;
	int divisor = size / arrLength;

	public static void main(String[] args) {
		PApplet.main("Gameoflife");
	}

	public void settings() {
		size(size, size);
		for (int k = 0; k < arrLength; k++) {
			for (int j = 0; j < arrWidth; j++) {
				// arr[k][j]=(int)(Math.random()+.6);
				arr[k][j] = 0;
			}
		}

	}

	public void draw() {
		background(0);
		display();

	}

	public void display() {
		int[][] otherArr = new int[arrLength][arrWidth];
		int x = 0;
		while (x < arrLength) {
			int y = 0;
			while (y < arrWidth) {
				if (arr[x][y] == 0) {
					fill(60);
					rect((x * divisor), (y * divisor), divisor, divisor);
				} else {
					fill(0);
					rect((x * divisor), (y * divisor), divisor, divisor);
				}
				y++;
			}
			x++;
		}
		for (int k = 0; k < arrLength; k++) {
			for (int j = 0; j < arrWidth; j++) {
				int sum = 0;
				sum = findSum(k, j);
				otherArr = rule1(k, j, sum, otherArr);
			}
		}
		arr = otherArr;

	}

	private int[][] rule1(int k, int j, int sum, int[][] otherArr) {
		// TODO Auto-generated method stub
		if (arr[k][j] == 0 && (sum == 3)) {
			otherArr[k][j] = 1;
		}
		if (arr[k][j] == 1 && (sum == 2 || sum == 3)) {
			otherArr[k][j] = 1;
		}
		return otherArr;

	}

	private int[][] rule2(int k, int j, int sum, int[][] otherArr) {
		if (arr[k][j] == 0 && (sum == 2)) {
			otherArr[k][j] = 1;
		}
		if (arr[k][j] == 1 && (sum < 4 && sum > 0)) {
			otherArr[k][j] = 1;
		}
		return otherArr;
	}

	private int findSum(int k, int j) {
		int sum = 0;

		for (int x = k - 1; x <= k + 1; x++) {
			for (int y = j - 1; y <= j + 1; y++) {
				if (x >= 0 && y >= 0 && x < arrLength && y < arrWidth) {
					if (arr[x][y] == 1) {
						sum++;
					}
				}
			}
		}
		sum -= arr[k][j];
		return sum;
	}

	public void mouseDragged() {
		if (mouseX > 0 && mouseX < size && mouseY > 0 && mouseY < size) {
			arr[(mouseX / divisor)][(mouseY / divisor)] = 1;
		}

	}
}
