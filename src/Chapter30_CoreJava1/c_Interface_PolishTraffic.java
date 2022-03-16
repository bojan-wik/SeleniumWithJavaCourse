package Chapter30_CoreJava1;

public class c_Interface_PolishTraffic implements c_Interface_CentralTraffic, c_Interface_EuropeTraffic {

    public static void main(String[] args) {
        c_Interface_CentralTraffic pl = new c_Interface_PolishTraffic();
        pl.redStop();
        pl.flashYellow();
        pl.greenGo();

        c_Interface_PolishTraffic plLocal = new c_Interface_PolishTraffic();
        plLocal.redAndYellow();

        c_Interface_EuropeTraffic plEU = new c_Interface_PolishTraffic();
        plEU.europeanTrafficRule();
    }

    @Override
    public void greenGo() {
        System.out.println("greenGo interface implementation");
    }

    @Override
    public void redStop() {
        System.out.println("redStop interface implementation");
    }

    @Override
    public void flashYellow() {
        System.out.println("flashYellow interface implementation");
    }

    public void redAndYellow() {
        System.out.println("redAndYellow local implementation");
    };

    @Override
    public void europeanTrafficRule() {
        System.out.println("europeanTrafficRule implementation");
    }
}
