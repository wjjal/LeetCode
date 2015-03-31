//There are N gas stations along a circular route, 
//where the amount of gas at station i is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas 
//to travel from station i to its next station (i+1). 
//You begin the journey with an empty tank at one of the gas stations.
//
//Return the starting gas station's index if you can travel around the circuit once, 
//otherwise return -1.
//
//Note:
//The solution is guaranteed to be unique.

public class L134GasStation {
	public class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			int curSum = 0; // ���ڼ�¼��ǰgasʣ����
			int total = 0; // ��¼����һȦ��gasʣ����
			int startIndex = 0; // ��¼������һȦ�Ŀ�ʼλ��
			for (int i = 0; i < gas.length; i++) {
				int curRemain = gas[i] - cost[i];
				if (curSum >= 0) { // �����ǰ����ʣ����������
					curSum += curRemain;
				} else { // ���򣬴��������¿�ʼ
					curSum = curRemain;
					startIndex = i;
				}
				total += curRemain;
			}
			return total >= 0 ? startIndex : -1;
		}
	}
}
