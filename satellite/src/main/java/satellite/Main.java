import java.util.Scanner;

public class Main {

    static int[][] readImage(Scanner input, int rows, int cols) {
        int[][] image = new int[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++) image[r][c] = input.nextInt();
        return image;
    }

    static int[] findRectangle(int[][] oldImage, int[][] newImage) {
    int r1 = oldImage.length, c1 = oldImage[0].length, r2 = -1, c2 = -1;
    for (int r = 0; r < oldImage.length; r++)
        for (int c = 0; c < oldImage[0].length; c++)
            if (oldImage[r][c] != newImage[r][c]) {
                r1 = Math.min(r1, r); c1 = Math.min(c1, c);
                r2 = Math.max(r2, r); c2 = Math.max(c2, c);
            }
    if (r2 == -1) return new int[]{0, 0, 0, 0};
    return new int[]{r1 + 1, c1 + 1, r2 + 1, c2 + 1};

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt(), cols = input.nextInt();
        int[][] oldImage = readImage(input, rows, cols);
        int[][] newImage = readImage(input, rows, cols);
        int[] result = findRectangle(oldImage, newImage);
        System.out.println(result[0] + " " + result[1] + " "
                + result[2] + " " + result[3]);
    }
}