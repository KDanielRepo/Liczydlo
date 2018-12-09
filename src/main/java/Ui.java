import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class Ui {
    private JFrame ramka;
    private JPanel control;
    private JButton[] test;
    private JButton keks;
    private JButton keks2;
    private JButton back;
    public Ui(){
        ramka = new JFrame("tutaj idzie tytul");
        ramka.setSize(680,600);
        ramka.setLayout(new GridLayout(4,3));
        createUi();
    }

    public void createUi(){
        ramka.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        List<String> msc = new ArrayList<>();
        msc.add("Styczen");
        msc.add("Luty");
        msc.add("Marzec");
        msc.add("Kwiecien");
        msc.add("Maj");
        msc.add("Czerwiec");
        msc.add("Lipiec");
        msc.add("Sierpien");
        msc.add("Wrzesien");
        msc.add("Pazdziernik");
        msc.add("Listopad");
        msc.add("Grudzien");
        test = new JButton[12];
        for(int i = 0; i<12; i++){
            ramka.add(test[i] = new JButton(msc.get(i)));
            test[i].setLocation(i*50,i*50);
            int finalI = i;
            test[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch(finalI){
                        case 0: selectOne();
                            break;
                        case 1: selectOne();
                            break;
                        case 2: selectOne();
                            break;
                        case 3: selectOne();
                            break;
                        case 4: selectOne();
                            break;
                        case 5: selectOne();
                            break;
                        case 6: selectOne();
                            break;
                        case 7: selectOne();
                            break;
                        case 8: selectOne();
                            break;
                        case 9: selectOne();
                            break;
                        case 10: selectOne();
                            break;
                        case 11: selectOne();
                            break;
                    }
                }
            });
        }
        ramka.setVisible(true);
    }
    public void showUi(){
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.black);
        jPanel.setLayout(new FlowLayout());
        control.add(jPanel);
        ramka.setVisible(true);

    }
    private void selectOne() {
        for(int i = 0; i<12; i++){
            ramka.remove(test[i]);
        }
        keks = new JButton("zakup");
        keks.setLocation(0,0);
        keks2 = new JButton("sprzedaz");
        keks2.setLocation(50,0);
        back = new JButton("wstecz");
        back.setLocation(0,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ramka.remove(keks);
                ramka.remove(keks2);
                ramka.remove(back);
                createUi();
                ramka.repaint();
            }
        });
        ramka.add(keks);
        ramka.add(keks2);
        ramka.add(back);
        ramka.setVisible(true);
        ramka.repaint();
    }

}
