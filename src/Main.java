import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        final int FRAME_SIZE = 600;
        final int MAT_SIZE = 10;
        LifeMatrix newLifeMat = new LifeMatrix(MAT_SIZE);
        JFrame frame = new JFrame("Game of life");
        frame.setSize(FRAME_SIZE, FRAME_SIZE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LifeMatrixPanel panel = new LifeMatrixPanel(newLifeMat);
        frame.add(panel);
        frame.setVisible(true);
        //dialog window, creates new generation till "no" or "cancel" pressed
        while(JOptionPane.showConfirmDialog(null,"Do you want to continue?") == 0){
            panel.nextGeneration();
            panel.repaint();
        }
    }
}
