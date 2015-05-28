import java.util.*;

public class L217ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> hash = new HashSet<Integer>();
		for (int i : nums) {
			if (hash.contains(i))
				return true;
			else
				hash.add(i);
		}
		return false;
	}
}
