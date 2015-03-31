import java.util.ArrayList;

//Given an array of words and a length L, format the text such that each line has 
//exactly L characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as 
//you can in each line. Pad extra spaces ' ' when necessary so that each line has 
//exactly L characters.
//
//Extra spaces between words should be distributed as evenly as possible. 
//If the number of spaces on a line do not divide evenly between words, 
//the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left justified and no extra space is 
//inserted between words.
//
//For example,
//words: ["This", "is", "an", "example", "of", "text", "justification."]
//L: 16.
//
//Return the formatted lines as:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//Note: Each word is guaranteed not to exceed L in length.

//分析：这一题需要注意两个点，a、当该行只放一个单词时，空格全部在右边 b、最后一行中单词间只有一个空格，其余空格全部在右边。
//然后只要贪心选择，在一行中尽量放多的单词。

public class L068TextJustification {
	public class Solution {
		public ArrayList<String> fullJustify(String[] words, int L) {
			ArrayList<String> ret = new ArrayList<String>();
			int wordsLen = words.length; // 单词数组的长度
			int curWordIdx = 0; // 处理第i个单词
			while (curWordIdx < wordsLen) { // 处理完所有单词后退出
				int charLen = 0; // 当前行累积的字符数量
				int probeWordIdx = curWordIdx;
				while (probeWordIdx < wordsLen
						&& charLen + words[probeWordIdx].length() <= L) { // 贪婪加入尽可能多的单词
					charLen += ((words[probeWordIdx++]).length() + 1); // 累积单词长度和至少要有一个空格
				}
				if (probeWordIdx - curWordIdx == 1) { // tmpWordIdx-curWordIdx:
														// 该行放入单词的数目，如果只有一个单词要特殊处理
					String tmp = words[curWordIdx]; // 唯一的那个单词
					tmp = addSpace(tmp, L - words[curWordIdx].length()); // 那个单词后面都接上空格
					ret.add(tmp);
					curWordIdx = probeWordIdx; // 更新curWordIdx，因为已经处理好当前行了
					continue;
				}

				// tmpWordIdx-curWordIdx: 该行放入单词的数目，也就是紧接的空格的数量（因为每个单词后接一个空格）
				// wordCharLen：当前行所有由单词组成的字符数量（不包括空格）
				int wordCharLen = charLen - (probeWordIdx - curWordIdx);
				// meanSpace: 平均每个单词后的空格,probeWordIdx<wordsLen 表示不是最后一行
				int meanSpace = probeWordIdx < wordsLen ? (L - wordCharLen)
						/ (probeWordIdx - curWordIdx - 1) : 1;
				// leftSpace: 多余的空格
				int leftSpace = probeWordIdx < wordsLen ? (L - wordCharLen)
						% (probeWordIdx - curWordIdx - 1) : L - wordCharLen
						- (probeWordIdx - curWordIdx - 1);
				String tmp = new String();
				for (int k = curWordIdx; k < probeWordIdx - 1; k++) { // 对当前行最后一个单词特殊处理
					tmp += words[k];
					tmp = addSpace(tmp, meanSpace);
					if (probeWordIdx < wordsLen && leftSpace > 0) { // 因为居中对齐
						tmp += " ";
						leftSpace--;
					}
				}
				tmp += words[probeWordIdx - 1]; // 处理当前行的最后一个单词
				if (leftSpace > 0) { // 因为左对齐，所以在最后补上剩下的空格
					tmp = addSpace(tmp, leftSpace);
				}
				ret.add(tmp);
				curWordIdx = probeWordIdx; // 处理下一行的要处理的单词
			}
			return ret;
		}

		public String addSpace(String s, int count) {
			for (int i = 1; i <= count; i++) {
				s += " ";
			}
			return s;
		}
	}
}
