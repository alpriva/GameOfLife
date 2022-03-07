import java.util.Random;

/**
 * Class represents matrix that represents game of life
 */
public class LifeMatrix {
    private boolean[][] currentMat;
    private boolean[][] nextMat;

    /**
     * constructor for class LifeMatrix
     * @param n - size of matrix as integer number
     */
    public LifeMatrix(int n) {
        currentMat = new boolean[n][n];
        Random random = new Random();
        //initialising current matrix with random boolean values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                currentMat[i][j] = random.nextBoolean();
            }
        }
        nextMat = new boolean[n][n];
    }

    /**
     * Method creates matrix that represents next generation
     */
    public void createNextGen() {
        for (int i = 0; i < currentMat.length; i++) {

            for (int j = 0; j < currentMat[i].length; j++) {

                nextMat[i][j] = isAliveNext(i, j);
            }
        }
        boolean[][] tmp = currentMat;
        currentMat = nextMat;
        nextMat = tmp;

    }

    /**
     *
     * @param i - index
     * @param j - index
     * @return value of given cell in matrix
     */
    public boolean getCurRecValue(int i, int j) {

        return currentMat[i][j];
    }

    /**
     * Method checks if given cell in current matrix will be alive in next generation
     * or not. Returns true if checked cell will be alive, false otherwise
     * @param i - index
     * @param j -idex
     * @return  next generation boolean value
     */
    private boolean isAliveNext(int i, int j) {

        int sum = 0;//summarize how much live neighbors
        int n = currentMat.length;
        if (!outOfLimits(i - 1, j - 1, n) && getCurRecValue(i - 1, j - 1))
            sum += 1;
        if (!outOfLimits(i - 1, j, n) && getCurRecValue(i - 1, j))
            sum += 1;
        if (!outOfLimits(i - 1, j + 1, n) && getCurRecValue(i - 1, j + 1))
            sum += 1;
        if (!outOfLimits(i, j - 1, n) && getCurRecValue(i, j - 1))
            sum += 1;
        if (!outOfLimits(i, j + 1, n) && getCurRecValue(i, j + 1))
            sum += 1;
        if (!outOfLimits(i + 1, j - 1, n) && getCurRecValue(i + 1, j - 1))
            sum += 1;
        if (!outOfLimits(i + 1, j, n) && getCurRecValue(i + 1, j))
            sum += 1;
        if (!outOfLimits(i + 1, j + 1, n) && getCurRecValue(i + 1, j + 1))
            sum += 1;

        if (!getCurRecValue(i, j) && sum == 3) {

            return true;
        } else if (getCurRecValue(i, j) && (sum == 0 || sum == 1 || sum > 3)) {

            return false;
        } else if (getCurRecValue(i, j) && (sum == 2 || sum == 3)) {

            return true;
        } else
            return false;
    }

    /**
     * Method checks if given indexes is out of limits
     * @param i - index
     * @param j - index
     * @param length - size of matrix
     * @return true if indexes out of matrix's limits, false otherwise
     */
    private boolean outOfLimits(int i, int j, int length) {
        if (i < 0 || i >= length || j < 0 || j >= length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method returns matrix's size
     * @return matrix's size as integer
     */
    public int getMatSize(){

        return currentMat.length;
    }

}
