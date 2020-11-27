package br.edu.ifpb.Armazenamento;

import br.edu.ifpb.dominio.Hotel;
import br.edu.ifpb.geradorId.GeradorId;

import java.io.*;

public class armazenamentoBin implements Armazenamento{

    @Override
    public Hotel recuperar(GeradorId geradorId)  {
        Hotel hotel = null;
        try (FileInputStream fis = new FileInputStream("hotel.ser");
        ObjectInputStream ois = new ObjectInputStream(fis)){
            hotel = (Hotel ) ois.readObject();
            hotel.setGeradorId(geradorId);
        } catch (FileNotFoundException e){
            hotel = new Hotel(geradorId);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public void armazenar(Hotel hotel) {
        try(FileOutputStream fos = new FileOutputStream("hotel.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(hotel);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
