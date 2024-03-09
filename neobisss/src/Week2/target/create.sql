CREATE TABLE `NeoShop`.`Product` (
                                       `productId` INT PRIMARY KEY,
                                     `productName` VARCHAR(30) NOT NULL,
                                     `description` TEXT,
                                           `price` DOUBLE NOT NULL,
                               `quantityAvailable` INT NOT NULL
);
CREATE TABLE `NeoShop`.`Customer` (
                                      `customerId` INT PRIMARY KEY,
                                       `firstName` VARCHAR(30) NOT NULL,
                                        `lastName` VARCHAR(30) NOT NULL,
                                           `email` VARCHAR(30) NOT NULL,
                                         `address` TEXT
);
CREATE TABLE `NeoShop`.`Order` (
                                         `orderId` INT PRIMARY KEY,
                                      `customerId` INT,
                                     `totalAmount` DOUBLE NOT NULL,
                                       `orderDate` DATE,
                                       FOREIGN KEY (`customerId`) REFERENCES `Customer`(`customerId`)
);
CREATE TABLE `NeoShop`.`Cart` (
                                          `cartId` INT PRIMARY KEY,
                                      `customerId` INT,
                                     `totalAmount` DOUBLE NOT NULL,
                                       FOREIGN KEY (`customerId`) REFERENCES `Customer`(`customerId`)
);
CREATE TABLE `NeoShop`.`Category` (
                                      `categoryId` INT PRIMARY KEY,
                                    `categoryName` VARCHAR(30) NOT NULL,
                                     `description` TEXT
);
CREATE TABLE `NeoShop`.`Payment` (
                                       `paymentId` INT PRIMARY KEY,
                                         `orderId` INT,
                                   `paymentAmount` DOUBLE NOT NULL,
                                   `paymentMethod` VARCHAR(30) NOT NULL,
                                     `paymentDate` DATE,
                                       FOREIGN KEY (`orderId`) REFERENCES `Order`(`orderId`)
);
