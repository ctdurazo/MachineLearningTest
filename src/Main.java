public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            System.out.println("DecisionTreeDemo!");
            DecisionTreeDemo.process();
            System.out.println("SiteHealthTest!");
            SiteHealthTest.process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
