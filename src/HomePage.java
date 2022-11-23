import javax.swing.*;

final class Constants{
    private Constants(){}
    static final public float fileSelectorHeightPer = 0.90f;//90 percent of window height
    static final public float fileSelectorWidthPer = 0.25f;//25 percent of window width
    static final public int fileSelectorMinWidthPx = 140;//140 pixels
}

public class HomePage{
    public enum Showing{
        STUDENT,
        MODULE,
        DATA_NOT_LOADED
    }
    private Showing m_Showing = Showing.STUDENT;
    HomePage(JFrame frame, StudentInfo studentInfo){
        SetupFileSelector(frame, studentInfo);
        SetupStudentButton(frame);
        SetupModuleButton(frame);
    }

    void SetupFileSelector(JFrame frame, StudentInfo studentInfo){
        FileSelector m_FileSelector = new FileSelector("Upload Data");
        m_FileSelector.SetExtensionFilter("csv");
        m_FileSelector.SetBounds(0,
                (int)(frame.getHeight() * (1.0f - Constants.fileSelectorHeightPer)),
                Math.max(Constants.fileSelectorMinWidthPx, (int)(frame.getWidth() * Constants.fileSelectorWidthPer)),
                (int)(frame.getHeight() * Constants.fileSelectorHeightPer));
        m_FileSelector.AttachTo(frame);
        m_FileSelector.Repaint();
        m_FileSelector.SetAction(studentInfo::Load);
    }

    void SetupStudentButton(JFrame frame){
        JButton m_StudentButton = new JButton("Analyze Students");
        m_StudentButton.setBounds(0, 0,
                (int)(frame.getWidth() * 0.5f),
                (int)(frame.getHeight() * (1.0f - Constants.fileSelectorHeightPer)));
        frame.add(m_StudentButton);
        m_StudentButton.repaint();

        m_StudentButton.addActionListener( e -> { m_Showing = Showing.STUDENT; } );
    }

    void SetupModuleButton(JFrame frame){
        JButton m_ModuleButton = new JButton("Analyze Modules");
        m_ModuleButton.setBounds((int)(frame.getWidth() * 0.5f),
                0,
                (int)(frame.getWidth() * 0.5f),
                (int)(frame.getHeight() * (1.0f - Constants.fileSelectorHeightPer)));
        frame.add(m_ModuleButton);
        m_ModuleButton.repaint();

        m_ModuleButton.addActionListener( e -> { m_Showing = Showing.MODULE; } );
    }

}
