public class x2_Max_area_island {
 public static void main(String[] args) {
  int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
    { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

  System.out.println(maxAreaOfIsland(grid));
 }

 public static int maxAreaOfIsland(int[][] grid) {
  int res = 0;

  int ROW = grid.length;
  int COLUMN = grid[0].length;

  boolean[][] visited = new boolean[ROW][COLUMN];

  for (int i = 0; i < ROW; i++) {
   for (int j = 0; j < COLUMN; j++) {
    res = Math.max(res, DFS(grid, i, j, visited, ROW, COLUMN));
   }
  }
  return res;
 }

 private static int DFS(int[][] grid, int i, int j, boolean[][] visited, int ROW, int COLUMN) {

  if (i < 0 || i >= ROW || j < 0 || j >= COLUMN || visited[i][j] == true || grid[i][j] == 0) {
   return 0;
  }

  visited[i][j] = true;

  return (1 + DFS(grid, i + 1, j, visited, ROW, COLUMN) + DFS(grid, i - 1, j, visited, ROW, COLUMN)
    + DFS(grid, i, j - 1, visited, ROW, COLUMN) + DFS(grid, i, j + 1, visited, ROW, COLUMN));
 }
}
