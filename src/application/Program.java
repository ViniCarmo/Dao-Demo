package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findByID ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
        System.out.println();
        System.out.println("=== TEST 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.FindByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== TEST 3: Seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== TEST 4: Seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted, new id = " + newSeller.getId());

        System.out.println();
        System.out.println("=== TEST 5: Seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Marta Wane");
        sellerDao.update(seller);

        System.out.println();
        System.out.println("=== TEST 6: Seller Delete ===");
        System.out.println("EnterId for delete test: ");
        int id = scanner.nextInt();

        sellerDao.deleteById(id);
        System.out.println("seller for id: " + id + " delete");
    }


}
