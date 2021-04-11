/*
 * Copyright (C) 2021 sempe
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.util.Comparator;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 * {@code Shop } class represents an application that manages Products
 *
 * @version 4.0
 * @author sempe
 */
public final class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductManager pm = new ProductManager("pt-BR");

        pm.createProduct(103, "Coffee 2", BigDecimal.valueOf(8.99), Rating.NOT_RATED);

        pm.reviewProduct(103, Rating.ONE_STAR, "OK");
        pm.reviewProduct(103, Rating.ONE_STAR, "Where is the milk?");
        pm.reviewProduct(103, Rating.TWO_STAR, "Perfect");

        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);

        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
        pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice tea");
        pm.reviewProduct(101, Rating.FIVE_STAR, "The beste tea");
        pm.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");

        pm.createProduct(104, "Tea 2", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.reviewProduct(104, Rating.TWO_STAR, "Rather weak tea");

        pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), Rating.NOT_RATED);

        pm.reviewProduct(102, Rating.THREE_STAR, "OK");
        pm.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?");
        pm.reviewProduct(102, Rating.FIVE_STAR, "Perfect");

        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());

        pm.printProducts(ratingSorter.thenComparing(priceSorter));

    }

}
