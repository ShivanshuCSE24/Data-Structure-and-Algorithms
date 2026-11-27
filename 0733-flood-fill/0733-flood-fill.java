class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int st = image[sr][sc];
        if (st != color) {
            dfs(image, sr, sc, st, color);
        }
        return image;

    }
    public void dfs(int[][] image, int x, int y, int startColor, int color) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != startColor) {
            return;
        }

        image[x][y] = color;

        dfs(image, x - 1, y, startColor, color);
        dfs(image, x + 1, y, startColor, color);
        dfs(image, x, y - 1, startColor, color);
        dfs(image, x, y + 1, startColor, color);
    }
}