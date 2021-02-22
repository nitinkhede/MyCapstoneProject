/*
 * Copyright (c) 2018. Shrikant G
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.capstone.dataGenerator;
import com.capstone.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Random;

public class ProductGenerator {
    private static final ProductGenerator ourInstance = new ProductGenerator();
    private final Random random;
    private final Random qty;
    private final Product[] products;

   public static ProductGenerator getInstance() {
        return ourInstance;
    }

    private ProductGenerator() {
        String DATAFILE = "MyCapstoneProject/src/main/resources/data/Products.json";
        ObjectMapper mapper = new ObjectMapper();
        random = new Random();
        qty = new Random();
        try {
            products = mapper.readValue(new File(DATAFILE), Product[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getIndex() {
        return random.nextInt(100);
    }

    private int getQuantity() {
        return qty.nextInt(2) + 1;
    }

    public Product getNextProduct() {
        Product product = products[getIndex()];
        return product;
    }
}
