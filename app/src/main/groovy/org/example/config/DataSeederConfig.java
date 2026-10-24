package org.example.config;

import org.example.entities.Category;
import org.example.entities.Product;
import org.example.entities.ProductCategory;
import org.example.repository.CategoryRepository;
import org.example.repository.ProductCategoryRepository;
import org.example.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Configuration
public class DataSeederConfig {

    @Bean
    CommandLineRunner initDatabase(
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
            ProductCategoryRepository productCategoryRepository) {
        return args -> seedDatabase(productRepository, categoryRepository, productCategoryRepository);
    }

    @Transactional
    public void seedDatabase(
            ProductRepository productRepo,
            CategoryRepository categoryRepo,
            ProductCategoryRepository mappingRepo) {

        // --- Electronics (Existing + New Entries) ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "iPhone 16", "Electronics", "79999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Samsung Galaxy S25", "Electronics", "74999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "OnePlus 13", "Electronics", "69999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Apple iPad Air", "Electronics", "59999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Google Pixel 9 Pro", "Electronics", "109999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Nintendo Switch OLED", "Electronics", "32999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Apple Watch Series 10", "Electronics", "46999.00");

        // --- Laptops & Computing ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "MacBook Air M4", "Laptops", "99999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Dell Inspiron 15", "Laptops", "54999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "ASUS ROG Zephyrus G14", "Laptops", "144999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "HP Spectre x360", "Laptops", "119999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Lenovo ThinkPad X1 Carbon", "Laptops", "159999.00");

        // --- Accessories & Hardware Peripheral Layer ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Sony WH-1000XM5", "Accessories", "24999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Logitech MX Master 3S", "Accessories", "9999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Keychron K2 Wireless Keyboard", "Accessories", "7499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Anker Prime 20000mAh Power Bank", "Accessories", "4999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Elgato Stream Deck MK.2", "Accessories", "13999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Razer DeathAdder V3 Pro", "Accessories", "12499.00");

        // --- Footwear & Performance Apparel ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Nike Air Max", "Footwear", "8999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Adidas Ultraboost", "Footwear", "12999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Puma RS-X Geek", "Footwear", "6499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Asics Gel-Kayano 30", "Footwear", "15999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "New Balance 574 Classic", "Footwear", "7999.00");

        // --- Fitness & Smart Health Gear (New Test Category) ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Bowflex SelectTech Dumbbells", "Fitness", "34999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Fitbit Charge 6", "Fitness", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Theragun Prime Massager", "Fitness", "28999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Manduka PRO Yoga Mat", "Fitness", "9999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Garmin Forerunner 265", "Fitness", "43999.00");

        // --- Office Supplies & Workstation Furniture (New Test Category) ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Herman Miller Aeron Chair", "Furniture", "124999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Autonomous SmartDesk Core", "Furniture", "38999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "BenQ ScreenBar Monitor Light", "Furniture", "9999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Everlasting Comfort Seat Cushion", "Furniture", "3499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Logitech Brio 4K Webcam", "Furniture", "18999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Steelcase Gesture Task Chair", "Furniture", "115999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Dell 27-Inch 4K USB-C Monitor", "Furniture", "32999.00");

        // --- Audio & Premium Sound Gear ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Bose QuietComfort Ultra", "Audio", "35999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Apple AirPods Pro 2", "Audio", "24999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Sennheiser HD 660S2", "Audio", "42999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Jailbreak Flip 6 Bluetooth Speaker", "Audio", "11999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Sony HT-A7000 Soundbar", "Audio", "109999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Shure SM7B Vocal Microphone", "Audio", "38999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Audio-Technica AT-LP120X", "Audio", "34999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Marshall Stanmore III", "Audio", "41999.00");

        // --- Smart Home & Appliances ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Dyson V15 Detect Vacuum", "Appliances", "65999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Philips Air Fryer XL", "Appliances", "16999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "iRobot Roomba j7+", "Appliances", "74999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Instant Pot Duo Plus", "Appliances", "12999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Xiaomi Smart Air Purifier 4", "Appliances", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Eufy Video Doorbell E340", "Appliances", "17999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Philips Hue Starter Kit", "Appliances", "11999.00");

        // --- Coffee & Kitchen Tech ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Breville Barista Express", "Kitchen", "69999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "DeLonghi Magnifica Start", "Kitchen", "45999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Fellow Stagg EKG Kettle", "Kitchen", "15999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Cosori Gooseneck Smart Kettle", "Kitchen", "8999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Nespresso Vertuo Pop", "Kitchen", "13999.00");

        // --- Gaming Equipment & Consoles ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "PlayStation 5 Pro", "Gaming", "69999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Xbox Series X", "Gaming", "55999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Steam Deck OLED 512GB", "Gaming", "52999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "ASUS ROG Ally X", "Gaming", "74999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Logitech G29 Driving Force", "Gaming", "29999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "SteelSeries Arctis Nova Pro", "Gaming", "32999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Secretlab TITAN Evo", "Gaming", "48999.00");

        // --- Expansion: Electronics ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Sony Alpha 7 IV Camera", "Electronics", "219999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "DJI Mini 4 Pro Drone", "Electronics", "94999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "GoPro HERO13 Black", "Electronics", "44999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Kindle Paperwhite 16GB", "Electronics", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "iPad Pro M4 11-inch", "Electronics", "99999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Samsung T7 Shield 2TB SSD", "Electronics", "16999.00");

        // --- Expansion: Laptops & Displays ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "MacBook Pro 14 M4 Pro", "Laptops", "199999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "ASUS Zenbook DUO 2026", "Laptops", "219999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Razer Blade 16 Gaming Laptop", "Laptops", "289999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "LG UltraGear 34-Inch Curved", "Laptops", "78999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Samsung Odyssey OLED G9", "Laptops", "134999.00");

        // --- Expansion: Accessories ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Apple Magic Keyboard for iPad", "Accessories", "29999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Logitech G Pro X Superlight 2", "Accessories", "16999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Peak Design Everyday Backpack", "Accessories", "23999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Belkin 3-in-1 MagSafe Charger", "Accessories", "13999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Satechi Thunderbolt 4 Dock", "Accessories", "27999.00");

        // --- Expansion: Footwear & Fitness ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Nike Pegasus 41", "Footwear", "11999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Brooks Ghost 16", "Footwear", "13999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Salomon Speedcross 6", "Footwear", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Spikeball Pro Kit", "Fitness", "9999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Concept2 RowErg Model D", "Fitness", "115000.00");

        // --- Expansion: Office Furniture ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Steelcase Leap V2 Chair", "Furniture", "98999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Vari Electric Standing Desk", "Furniture", "54999.00");

        // --- Travel Gear & Portability ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Samsonite Omni 2 Hardside Spinner", "Travel", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Nomatic Travel Bag 40L", "Travel", "23999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Bellroy Classic Backpack Plus", "Travel", "16499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Anker MagGo Magnetic Power Bank", "Travel", "3999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Sony SRS-XB100 Compact Speaker", "Travel", "4999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Matador FlatPak Toiletry Case", "Travel", "2499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Peak Design Travel Tripod Carbon", "Travel", "54999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "JBL Tour ONE M2 Headphones", "Travel", "21999.00");

        // --- Streaming & Content Creation ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Rode Rodecaster Pro II", "Streaming", "64999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Elgato Key Light Air", "Streaming", "12999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Logitech G Yeti GX Microphone", "Streaming", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Elgato Facecam Pro 4K", "Streaming", "27999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Focusrite Scarlett 2i2 Gen 4", "Streaming", "18499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Razer KiYo Pro Ultra Webcam", "Streaming", "25999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Shure MV7X Podcast Microphone", "Streaming", "16499.00");

        // --- Smart Lighting & Decor Home Automation ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Govee RGBIC LED Strip Lights", "Appliances", "2999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Nanoleaf Lines Starter Kit", "Appliances", "18999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "TP-Link Tapo Smart Plug Four Pack", "Appliances", "3499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Google Nest Learning Thermostat", "Appliances", "22999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Ecobee Smart Thermostat Premium", "Appliances", "24999.00");

        // --- Premium Coffee Accessories & Grind Tech ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Baratza Encore ESP Grinder", "Kitchen", "19999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Fellow Ode Gen 2 Brew Grinder", "Kitchen", "31999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Acaia Lunar Coffee Scale", "Kitchen", "26499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Timemore Chestnut C3 Manual Grinder", "Kitchen", "5499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Ember Smart Mug 2", "Kitchen", "13999.00");

        // --- PC Components & Component Upgrade Layer ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "NVIDIA GeForce RTX 4070 Super", "Electronics", "62999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "AMD Ryzen 7 7800X3D CPU", "Electronics", "38999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Corsair Vengeance DDR5 32GB RAM", "Electronics", "11499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Samsung 990 PRO 2TB NVMe SSD", "Electronics", "18499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "ASUS ROG Strix B650-A Motherboard", "Electronics", "24999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "NZXT Kraken Elite 360 RGB AIO", "Electronics", "26999.00");

        // --- Premium Gaming Keyboards & Input Peripherals ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Wooting 60HE+ Analog Keyboard", "Gaming", "18999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Logitech G PRO X TKL Lightspeed", "Gaming", "21999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Razer Huntsman V3 Pro TKL", "Gaming", "20999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "SteelSeries Apex Pro TKL Wireless", "Gaming", "23999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "ASUS ROG Azoth Custom Keyboard", "Gaming", "24499.00");

        // --- Premium Ergonomic Footwear & Lifestyle ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Hoka Clifton 9", "Footwear", "13999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "On Cloudmonster 2", "Footwear", "16999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Saucony Triumph 21", "Footwear", "14499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Mizuno Wave Rider 27", "Footwear", "12999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Birkenstock Arizona EVA", "Footwear", "4999.00");

        // --- Workstation Setup Accessories & Enhancements ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Grovemade Wood Monitor Stand", "Furniture", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "DeltaHub Carpio 2.0 Ergonomic Wrist Rest", "Furniture", "3499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Orbitkey Desk Mat Medium", "Furniture", "6499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Belkin Pro Thunderbolt 4 Dock", "Furniture", "32999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "CalDigit TS4 Docking Station", "Furniture", "39999.00");

        // --- Mobile Devices & Premium Audio Hardware Extensions ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Sony WF-1000XM5 Earbuds", "Audio", "21999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Sennheiser Momentum True Wireless 4", "Audio", "24999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Bose Ultra Open Earbuds", "Audio", "25999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Nothing Ear (a)", "Audio", "7999.00");

        // --- Home Security & Safety Systems ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Ring Battery Doorbell Plus", "Security", "12999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Arlo Pro 5S 2K Camera", "Security", "19999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Google Nest Cam Battery", "Security", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Eufy Cam 3 3-Cam Kit", "Security", "45999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "August Wi-Fi Smart Lock 4th Gen", "Security", "18499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Schlage Encode Smart Wi-Fi Deadbolt", "Security", "21999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Yale Assure Lock 2", "Security", "15499.00");

        // --- Musical Instruments & Studio Production ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Akai MPK Mini MK3 Keyboard", "Music", "9499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Fender Squier Sonic Stratocaster", "Music", "17999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Yamaha P-45 Digital Piano", "Music", "42999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Focusrite Scarlett Solo Gen 4", "Music", "12499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Arturia MiniLab 3 MIDI Controller", "Music", "10999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Novation Launchpad X", "Music", "16999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Audio-Technica ATH-M50x Headphones", "Music", "13499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "KRK Rokit 5 G5 Studio Monitor", "Music", "18999.00");

        // --- Smart Health & Personal Care Tech ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Oura Ring Gen3 Horizon", "Smart Health", "34999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Withings Body Comp Smart Scale", "Smart Health", "16999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Oral-B iO Series 9 Toothbrush", "Smart Health", "22999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Philips Sonicare DiamondClean 9000", "Smart Health", "19999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Dyson Supersonic Hair Dryer", "Smart Health", "34999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Panasonic Arc6 Men's Electric Shaver", "Smart Health", "28999.00");

        // --- Expansion: Travel Gear & Portability ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Osprey Farpoint 40 Travel Pack", "Travel", "13999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Peak Design Travel Backpack 45L", "Travel", "26999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Anker 3-in-1 Cube with MagSafe", "Travel", "12999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "JBL Clip 5 Ultra-Portable Speaker", "Travel", "5999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Graver 20oz Purifying Water Bottle", "Travel", "8999.00");

        // --- Expansion: Streaming & Content Creation ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Elgato Wave:3 USB Microphone", "Streaming", "13999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Logitech Litra Glow Streaming Light", "Streaming", "5499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Rode Wireless PRO Microphone System", "Streaming", "39999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "DJI Mic 2 (2 TX + 1 RX)", "Streaming", "32999.00");

        // --- Expansion: Appliances & Smart Lighting ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Levoit Core 400S Air Purifier", "Appliances", "18999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Govee RGBIC Floor Lamp Pro", "Appliances", "11999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "TP-Link Kasa Smart Light Strip", "Appliances", "3999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Dyson Purifier Cool Gen1", "Appliances", "39999.00");

        // --- Expansion: Kitchen Tech ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Ninja Creami Deluxe Ice Cream Maker", "Kitchen", "24999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Vitamix E310 Explorian Blender", "Kitchen", "32999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "KitchenAid Artisan 5-Quart Mixer", "Kitchen", "48999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Zwilling Enfinigy Electric Kettle", "Kitchen", "9999.00");

        // --- Expansion: PC Hardware & Components ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Intel Core i7-14700K Desktop CPU", "Electronics", "36999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Corsair RM850x Modular Power Supply", "Electronics", "12499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Lian Li PC-O11 Dynamic EVO Case", "Electronics", "15499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Crucial T700 2TB PCIe Gen5 SSD", "Electronics", "26999.00");

        // --- Expansion: Gaming Inputs & Peripherals ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Razer Viper V3 Pro Gaming Mouse", "Gaming", "14999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "HyperX QuadCast S USB Microphone", "Gaming", "13499.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "SteelSeries Arena 7 Gaming Speakers", "Gaming", "27999.00");

        // --- Expansion: Furniture & Workstation Decor ---
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Herman Miller Sayl Task Chair", "Furniture", "78999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "BenQ WiT e-Reading LED Desk Lamp", "Furniture", "16999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Desky Dual Hardwood Standing Desk", "Furniture", "68999.00");
        createOrUpdateRecord(productRepo, categoryRepo, mappingRepo, "Ergonomic Adjustable Footrest Mat", "Furniture", "2999.00");
    }


    private void createOrUpdateRecord(
            ProductRepository productRepo,
            CategoryRepository categoryRepo,
            ProductCategoryRepository mappingRepo,
            String productName,
            String categoryName,
            String price
    ) {
        // 1. Fetch or create the Category
        Category category = categoryRepo.findByName(categoryName)
                .orElseGet(() -> {
                    Category newCat = new Category();
                    newCat.setName(categoryName);
                    return categoryRepo.save(newCat);
                });

        // 2. Fetch or create the Product
        Product product = productRepo.findByName(productName)
                .orElseGet(Product::new);

        product.setName(productName);
        product.setPrice(new BigDecimal(price));
        product = productRepo.save(product);

        // 3. Setup or update the structural mapping record
        ProductCategory mapping = mappingRepo.findByProduct(product)
                .orElseGet(ProductCategory::new);

        mapping.setProduct(product);
        mapping.setCategory(category);
        mappingRepo.save(mapping);
    }
}
