/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import filehandler.FileHandler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import matrix.Matrix;
import matrix.MatrixException;
import matrix.SquareMatrix;

/**
 *
 * @author chuon
 */
public class Client {

    public static ObjectOutputStream objectOutputStream;
    public static ObjectInputStream objectInputStream;
    public static DataInputStream dataInputStream;

    public static void main(String[] args) {
        String fileToServer = "F:\\test\\client.txt";
        String fileFromServer = "F:\\test\\fromServer.txt";
        try {
            Socket socket = new Socket("localhost", 2700);
            FileHandler fileHandler = new FileHandler(socket);
            fileHandler.send(fileToServer);
            fileHandler.get(fileFromServer);
//        try {
//            Socket socket = new Socket("localhost", 2600);
//            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//            objectInputStream = new ObjectInputStream(socket.getInputStream());
//            dataInputStream = new DataInputStream(socket.getInputStream());
//
//            Matrix m1 = SquareMatrix.inputMatrix();
//            System.out.println("The first matrix: ");
//            m1.print();
//            objectOutputStream.writeObject(m1);
//
//            System.out.println("The second matrix: ");
//            Matrix m2 = Matrix.inputMatrix();
//            objectOutputStream.writeObject(m2);
//
//            Matrix m3 = (Matrix) objectInputStream.readObject();
//            System.out.println("The result of m1*m2: ");
//            m3.print();
//
//            double m1Det = dataInputStream.readDouble();
//            System.out.println("The determinant of m1: " + m1Det);
//
//            Matrix m4 = (Matrix) objectInputStream.readObject();
//            m4.print();
//        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println(ex.toString());
//        }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
