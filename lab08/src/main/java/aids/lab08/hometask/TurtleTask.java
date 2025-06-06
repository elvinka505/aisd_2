package aids.lab08.hometask;

public class TurtleTask {
    public static int calculateMinPathCost(int[][] priceGrid) {
        if (priceGrid == null || priceGrid.length == 0 || priceGrid[0].length == 0) {
            return 0;
        }

        int rowsCount = priceGrid.length;
        int colsCount = priceGrid[0].length;

        //xранениe мин стоимости пути до каждой клетки
        int[][] minCostMatrix = new int[rowsCount][colsCount];

        //(0,0)
        minCostMatrix[0][0] = priceGrid[0][0];

        //заполняем первую строку (только вправо)
        for (int col = 1; col < colsCount; col++) {
            minCostMatrix[0][col] = minCostMatrix[0][col - 1] + priceGrid[0][col];
        }

        //заполняем первый столбец (только вниз)
        for (int row = 1; row < rowsCount; row++) {
            minCostMatrix[row][0] = minCostMatrix[row - 1][0] + priceGrid[row][0];
        }

        //заполняем остальные клетки
        for (int row = 1; row < rowsCount; row++) {
            for (int col = 1; col < colsCount; col++) {
                minCostMatrix[row][col] = Math.min(
                        minCostMatrix[row - 1][col],  //сверху
                        minCostMatrix[row][col - 1]   //слева
                ) + priceGrid[row][col];
            }
        }

        return minCostMatrix[rowsCount - 1][colsCount - 1];
    }

    public static void main(String[] args) {
        int[][] priceGrid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println("Минимальная стоимость пути: " + calculateMinPathCost(priceGrid));
    }
}
