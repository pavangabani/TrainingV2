package multithreading.Bill;

public class CalculateTax implements Runnable{
    SharedData obj;

    public CalculateTax(SharedData obj) {
        this.obj=obj;
    }

    @Override
    public void run() {
        int index=obj.getCurrentIndex();
        try {
            obj.indexQueue.put(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String product=obj.keys.get(index);
        Integer price=obj.products.get(product);

        price=(int)(price+price*0.1);
        obj.products.put(product,price);

        CalculateServiceTax task=new CalculateServiceTax(obj);
        Thread calculateServiceTax =new Thread(task);
        calculateServiceTax.start();
    }
}
