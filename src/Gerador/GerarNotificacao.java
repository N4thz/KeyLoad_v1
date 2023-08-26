package Gerador;
import Telas.TelaPrincipal;
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.util.concurrent.*;
import javax.swing.table.TableColumn;

public class GerarNotificacao {
    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void exibirNotificacao(String titulo, String conteudo, int duracao) {
        if (SystemTray.isSupported()) {
            
        } else {
            System.err.println("SystemTray não suportado no sistema");
        }
        class MyRunnable implements Runnable {
        @Override
        public void run() {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("caminho/para/o/icone.png");
            TrayIcon trayIcon = new TrayIcon(image, "Minha Notificação", popupMenu());

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("Erro ao adicionar TrayIcon");
            }

            trayIcon.displayMessage(titulo, conteudo, MessageType.INFO);

            
            try {
                Thread.sleep(duracao);
            } catch (InterruptedException e) {
            }
            tray.remove(trayIcon); // Remove a notificação do System Tray
        }
        
    }
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    private static PopupMenu popupMenu() {
        PopupMenu popupMenu = new PopupMenu();
        MenuItem exitItem = new MenuItem("Sair");
        exitItem.addActionListener(e -> System.exit(0));
        popupMenu.add(exitItem);
        return popupMenu;
    }
}


