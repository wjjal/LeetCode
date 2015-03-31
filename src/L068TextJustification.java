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

//��������һ����Ҫע�������㣬a��������ֻ��һ������ʱ���ո�ȫ�����ұ� b�����һ���е��ʼ�ֻ��һ���ո�����ո�ȫ�����ұߡ�
//Ȼ��ֻҪ̰��ѡ����һ���о����Ŷ�ĵ��ʡ�

public class L068TextJustification {
	public class Solution {
		public ArrayList<String> fullJustify(String[] words, int L) {
			ArrayList<String> ret = new ArrayList<String>();
			int wordsLen = words.length; // ��������ĳ���
			int curWordIdx = 0; // �����i������
			while (curWordIdx < wordsLen) { // ���������е��ʺ��˳�
				int charLen = 0; // ��ǰ���ۻ����ַ�����
				int probeWordIdx = curWordIdx;
				while (probeWordIdx < wordsLen
						&& charLen + words[probeWordIdx].length() <= L) { // ̰�����뾡���ܶ�ĵ���
					charLen += ((words[probeWordIdx++]).length() + 1); // �ۻ����ʳ��Ⱥ�����Ҫ��һ���ո�
				}
				if (probeWordIdx - curWordIdx == 1) { // tmpWordIdx-curWordIdx:
														// ���з��뵥�ʵ���Ŀ�����ֻ��һ������Ҫ���⴦��
					String tmp = words[curWordIdx]; // Ψһ���Ǹ�����
					tmp = addSpace(tmp, L - words[curWordIdx].length()); // �Ǹ����ʺ��涼���Ͽո�
					ret.add(tmp);
					curWordIdx = probeWordIdx; // ����curWordIdx����Ϊ�Ѿ�����õ�ǰ����
					continue;
				}

				// tmpWordIdx-curWordIdx: ���з��뵥�ʵ���Ŀ��Ҳ���ǽ��ӵĿո����������Ϊÿ�����ʺ��һ���ո�
				// wordCharLen����ǰ�������ɵ�����ɵ��ַ��������������ո�
				int wordCharLen = charLen - (probeWordIdx - curWordIdx);
				// meanSpace: ƽ��ÿ�����ʺ�Ŀո�,probeWordIdx<wordsLen ��ʾ�������һ��
				int meanSpace = probeWordIdx < wordsLen ? (L - wordCharLen)
						/ (probeWordIdx - curWordIdx - 1) : 1;
				// leftSpace: ����Ŀո�
				int leftSpace = probeWordIdx < wordsLen ? (L - wordCharLen)
						% (probeWordIdx - curWordIdx - 1) : L - wordCharLen
						- (probeWordIdx - curWordIdx - 1);
				String tmp = new String();
				for (int k = curWordIdx; k < probeWordIdx - 1; k++) { // �Ե�ǰ�����һ���������⴦��
					tmp += words[k];
					tmp = addSpace(tmp, meanSpace);
					if (probeWordIdx < wordsLen && leftSpace > 0) { // ��Ϊ���ж���
						tmp += " ";
						leftSpace--;
					}
				}
				tmp += words[probeWordIdx - 1]; // ����ǰ�е����һ������
				if (leftSpace > 0) { // ��Ϊ����룬�����������ʣ�µĿո�
					tmp = addSpace(tmp, leftSpace);
				}
				ret.add(tmp);
				curWordIdx = probeWordIdx; // ������һ�е�Ҫ����ĵ���
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
