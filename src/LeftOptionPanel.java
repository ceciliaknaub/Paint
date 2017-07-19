
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class LeftOptionPanel extends JPanel {
    private JButton blueButton;
    private JButton redButton;
    private JButton greenButton;
    private JButton eraserButton;
    private JSlider thicknessSlider;
    private Color currColor;
    private int thickness;
    
    public LeftOptionPanel(){
        GridLayout grid = new GridLayout(5, 1);
        setLayout(grid);
        
        currColor = Color.BLUE;
        thickness = 4;
        
        blueButton = new JButton("Blue");
        add(blueButton);
        
        redButton = new JButton("Red");
        add(redButton);
        
        greenButton = new JButton("Green");
        add(greenButton);
        
        eraserButton = new JButton("Eraser");
        add(eraserButton);
        
        thicknessSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, thickness);
        thicknessSlider.setMajorTickSpacing(1);
        thicknessSlider.setPaintTicks(true);
        thicknessSlider.setPaintLabels(true);
        add(thicknessSlider);

    }

    public JButton getBlueButton() {
        return blueButton;
    }

    public JButton getRedButton() {
        return redButton;
    }

    public JButton getGreenButton() {
        return greenButton;
    }
    
    public Color getCurrColor(){
        return currColor;
    }
    
    public void setCurrColor(Color newColor){
        currColor = newColor;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
    
    public JButton getEraserButton() {
        return eraserButton;
    }

    public JSlider getThicknessSlider() {
        return thicknessSlider;
    }
}
