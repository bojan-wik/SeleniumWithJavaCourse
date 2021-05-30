package Chapter30;

public class Interface_PolishTraffic implements Interface_CentralTraffic, Interface_EuropeTraffic {

    public static void main(String[] args) {
        Interface_CentralTraffic pl = new Interface_PolishTraffic();
        pl.redStop();
        pl.flashYellow();
        pl.greenGo();

        Interface_PolishTraffic plLocal = new Interface_PolishTraffic();
        plLocal.redAndYellow();

        Interface_EuropeTraffic plEU = new Interface_PolishTraffic();
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
