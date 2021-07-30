/*
=======================================================================
PROBLEM:)
=======================================================================
Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
*/

/*
=====================================================================
APPROACH:)
======================================================================
We call DFS for elements in the matrix that are both unvisited and = 1
for each of these elements, we check if call DFS in the 8 directions from the current element (if a valid move). This is to cover one piece of land
when one piece of land is covered, we return to CountIslands and iterate through the rest of the matrix to get another piece of land (if present)

Time: O(n*m)
Space: O(n*m)
*/
public class p4_count_islands_dfs {
 public static void main(String[] args) {
  int mat[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
  System.out.println(CountIslands(mat));
 }

 public static int CountIslands(int[][] grid) {
  int res = 0;

  int ROW = grid.length;
  int COLUMN = grid[0].length;

  boolean[][] visited = new boolean[ROW][COLUMN];

  for (int i = 0; i < ROW; i++) {
   for (int j = 0; j < COLUMN; j++) {
    if (grid[i][j] == 1 && !visited[i][j]) {
     DFS(grid, i, j, visited, ROW, COLUMN);
     res++;
    }
   }
  }
  return res;
 }

 // worst case, the call is made for all the elements in the matrix => O(n*m)
 // time and stack space(for recursion stack)
 public static void DFS(int[][] M, int row, int col, boolean[][] visited, int ROW, int COLUMN) {
  int dx[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
  int dy[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

  visited[row][col] = true;

  for (int k = 0; k < 8; k++) {
   if (isSafe(M, row + dx[k], col + dy[k], visited, ROW, COLUMN)) {
    DFS(M, row + dx[k], col + dy[k], visited, ROW, COLUMN);
   }
  }
 }

 private static boolean isSafe(int[][] M, int row, int col, boolean[][] visited, int ROW, int COLUMN) {
  return (row >= 0) && (row < ROW) && (col >= 0) && (col < COLUMN) && (M[row][col] == 1 && !visited[row][col]);
 }
}
