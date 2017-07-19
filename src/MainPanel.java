
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MainPanel extends JPanel implements MouseMotionListener, ActionListener, ChangeListener{
    LeftOptionPanel leftOptionPanel;
    ArrayList<Integer> xValues;
    ArrayList<Integer> yValues;
    ArrayList<Color> color;
    ArrayList<Integer> thickness;
    
    MainPanel() {
        leftOptionPanel = new LeftOptionPanel();
        xValues = new ArrayList<Integer>();
        yValues = new ArrayList<Integer>();
        color = new ArrayList<Color>();
        thickness = new ArrayList<Integer>();
       
        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(leftOptionPanel, BorderLayout.WEST);
        
        addMouseMotionListener(this);
        leftOptionPanel.getBlueButton().addActionListener(this);
        leftOptionPanel.getRedButton().addActionListener(this);
        leftOptionPanel.getGreenButton().addActionListener(this);
        leftOptionPanel.getEraserButton().addActionListener(this);
        leftOptionPanel.getThicknessSlider().addChangeListener(this);
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(leftOptionPanel.getCurrColor());
        g.fillOval(e.getX(), e.getY(), leftOptionPanel.getThickness(), leftOptionPanel.getThickness());
        xValues.add(e.getX());
        yValues.add(e.getY());
        color.add(leftOptionPanel.getCurrColor());
        thickness.add(leftOptionPanel.getThickness());
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        for (int i = 0; i < xValues.size(); i++){
            g.setColor(color.get(i));
            g.fillOval(xValues.get(i), yValues.get(i), thickness.get(i), thickness.get(i));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Graphics g = getGraphics();
       JButton getSource = (JButton) e.getSource();
        if (getSource == leftOptionPanel.getBlueButton()){
            leftOptionPanel.setCurrColor(Color.BLUE);
            g.setColor(leftOptionPanel.getCurrColor());
        }
        if (getSource == leftOptionPanel.getRedButton()){
           leftOptionPanel.setCurrColor(Color.RED);
           g.setColor(leftOptionPanel.getCurrColor());
        }
        if (getSource == leftOptionPanel.getGreenButton()){
            leftOptionPanel.setCurrColor(Color.GREEN);
            g.setColor(leftOptionPanel.getCurrColor());
        }
        if (getSource == leftOptionPanel.getEraserButton()){
            leftOptionPanel.setCurrColor(getBackground());
            g.setColor(getBackground());
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider eventSource = (JSlider) e.getSource();
        leftOptionPanel.setThickness(eventSource.getValue());
    }
   

    
}
