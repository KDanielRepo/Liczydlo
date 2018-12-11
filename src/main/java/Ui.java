import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class Ui {
    private JFrame ramka;
    private JPanel control;
    private JButton[] test;
    private JButton buy;
    private JButton sell;
    private JButton stats;
    private JButton back;
    private JTextField quantity;
    private JTextField price;
    private JLabel wynik;
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
        buy = new JButton("zakup");
        buy.setLocation(0,0);
        sell = new JButton("sprzedaz");
        sell.setLocation(50,0);
        back = new JButton("wstecz");
        back.setLocation(0,50);
        stats = new JButton("podsumowanie");
        stats.setLocation(50,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backFromBuySellMenu();
            }
        });
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showStats();
                    Excel excel = new Excel();
                    quantity = new JTextField();
                    price = new JTextField();
                    ramka.add(quantity);
                    ramka.add(price);
                    wynik = new JLabel("test");
                    ramka.add(wynik);
                    wynik.setText(excel.test());
                    wynik.setLocation(0,0);
                    wynik.setVisible(true);
                    ramka.repaint();
                }catch (IOException | InvalidFormatException e1){
                    e1.printStackTrace();
                }
            }
        });
        stats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStats();
            }
        });
        ramka.add(buy);
        ramka.add(sell);
        ramka.add(back);
        ramka.add(stats);
        ramka.setVisible(true);
        ramka.repaint();
    }
    private void showStats(){
        ramka.remove(buy);
        ramka.remove(sell);
        ramka.remove(stats);
        ramka.repaint();
    }
    private void backFromBuySellMenu(){
        ramka.remove(buy);
        ramka.remove(sell);
        ramka.remove(back);
        ramka.remove(stats);
        ramka.remove(wynik);
        createUi();
        ramka.repaint();
    }

}
