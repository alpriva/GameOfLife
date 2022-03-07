import javax.swing.*;
import java.awt.*;

/**
 * Class represents GUI of game of life
 */
public class LifeMatrixPanel extends JPanel {
    private LifeMatrix lifeMatrix;

    /**
     * Constructor
     * @param newMat - LifeMatrix
     */
    public LifeMatrixPanel(LifeMatrix newMat){
        lifeMatrix = newMat;
    }

    /**
     * Method creates next generation
     */
    public void nextGeneration(){
        lifeMatrix.createNextGen();
    }

    /**
     *
     * @param g - Graphics
     */
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int matSize = lifeMatrix.getMatSize();
        int x = 0;
        int y = 0;
        int recSize = width/matSize;
        for(int i = 0; i < matSize; i++){
            for (int j = 0; j < matSize; j++){
                if(lifeMatrix.getCurRecValue(i,j)){
                    g.fillRect(x, y, recSize, recSize);
                }
                else
                {
                    g.drawRect(x, y, recSize, recSize);
                }
                x += recSize;
            }
            y += recSize;
            x = 0;
        }
    }
}

