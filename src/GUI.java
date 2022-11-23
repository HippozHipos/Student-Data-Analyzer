import javax.swing.*;
import java.awt.*;

class GUI{
    final private JFrame m_Frame = new JFrame();
    final private StudentInfo m_StudentInfo;

    public GUI(float percent, StudentInfo studentInfo){
        m_StudentInfo = studentInfo;
        InitFrame(percent);
        InitPages();
    }
    private void InitFrame(float percent){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        percent = Math.max(0.0f, Math.min(percent * 0.01f, 1.0f));
        float windowX = ((1.0f - percent) * (float)screenSize.getWidth()) * 0.5f;
        float windowY = ((1.0f - percent) * (float)screenSize.getHeight()) * 0.5f;
        float windowW = percent * (float)screenSize.getWidth();
        float windowH = percent * (float)screenSize.getHeight();
        m_Frame.setBounds((int)windowX, (int)windowY, (int)windowW, (int)windowH);
        m_Frame.setResizable(false);
        m_Frame.setTitle("Team Project");
        m_Frame.setLayout(null);
        m_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_Frame.setVisible(true);
    }

    private void InitPages(){
        HomePage homepage = new HomePage(m_Frame, m_StudentInfo);
    }

}

