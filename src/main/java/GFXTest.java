import processing.core.PApplet;
import javax.swing.*;
//import java.util.Scanner;

public class GFXTest extends PApplet{
    float theta = 0;       // Start angle at 0
    float amplitude = 100;  // Height of wave
    float period = 400;    // How many pixels before the wave repeats
    float dx;              // Value for incrementing X, a function of period and xspacing
    float[] yvalues;       // Using an array to store height values for the wave
    float s = 8;           // size
    int space = 8;
    int c = 0;
    int textCounter = 0;
    String str;

    public void settings(){
        size(1000,400);
        dx = (float) (Math.PI*2 / period)*space;
        yvalues = new float[width/space];
    }

    public void setup(){
        stroke(255,255,255);
        fill(255,255,255);
        frameRate(60);
        noStroke();
        colorMode(HSB);
        textSize(32);
        str = GUI.getStr();
    }

    public void draw() {
        background(0);
        waveCalc();
        waveDraw();
        textDraw();
        changeColor();
    }

    public void waveCalc(){
        theta += 0.02;
        float x = theta;
        for (int i = 0; i < yvalues.length; i++) {
            yvalues[i] = sin(x)*amplitude;
            x+=dx;
        }
    }

    public void waveDraw(){
        for (int x = 0; x < yvalues.length; x++){
            ellipse(x*space,(height/2+yvalues[x]),s,s);
        }
    }

    public void textDraw(){
        text(str,Oscillate(textCounter,10,750),350);
        //textSize(32+Oscillate(textCounter,1,80)*0.1f);
        textCounter+=3;
        if(textCounter>1480) textCounter=0;
    }

    public void changeColor(){
        if (c>=255) c=0; else c++;
        fill(c,255,255);
        s = 7f+Oscillate(c,1,40)*0.05f;

    }

    public static int Oscillate(int input, int min, int max)
    {
        int range = max - min ;
        return min + Math.abs(((input + range) % (range * 2)) - range);
    }
}
