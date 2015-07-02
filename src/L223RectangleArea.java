import java.util.Arrays;

public class L223RectangleArea {
	public static void main(String[] args){
		System.out.println(new L223RectangleArea().computeArea(-2, -2, 2, 2, -3, 3, -4, 4));
	}
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int area = Math.abs(C - A) * Math.abs(D - B) + Math.abs(G - E) * Math.abs(H - F);
		if (G <= A || H <= B || C <= E || D <= B)
			return area;
		int x[] = { A, C, E, G };
		int y[] = { B, D, F, H };
		return area - diff(x) * diff(y);
	}

	private int diff(int[] x) {
		Arrays.sort(x);
		return x[2] - x[1];
	}
}
