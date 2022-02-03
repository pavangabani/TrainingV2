package multithreading.readwritelock;

public class ReadWriteClass {
    int i=0;
    int read(){
        return this.i;
    }
    int write(int i){
        this.i=i;
        return i;
    }
}
