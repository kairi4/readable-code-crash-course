package readablecode.week2;

import java.util.List;

public class MarkdownUtils {
	// TODO1 : use early return:Readable code 7.5, 7.7 and remove the 1 nest(you
	// might need to change if condition and if condition is complicated such as
	// if(!(...)) please refactor it after you read 7.2)
	// * you do not need to improve exception handling

	// TODO2 : add line break and comment for each block/paragraph after you read
	// Readable code 4.7

	// TODO3 : re-name the variables after you read Readable code 2.2 2.7, 3.8

	// TODO4 : re-name method as it is after you read Readable code 3.0, 3.9

	// TODO5 : remove the unnecessary variable after you read Readable code 9.1

	public static String createTables(List<String> list, int count) throws IllegalArgumentException {
		if (list == null || list.isEmpty() || count <= 0) {
			throw new IllegalArgumentException("");
		}

		//ヘッダを作成
		StringBuilder table = new StringBuilder();
		for (String e : list) {
			table.append("|");
			table.append(e);
		}
		table.append("|");
		table.append(System.lineSeparator());

		//ヘッダとデータを分ける
		for (String e : list) {
			table.append("|");
			for (int i = 0; i < e.length(); i++) {
				table.append("-");
			}
		}
		table.append("|");
		table.append(System.lineSeparator());

		//空のデータを作成
		for (int i = 0; i < count; i++) {
			for (String e : list) {
				table.append("|");
				for (int j = 0; j < e.length(); j++) {
					table.append(" ");
				}
			}
			table.append("|");
			table.append(System.lineSeparator());
		}
		return table.toString();
	}

}
