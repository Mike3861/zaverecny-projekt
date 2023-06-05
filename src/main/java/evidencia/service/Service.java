package evidencia.service;
import evidencia.model.SetGet;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimerTask;

import static evidencia.View.GUI.timeFormat;
import static evidencia.View.GUI.timeLabel;

public class Service implements IService{
    public static class UpdateTimeTask extends TimerTask {
        @Override
        public void run() {
            Calendar currentTime = Calendar.getInstance();
            String formattedTime = timeFormat.format(currentTime.getTime());
            timeLabel.setText(formattedTime);
        }
    }


    @Override
    public void ulozDoSuboru(ArrayList<SetGet> zoznam, String nazovZoznamu) throws IOException {
        System.out.println("ludia v evidencii:");
        for (SetGet listZoznamu:zoznam){
            System.out.println(listZoznamu);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(nazovZoznamu);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(zoznam);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public ArrayList<SetGet> orvorZoSuboru(String nazovZoznamu) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(nazovZoznamu);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<SetGet> zoznamSetGet = (ArrayList<SetGet>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return zoznamSetGet;
    }
}
