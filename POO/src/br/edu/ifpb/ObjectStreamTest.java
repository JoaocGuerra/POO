package br.edu.ifpb;

import java.io.*;

class Aluno implements Serializable {
    int mat;
    String nome;

    public Aluno(int mat, String nome) {
        this.mat = mat;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "mat=" + mat +
                ", nome='" + nome + '\'' +
                '}';
    }
}


public class ObjectStreamTest {
    //Antes:
    //FileInputStream BufferedInputStream
    //FileOutputStream BufferedOutputStream

    //Agora:
    //FileInputStream ObjectInputStream
    //FileOutputStream BufferedOutputStream

    public static void main(String[] args) {

        try (
                FileOutputStream fos = new FileOutputStream("files/aluno.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream("files/aluno.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);) {

            Aluno a = new Aluno(555, "Ana");
            System.out.println(a.toString());

            oos.writeObject(a); // GRAVANDO em arquivo.ser

            a = null; // perder o objeto p/ coletor de lixo

            a = (Aluno) ois.readObject(); // LENDO do arquivo!

            a.setNome("pedro");
            System.out.println(a.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
