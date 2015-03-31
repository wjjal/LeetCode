import java.util.LinkedList;

//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"

public class L071SimplifyPath {
	public class Solution {
		public String simplifyPath(String path) {
			if (path.length() == 0) {
				return path;
			}
			String[] splits = path.split("/");
			LinkedList<String> stack = new LinkedList<String>();
			for (String s : splits) {
				if (s.length() == 0 || s.equals("."))
					continue;
				else if (s.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else
					stack.push(s);
			}
			if (stack.isEmpty())
				return "/";
			else {
				String re = "";
				while (!stack.isEmpty()) {
					re += "/" + stack.removeLast();
				}
				return re;
			}
		}
	}
}
