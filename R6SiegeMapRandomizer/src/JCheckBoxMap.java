/*
 *
 */

import javax.swing.*;

public class JCheckBoxMap extends JCheckBox {

    JCheckBoxMap(String text, boolean isProLeague){
        setText(text);
        preCheckProLeague(isProLeague);
    }

    private void preCheckProLeague(boolean isProLeague){
        this.setSelected(isProLeague);
    }
}
