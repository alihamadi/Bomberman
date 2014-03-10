/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.Scanner; 

/**
 *
 * @author abdullahadeeb
 */
public class MapModel {

	File mapFile = new File("C:\\Users\\ALI\\workspace\\Bomberman\\src\\map.txt");
	//private String line;
	
    MapView viewer;
    Entity mapGrid[][];
    boolean isExitSet = false;

    public MapModel(String mapFilePath) {
        if (mapFilePath == null) {
           generateRandomMap();
        } else {
        	System.out.println("this is the else");
            //loadMapFromFile(mapFilePath);
        }
        startMapView();
    }

    private void startMapView() {
        viewer = new MapView(this);
        viewer.setVisible(true);

    }

    private void loadMapFromFile(String mapFilePath) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(mapFilePath);
            NodeList childNodes = doc.getChildNodes();
            NodeList rows = childNodes.item(0).getChildNodes();
            for (int i = 0; i < rows.getLength(); i++) {
                System.out.println(rows.item(i));
            }

        } catch (SAXException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateRandomMap() {
        mapGrid = new Entity[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                int rand = (int) (Math.random() * 100);

                if (rand >= 50 && rand <= 100) {             //15% of map is walls
                	putPathIn(x, y);
                    putExitIn(x, y);  // only one door will be created at a path 
                } else if (rand >= 15 && rand < 50) {   // 20% of map is boxes
                    putBoxIn(x, y);
                } else if (rand < 15) {  // 50% of the map will be path
                	putWallIn(x, y); 
                } else {
                	System.out.println("wtf");
                    putPathIn(x, y);
                }
            }
        }


    }
    
    public void makeMap(File file) throws IOException {
    	System.out.println("the makeMap is being run");
    	int width, height; 
        
    	Scanner reader = new Scanner(new FileReader(file)); 
          
        	
          Scanner line = new Scanner(reader.nextLine());  
          
          width = line.nextInt();  
          height = line.nextInt(); 
          System.out.println(width);
          System.out.println(height);
          
          mapGrid = new Entity[width][height];
         // grid = new char[width][height];  
      
      
          for (int y = 0; y < height; y++) {{ 
        	 while(line.hasNextLine()){
            line = new Scanner(reader.nextLine());  
      
            for (int x = 0; x < width; x++) {
            	while(line.hasNext()){
              char c = line.next().charAt(0);  
      
              if (c == 'P') {  
            	  putPathIn(x, y);
              }
              else if (c == 'W'){
                  putWallIn(x, y);  
              }
              else if (c == 'B'){
                  putBoxIn(x, y);  
              }
              else if (c == 'E'){
                  putExitIn(x, y);  

              }
              else
            	  System.out.println("Unknown unit in map.txt");
            } }}}}
          }  
      
          
        
       
    



    public void addPawn(PlayerPawn p) {
    }

    public Entity[][] getGrid() {
        return this.mapGrid;
    }

    public int getGridSize() {
        return this.mapGrid.length;
    }

    public void setMapView(MapView v) {
        this.viewer = v;
    }

    private void putWallIn(int x, int y) {
        this.mapGrid[x][y] = new Entity(Entity.WALL);
    }

    private void putBoxIn(int x, int y) {
        this.mapGrid[x][y] = new Entity(Entity.BOX);
    }

    private void putPathIn(int x, int y) {
        this.mapGrid[x][y] = new Entity(Entity.PATH);
    }

    private void putExitIn(int x, int y) {
        if (!isExitSet) {
            System.out.println("exit is done");
            isExitSet = true;
            this.mapGrid[x][y] = new Entity(Entity.EXIT);
        }
    }

    private void putPlayerIn(int x, int y) {
    }
}
