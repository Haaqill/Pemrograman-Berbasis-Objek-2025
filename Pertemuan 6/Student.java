import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String nim;
    private String name;
    private String major;

    public Student(String nim, String name, String major){
        this.nim = nim;
        this.name = name;
        this.major = major;
    }

    public String getNim(){
        return nim;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "NIM: " + nim + " | Nama: " + name + " | Jurusan: " + major;
    }
}
