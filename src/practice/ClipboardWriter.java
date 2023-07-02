package practice;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardWriter {
    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        String value1 = "Значение 1";
        String value2 = "Значение 2";
        String value3 = "Значение 3";

        // Получение системного буфера обмена
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Запись значения 1 в буфер обмена
        StringSelection selection1 = new StringSelection(value1);
        clipboard.setContents(selection1, null);
        System.out.println("Значение 1 скопировано в буфер обмена.");

        // Вставка значения 1 из буфера обмена
        String pasteValue1 = (String) clipboard.getData(DataFlavor.stringFlavor);
        System.out.println("Значение 1 из буфера обмена: " + pasteValue1);

        // Запись значения 2 в буфер обмена
        StringSelection selection2 = new StringSelection(value2);
        clipboard.setContents(selection2, null);
        System.out.println("Значение 2 скопировано в буфер обмена.");

        // Вставка значения 2 из буфера обмена
        String pasteValue2 = (String) clipboard.getData(DataFlavor.stringFlavor);
        System.out.println("Значение 2 из буфера обмена: " + pasteValue2);

        // Запись значения 3 в буфер обмена
        StringSelection selection3 = new StringSelection(value3);
        clipboard.setContents(selection3, null);
        System.out.println("Значение 3 скопировано в буфер обмена.");

        // Вставка значения 3 из буфера обмена
        String pasteValue3 = (String) clipboard.getData(DataFlavor.stringFlavor);
        System.out.println("Значение 3 из буфера обмена: " + pasteValue3);
    }
}
