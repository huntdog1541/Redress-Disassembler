import abi.mach.parse.MachParser64;
import abi.mach.parse.Reader;

import java.io.File;

public class Main {

    public static void main(String[] args){
        File in =new File("/Users/jamesrichardson/Desktop/reverse/a.out");

        try {
            Reader.Read(in);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}