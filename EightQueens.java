package Chapter07;

public class EightQueens {
	/**
	 *
	 * 		1. 八皇后问题描述
	 *		  在8×8格的国际象棋上摆放8个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，
	 *		  问有多少种摆法。高斯认为有76种方案。1854年在柏林的象棋杂志上不同的作者发表了40种不同的解，
	 *		  后来有人用图论的方法解出92种结果
	 *
	 /*
	  皇后数量
	 */
	public static void main(String[] args) {
		EightQueens eightQueens = new EightQueens();
		eightQueens.place(0);
		System.out.println("皇后摆放方式共有 " + eightQueens.getSolution() + " 种.");
	}
	private static final int QUEENS = 8;
	/**
	 * 存放皇后摆放位置，array[i] 含义：在第 i 行，皇后摆放在第 array[i] 个位置
	 */
	private final int[] array = new int[QUEENS];
	/**
	 * 皇后摆法
	 */
	private int solution;

	public int getSolution() {
		return solution;
	}

	/**
	 * 放置皇后
	 *
	 * @param queenNum 皇后编号
	 */
	public void place(int queenNum) {
		if (queenNum == QUEENS) {
			print();
			++solution;
			return;
		}

		// 依次放置皇后，同时判断布局是否冲突
		for (int i = 0; i < QUEENS; i++) {
			// 先将当前皇后放到该行的第 1 列，并判断是否冲突
			array[queenNum] = i;
			if (isConflict(queenNum)) {
				// 不冲突接着放置皇后
				place(queenNum + 1);
			}
			// 冲突则当前皇后后移一个位置
		}
	}

	/**
	 * 当摆放编号为第 queenNum 的皇后时，判断是否与棋盘上的皇后布局冲突
	 * 冲突条件：两两皇后之间不能位于同一行、同一列、同一斜线
	 *
	 * @param queenNum 皇后编号
	 * @return true - 冲突
	 */
	private boolean isConflict(int queenNum) {
		for (int i = 0; i < queenNum; i++) {
			// 判断两个皇后是否在同一列
			// 注：无需判断是否在同一行，因为 i 自增依次表示第 i + 1 行
			if (array[i] == array[queenNum]) {
				return false;
			}
			// 判断是否在同一斜线上
			if (Math.abs(queenNum - i) == Math.abs(array[queenNum] - array[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 输出皇后布局
	 */
	private void print() {
		for (int location : array) {
			System.out.print(location + " ");
		}
		System.out.println();
	}


}

