package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class BarChart2 {

    private ArrayList<Bar> bars = new ArrayList<Bar>();
    private double highest;

    public BarChart2(double highest) {
        this.highest = highest;
    }

    public void add(Bar bar) {
        bars.add(bar);
    }

    public void draw(GraphicsContext gc, int xPos) {
        for (int i = 0; i < bars.size(); i++) {
            Rectangle rect = new Rectangle();
            rect.setX(xPos);
            xPos += 30;
            rect.setY(150);
            rect.setHeight((bars.get(i).barData / highest) * 400);
            System.out.println(highest + "\tData:" + bars.get(i).barData);
            rect.setWidth(10);
            rect.setFill(bars.get(i).color);
            gc.setFill(bars.get(i).color);
            gc.fillRect(xPos, 150, 10, (bars.get(i).barData / highest) * 500);
        }
    }

}
