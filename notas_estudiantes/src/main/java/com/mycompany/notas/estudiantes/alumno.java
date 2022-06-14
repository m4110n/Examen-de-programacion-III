//anderson esmaikel sanchez donis
//7490-20-13902

package com.mycompany.notas.estudiantes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class alumno {

    private String nombre;
    private int num1;
    private int num2;
    private int num3;
    private int num4;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the num1
     */
    public int getNum1() {
        return num1;
    }

    /**
     * @param num1 the num1 to set
     */
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    /**
     * @return the num2
     */
    public int getNum2() {
        return num2;
    }

    /**
     * @param num2 the num2 to set
     */
    public void setNum2(int num2) {
        this.num2 = num2;
    }

    /**
     * @return the num3
     */
    public int getNum3() {
        return num3;
    }

    /**
     * @param num3 the num3 to set
     */
    public void setNum3(int num3) {
        this.num3 = num3;
    }

    /**
     * @return the num4
     */
    public int getNum4() {
        return num4;
    }

    /**
     * @param num4 the num4 to set
     */
    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public void CrearArchivo() {
        try {
            File objetoarchivo = new File("Notas.txt");
            if (objetoarchivo.createNewFile()) {
            } else {
                JOptionPane.showMessageDialog(null, "El archivo ya existe, se usaran las notas del txt.");
                LeerNotas();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el archivo :(");
        }
    }

    public void AgregarNotas() {
        try {
            FileWriter fw = new FileWriter("Notas.txt", true);
            fw.write(getNombre());
            fw.write(",");
            fw.write(Integer.toString(getNum1()));
            fw.write(",");
            fw.write(Integer.toString(getNum2()));
            fw.write(",");
            fw.write(Integer.toString(getNum3()));
            fw.write(",");
            fw.write(Integer.toString(getNum4()));
            fw.write("\n");

            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al registrar las notas :(");
        }
    }

    public void LeerNotas() {
        try {
            FileReader archivo = new FileReader("Notas.txt");
            if (archivo.ready()) {
                BufferedReader br = new BufferedReader(archivo);
                String cadena;
                cadena = br.readLine();
                String[] infor = cadena.split(",");;
                setNombre(infor[0]);
                setNum1(Integer.valueOf(infor[1]));
                setNum2(Integer.valueOf(infor[2]));
                setNum3(Integer.valueOf(infor[3]));
                setNum4(Integer.valueOf(infor[4]));
                JOptionPane.showMessageDialog(null, "Las notas han sido leidas exitosamente, dirijase a la opcion mostrar resultados");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al leer las notas :(");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al leer las notas :(");
        }
    }
}