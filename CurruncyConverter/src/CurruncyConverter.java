/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JAVA
 */
public class CurruncyConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel egyptePoundLabel = new JLabel("Egyption pound amount :");
        JLabel toCurrencyLabel = new JLabel("Converte To :");
        JLabel resultLabel = new JLabel(" value :");
        
        // الليبل ده مدتلوش اسم عشان ده ال هحط فيه قيمه التحويل بين العملات
        final JLabel resultValueLabel = new JLabel();

        // الاراي ال فيها العملات
        String[] CurrencyArray = {"Dollar", "Euro", "Ryial"};

        final JTextField egyptePoundField = new JTextField(20);

        //الكمبو بوكس ال هختار منها العمله
        //دي بتاخد بارامتر من نوع ارراي فيه اسامى العملات بتاعتى 
        final JComboBox curruncy = new JComboBox(CurrencyArray);
// دي معناها بقولو اختارلي اول اندكس واظهره في الكمبو بوكس ال هى عندنا هتبقى الدولار
        curruncy.setSelectedIndex(0);

        // ده زرار التحويل  وبديله اسم 
        JButton convertButton = new JButton("Converte");
      
        // دي البانال ال هتشيل الفيلدس بتاعتى ماعدا الزرار
        JPanel fieldsPanel = new JPanel();
        // بضيف نوع اللاي اوت بتاع البانال دي واللاي اوت معناها طريقه ترتيب الكمبوننت علي البانال
        // ونوع اللاي اوت هنا من نوع جراد لاي اوت 
        fieldsPanel.setLayout(new GridLayout(0, 2, 5, 5));

        // add fields to fields panel
        fieldsPanel.add(egyptePoundLabel);
        fieldsPanel.add(egyptePoundField);
        fieldsPanel.add(toCurrencyLabel);
        fieldsPanel.add(curruncy);
        fieldsPanel.add(resultLabel);
        fieldsPanel.add(resultValueLabel);

        //  add convert button 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(convertButton);

        mainPanel.add(fieldsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);

        convertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // ديسيمل فورمات دي هستخدمها عشان اعرض عدد معين من الارقام بعد العلامه العشريه
                // وهنا استخدمت ٫## يعنى رقمين بعد العلامه
                DecimalFormat decimal = new DecimalFormat(".##");
                // هجيب القييمه ال هدخلها في الفيلد الخاص ب الجنيه المصري واخزنها في متغير اسمه امونت
                // وهحوله ل دبل لان القيمه ال جاى من التيكست فيلد بتبقى من نوع استرنج فلازم احولها لدبل عشان اعرف اعمل عمليات حسابيه عليها
                double amount = Double.valueOf(egyptePoundField.getText());
                // نتيجه التحويل
                double result;
                // اول اف معناها بقولو لو اليوزر اختار اول اندكس وهو صفر معناها انه اختار انه هيحول للدولار
                // فعمل عمليه التحويل 
                if (curruncy.getSelectedIndex() == 0) {
                    // بعمل عمليه التحويل 
                    // الدولار فيه ١٧٫٩٢ جنيه مصري
                    result = amount / 17.92;
                    // هنا بستخدم ميثود سيت تكست عشان احط القيمه ع الليبل ال مدتلوش اسم فوق 
                    // واستخدمت ديسيمل  فورمات عشان اعرض رقمين بعد العلامه العشريه
                    resultValueLabel.setText(amount + " Egy Pound = " + decimal.format(result) + " Dollar");
                } // ده لو اختار اليورو 
                else if (curruncy.getSelectedIndex() == 1) {

                    result = amount / 20.40;
                    resultValueLabel.setText(amount + " Egy Pound = " + decimal.format(result) + " Euro ");
                } else if (curruncy.getSelectedIndex() == 2) {
                    result = amount / 4.77;
                    resultValueLabel.setText(amount + " Egy Pound = " + decimal.format(result) + " Saudi Riyal");
                }
            }
        });

    }

}
