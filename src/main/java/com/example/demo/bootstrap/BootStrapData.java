package com.example.demo.bootstrap;

// import com.example.demo.domain.OutsourcedPart;
// import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        // this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

        // Sample Product Inventory
        Part shoelace = new Part("Shoelace Replacement", 4.99, 20);
        Part vestStrap = new Part("Vest Strap Replacement", 8.99, 10);
        Part headBand = new Part("Head Lamp Band Replacement", 14.99, 6);
        Part lampBulb = new Part("Head Lamp Bulb Replacement", 16.99, 9);
        Part filter = new Part("Replacement Water Filter", 15.99, 15);

        if (partRepository.count() == 0) {
            partRepository.save(shoelace);
            partRepository.save(vestStrap);
            partRepository.save(headBand);
            partRepository.save(lampBulb);
            partRepository.save(filter);
        }

        // Sample Product Inventory

        Product hokas = new Product("Hoka Speedgoat 5", 149.99, 5);
        Product wildhorse = new Product("Nike Wildhorse 8", 97.99, 10);
        Product ultimateVest = new Product("Ultimate Direction Hydration Vest", 109.99, 5);
        Product headLamp = new Product("Petzl Headlamp", 59.99, 6);
        Product waterFilter = new Product("BeFree Filtered Water Bottle", 39.99, 8);

        // Uncomment the below code to reset sample inventory:
        // productRepository.deleteAll();

        if (productRepository.count() == 0) {
            productRepository.save(hokas);
            productRepository.save(wildhorse);
            productRepository.save(ultimateVest);
            productRepository.save(headLamp);
            productRepository.save(waterFilter);
        }


    }
}

