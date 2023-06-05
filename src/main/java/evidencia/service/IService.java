package evidencia.service;

import evidencia.model.SetGet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IService {

    void ulozDoSuboru(ArrayList<SetGet>zoznam,String nazovZoznamu) throws IOException;
    ArrayList<SetGet> orvorZoSuboru(String nazovZoznamu) throws IOException, ClassNotFoundException;
}

