package readablecode.week3;

import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;

public class MarkdownTableUtils {
	// TODO3 : find the code to be replace with the method used at TODO7
	// refer OAOO principal

	// TODO4 : extract method and remove the comment if the comment is unnecessary,
	// 11.4, 5.1

	// TODO5 : refactor the extracted method by removing StringBuilder Argument and
	// return String
	// https://cyzennt.co.jp/blog/2021/05/19/java%EF%BC%9A%E5%BC%95%E6%95%B0%E3%81%A7%E6%B8%A1%E3%81%97%E3%81%9F%E5%8F%82%E7%85%A7%E5%9E%8B%E5%A4%89%E6%95%B0%E3%82%92%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E5%86%85%E3%81%A7%E5%A4%89%E6%9B%B4/

	// TODO1 add @throws in javadoc
	// e.g @throws xxxException if xxx is null or is less than XXX
	/**
	 * Returns the string of table which has empty rows as Markdown table syntax.
	 * length of captions for separator cell and empty cell is same with their
	 * header captions
	 *
	 *
	 * @param headerRowCaptions the captions for header row
	 * @param emptyRowCount     the number of empty rows.
	 * @return the string of table which has empty rows as Markdown table
	 *
	 *
	 */
	public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount) {
		Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
		if (headerRowCaptions.isEmpty()) {
			throw new IllegalArgumentException("headerCaptions must have one more elements");
		}
		if (emptyRowCount < 1) {
			throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
		}

		return createHeader(headerRowCaptions) + createEmptyRows(headerRowCaptions, emptyRowCount);

	}

	public static String createHeader(List<String> headerRowCaptions) {
		StringBuilder markdownTable = new StringBuilder();
		// create line for header row captions
		for (String e : headerRowCaptions) {
			markdownTable.append("|");
			markdownTable.append(e);
		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());

		// create line for header row separator
		for (String e : headerRowCaptions) {
			markdownTable.append("|");

			// TODO2 : use com.google.common.base.Strings to replace the followings:13.4
			// target code to replace with Strings begin
			markdownTable.append(Strings.repeat("-", e.length()));
			// target code to replace with guava end
			// how to find suitable method in framework
			// 1.open {@link com.google.common.base.Strings} and check outline (control + o)
			// and read javadoc
			// 2.check junit TestCase on github

		}
		markdownTable.append("|");
		markdownTable.append(System.lineSeparator());
		return markdownTable.toString();
	}

	public static String createEmptyRows(List<String> headerRowCaptions, int emptyRowCount) {
		StringBuilder markdownTable = new StringBuilder();
		// create lines for empty rows
		for (int i = 0; i < emptyRowCount; i++) {
			for (String e : headerRowCaptions) {
				markdownTable.append("|");
				for (int j = 0; j < e.length(); j++) {
					markdownTable.append(" ");
				}
			}
			markdownTable.append("|");
			markdownTable.append(System.lineSeparator());
		}
		return markdownTable.toString();
	}

}
