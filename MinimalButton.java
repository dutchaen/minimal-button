import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MinimalButton extends JPanel {

    private final JButton button;
    private final JPanel buttonPanel;
    private static Boolean isWindows = null;
    private static final FlowLayout emptyFlowLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);

    MinimalButton(String text) {
        var customBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY);

        this.buttonPanel = new JPanel(emptyFlowLayout, true);

        this.button = new JButton(text);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 5, 20));
        button.setBackground(new Color(0xEE, 0xEE, 0xEE));
        if (isWindows()) {
            button.setFont(Font.decode("Segoe UI Emoji"));
        }

        button.setFocusable(false);

        buttonPanel.add(button);
        buttonPanel.setBorder(customBorder);

        this.add(buttonPanel);
    }

    @Override
    public void setBorder(Border border) {
        if (buttonPanel == null)
            return;

        buttonPanel.setBorder(border);
    }

    @Override
    public void setBackground(Color color) {
        if (button == null)
            return;

        button.setBackground(color);
    }

    @Override
    public void setFont(Font font) {
        if (button == null) {
            return;
        }

        button.setFont(font);
    }

    private static boolean isWindows() {
        if (isWindows != null) {
            return isWindows;
        }

        var operatingSystemName = System.getProperty("os.name");
        isWindows = operatingSystemName.contains("Windows");
        return isWindows;
    }
}
