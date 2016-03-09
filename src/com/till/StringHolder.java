package com.till;

/**
 * This class was designed for problem in android application. During testing
 * sensors, device received a lot of updates, so string which held that
 * information was growing very quickly and produced problem with memory. Within
 * this class we have limited string lines. When new line is added at the
 * beginning, the line at the end is removed. So we always have fixed number of
 * lines. This should avoid unlimited growth of string holding our data.
 * 
 * @author Piotr Dros
 *
 */
public class StringHolder {

	private String[] lines;

	public StringHolder(int lines) {
		this.lines = new String[lines];
	}

	public void add(String line) {
		for (int i = lines.length - 1; i >= 1; i--) {
			lines[i] = lines[i - 1];
		}
		lines[0] = line;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
			sb.append(line);
		}
		return sb.toString();
	}

	/**
	 * For test only
	 * @param args
	 */
	public static void main(String[] args) {
		StringHolder sh = new StringHolder(3);
		for (int i = 0; i < 6; i++) {
			sh.add(i + "\n");
		}

		System.out.println(sh.toString());
	}

}
