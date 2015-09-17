import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sidya on 09/09/15.
 */
public class ListenerConnection implements ActionListener{

    private FenetreIdentification f;
    public ListenerConnection(FenetreIdentification f) {
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(f.getUserList().verifierIdentite(f.getLogin().getText(), new String(f.getMdp().getPassword())))
        {
            f.setVisible(false);
            new Administration(f.getUserList(),
                    f.getUserList().obtenirUtilisateur(
                            f.getUserList().obtenirNumeroLigneUtilisateur(
                                    f.getLogin().getText())));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe invalide");
        }
    }
}
