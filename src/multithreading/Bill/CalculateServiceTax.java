package multithreading.Bill;


public class CalculateServiceTax implements Runnable{
    SharedData obj;

    public CalculateServiceTax(SharedData obj) {
        this.obj=obj;
    }

    @Override
    public void run() {
        int index=obj.indexQueue.remove();
        String product=obj.keys.get(index);
        Integer price=obj.products.get(product);

        price=(int)(price+price*0.1);
        obj.products.put(product,price);

        System.out.println(obj.products);
    }
}
