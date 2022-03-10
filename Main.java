package oms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import  java.io.File;


public class Main {
    public static class Product{
        String proId;
        String proName;
        double proPrice;

        public Product(String proId, String proName, double proPrice) {
            this.proId = proId;
            this.proName = proName;
            this.proPrice = proPrice;
        }

        @Override
        public String toString() {
            return "Product ID\tProduct Name\tProduct Price\n"+ proId + "\t\t\t"+ proName + "\t\t\t" + proPrice;
        }

        public String getProId() {
            return proId;
        }

        public void setProId(String proId) {
            this.proId = proId;
        }

        public void setProPrice(double proPrice) {
            this.proPrice = proPrice;
        }

        public String getProName() {
            return proName;
        }

        public void setProName(String proName) {
            this.proName = proName;
        }

        public double getProPrice() {
            return proPrice;
        }
    }

    public static class Order{
        String orId;
        String orDate;
        String cusId;
        String cusName;
        String cusAdd;
        ArrayList<String> productList;

        public Order(String orId, String orDate, String cusId, String cusName, String cusAdd, ArrayList<String> productList) {
            this.orId = orId;
            this.orDate = orDate;
            this.cusId = cusId;
            this.cusName = cusName;
            this.cusAdd = cusAdd;
            this.productList = productList;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orId='" + orId + '\'' +
                    ", orDate='" + orDate + '\'' +
                    ", cusId='" + cusId + '\'' +
                    ", cusName='" + cusName + '\'' +
                    ", cusAdd='" + cusAdd + '\'' +
                    ", productList=" + productList +
                    '}';
        }

        public String getCusId() {
            return cusId;
        }

        public void setCusId(String cusId) {
            this.cusId = cusId;
        }

        public String getOrId() {
            return orId;
        }

        public void setOrId(String orId) {
            this.orId = orId;
        }

        public String getCusName() {
            return cusName;
        }

        public void setCusName(String cusName) {
            this.cusName = cusName;
        }

        public String getCusAdd() {
            return cusAdd;
        }

        public void setCusAdd(String cusAdd) {
            this.cusAdd = cusAdd;
        }

        public ArrayList<String> getProductList() {
            return productList;
        }

        public void setProductList(ArrayList<String> productList) {
            this.productList = productList;
        }
    }

    public static class OrderList{
        ArrayList<Order> listOrder;

        public OrderList(ArrayList<Order> listOrder) {
            this.listOrder = listOrder;
        }

        public ArrayList<Order> getListOrder() {
            return listOrder;
        }

        public void setListOrder(ArrayList<Order> listOrder) {
            this.listOrder = listOrder;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> proList = new ArrayList<>();
        List<Order> listOfOrder = new ArrayList<>();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

        int temp;
        while (true){
            System.out.println("Menu Orders Management System");
            System.out.println("1.Add a new product to the Store");
            System.out.println("2.Update price for a particular product");
            System.out.println("3.A list of all available products in the Store");
            System.out.println("4.Create a new Order");
            System.out.println("5.Print information of an Order by Order ID");
            System.out.println("6.Sort all products by product price as ascending");
            System.out.println("7.Print information of all Orders by a specific customer ID");
            System.out.println("8.Export information of a specific Order ID to text file");
            System.out.println("9.Exit");

            System.out.println("Select your choice: ");
            temp= sc.nextInt();
            switch (temp) {
                case (1):

                    System.out.println("Add a new product");
                    sc = new Scanner(System.in);
                    Random rand = new Random();
                    int upperbound = 1000;
                    int int_random = rand.nextInt(upperbound);
                    String proId = Integer.toString(int_random);
                    System.out.println("Product Name: ");
                    String proName = sc.nextLine();
                    System.out.println("Product Price: ");
                    double proPrice = sc.nextDouble();
                    Product pro = new Product(proId,proName,proPrice);
                    proList.add(pro);
                    System.out.println(pro);

                    break;
                case (2):

                    System.out.println("2");
                    System.out.println("Input Id of product to update");
                    sc = new Scanner(System.in);
                    String idUpdate = sc.nextLine();
                    for (Product i: proList
                         ) {
                        if (i.proId.equals(idUpdate)){
                            System.out.println("Input new price: ");
                            i.proPrice = sc.nextDouble();
                        }
                    }

                    break;
                case (3):
                    System.out.println("List of products");
                    for (int i = 0; i < proList.size(); i++) {
                        System.out.println(proList.get(i));
                    }
                    break;
                case (4):
                    ArrayList<String> ordList = new ArrayList<>();
                    sc = new Scanner(System.in);
                    rand = new Random();
                    upperbound = 1000;
                    int_random = rand.nextInt(upperbound);
                    String orId = Integer.toString(int_random);
                    rand = new Random();
                    int_random = rand.nextInt(upperbound);
                    String cusId = Integer.toString(int_random);
                    String orDate = strDate;
                    System.out.println("Enter customer name: ");
                    String cusName = sc.nextLine();
                    System.out.println("Enter customer address: ");
                    String cusAdd = sc.nextLine();
                    System.out.println("Add product to order by select a product from below list: ");
                    String check="y";
                    while (check.equals("y")) {
                        for (Product i : proList
                        ) {
                            System.out.println(i);

                        }
                        System.out.println("Enter product ID:");
                        String idChoose = sc.nextLine();
                        System.out.println("Enter Quantity: ");
                        String qtt = sc.nextLine();
                        ordList.add(idChoose);
                        String tempName = null;
                        for (Product i: proList
                             ) {
                            if (i.proId.equals(idChoose)){

                                tempName = i.getProName();
                            }
                        }
                        ordList.add(tempName);
                        ordList.add(qtt);

                        System.out.println("Add more product(y/n): ");
                        check = sc.nextLine();
                    }
                    Order ord = new Order(orId,orDate,cusId,cusName,cusAdd,ordList);
                    listOfOrder.add(ord);
                    System.out.println(ord);
                    break;
                case (5):
                    System.out.println("Input Order Id to dispay: ");
                    sc = new Scanner(System.in);
                    String idDisplay = sc.nextLine();
                    for (Order i: listOfOrder
                         ) {
                        if (i.orId.equals(idDisplay)){
                            System.out.println(i);
                        }
                    }
                    break;
                case (6):
                    Collections.sort(proList,Comparator.comparing(Product::getProPrice));
                    for (int i = 0; i < proList.size(); i++) {
                        System.out.println(proList.get(i));
                    }
                    break;
                case (7):
                    System.out.println("Input Customer Id : ");
                    sc = new Scanner(System.in);
                    String cusIdTemp = sc.nextLine();
                    for (Order i: listOfOrder
                    ) {
                        if (i.cusId.equals(cusIdTemp)){
                            System.out.println(i);
                        }
                    }
                    break;
                case (8):
                    System.out.println("Input Order ID to export: ");
                    sc = new Scanner(System.in);
                    String exId = sc.nextLine();
                    for (Order i: listOfOrder
                    ) {
                        if (i.orId.equals(exId)){
                            try {
                                File myfile = new File("Order"+i.orId+".txt");
                                if (myfile.createNewFile()) {
                                    System.out.println("File created: " + myfile.getName());
                                } else {
                                    System.out.println("File already exists.");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    break;
                case (9):
                    System.out.println("9");
                    System.exit(0);

            }
        }
    }
}
