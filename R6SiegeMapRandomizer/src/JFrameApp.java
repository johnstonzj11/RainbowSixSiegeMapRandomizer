/*
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameApp extends JFrame {

    final private String[] MAPNAMES = {
            "Bank*",
            "Bartlett University",
            "Border*",
            "Chalet",
            "Clubhouse*",
            "Coastline*",
            "Consulate*",
            "Favela",
            "Fortress",
            "Hereford Base",
            "House",
            "Kafe",
            "Kanal",
            "Oregon*",
            "Outback",
            "Plane",
            "Skyscraper",
            "Theme Park",
            "Tower",
            "Villa*",
            "Yacht"
    };

    JFrameApp() {
        //sets defaults for the application
        setTitle("Rainbow Six Siege: Random Map Picker");
        setName("Rainbow Six Siege: Random Map Picker");
        setSize(800, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //north panel
        JPanel north = new JPanel();

        JLabel output = new JLabel("Awaiting randomization...");

        JButton randomize = new JButton("Randomize");

        north.add(output);
        north.add(randomize);
        add(north, BorderLayout.NORTH);

        //center panel
        JPanel center = new JPanel();

        JCheckBoxMap[] maps = createCheckBoxArray(MAPNAMES);

        for(int i = 0; i < maps.length; i++){
            center.add(maps[i]);
        }
        add(center, BorderLayout.CENTER);

        //south panel
        JPanel south = new JPanel();

        JLabel information = new JLabel("*Maps used in Pro League");

        south.add(information);
        add(south, BorderLayout.SOUTH);

        //action listeners
        randomize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(randomize(maps));
            }
        });

        //sets the visibility of the application
        setVisible(true);
    }

    //creates an array of CheckBoxes from a string of names
    private JCheckBoxMap[] createCheckBoxArray(String[] mapNames){
        JCheckBoxMap[] maps = new JCheckBoxMap[mapNames.length];

        for(int i = 0;  i < maps.length; i++){
            maps[i] = new JCheckBoxMap(mapNames[i], mapNames[i].contains("*"));
        }

        return maps;
    }

    //returns a random string text entry from an array of CheckBoxes
    private String randomize(JCheckBoxMap[] maps){

        int checkedCount = 0;

        for(int i = 0; i < maps.length; i++){
            if(maps[i].isSelected()){
                //System.out.println(maps[i].getText());
                checkedCount++;
            }
        }

        if(checkedCount > 0) {
            String[] checkedMaps = new String[checkedCount];
            int pointer = 0;

            for (int i = 0; i < maps.length; i++) {
                if (maps[i].isSelected()) {
                    checkedMaps[pointer] = maps[i].getText();
                    pointer++;
                }
            }

            return checkedMaps[(int)(Math.random()*checkedMaps.length)];
        }
        else{
            return "Please select at least one map";
        }
    }
}
