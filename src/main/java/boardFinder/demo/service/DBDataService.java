package boardFinder.demo.service;

import boardFinder.demo.domain.Bend;
import boardFinder.demo.domain.Brand;
import boardFinder.demo.domain.Core;
import boardFinder.demo.domain.Flex;
import boardFinder.demo.domain.Gender;
import boardFinder.demo.domain.RiderLevel;
import boardFinder.demo.domain.RidingTerrain;
import boardFinder.demo.domain.Shape;
import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.domain.SnowboardSizeSpecs;
import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.domain.Terrain;
import boardFinder.demo.repository.BendRepository;
import boardFinder.demo.repository.BrandRepository;
import boardFinder.demo.repository.CoreRepository;
import boardFinder.demo.repository.FlexRepository;
import boardFinder.demo.repository.GenderRepository;
import boardFinder.demo.repository.RiderLevelRepository;
import boardFinder.demo.repository.ShapeRepository;
import boardFinder.demo.repository.ShoeSizeRepository;
import boardFinder.demo.repository.SnowboardRepository;
import boardFinder.demo.repository.SnowboardSizeSpecsRepository;
import boardFinder.demo.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import boardFinder.demo.repository.RidingTerrainRepository;

/**
 *
 * @author Erik
 */
@Service
public class DBDataService {

    private BendRepository bendRepository;
    private BrandRepository brandRepository;
    private CoreRepository coreRepository;
    private GenderRepository genderRepository;
    private RiderLevelRepository riderLevelRepository;
    private RidingTerrainRepository ridingTypeRepository;
    private ShapeRepository shapeRepository;
    private ShoeSizeRepository shoeSizeRepository;
    private SnowboardRepository snowboardRepository;
    private SnowboardSizeSpecsRepository snowboardSizeSpecsRepository;
    private TerrainRepository terrainRepository;
    private FlexRepository flexRepository;

    @Autowired
    public DBDataService(BendRepository bendRepository, BrandRepository brandRepository, CoreRepository coreRepository, GenderRepository genderRepository, RiderLevelRepository riderLevelRepository, RidingTerrainRepository ridingTypeRepository, ShapeRepository shapeRepository, ShoeSizeRepository shoeSizeRepository, SnowboardRepository snowboardRepository, SnowboardSizeSpecsRepository snowboardSizeSpecsRepository, TerrainRepository terrainRepository, FlexRepository flexRepository) {
        this.bendRepository = bendRepository;
        this.brandRepository = brandRepository;
        this.coreRepository = coreRepository;
        this.genderRepository = genderRepository;
        this.riderLevelRepository = riderLevelRepository;
        this.ridingTypeRepository = ridingTypeRepository;
        this.shapeRepository = shapeRepository;
        this.shoeSizeRepository = shoeSizeRepository;
        this.snowboardRepository = snowboardRepository;
        this.snowboardSizeSpecsRepository = snowboardSizeSpecsRepository;
        this.terrainRepository = terrainRepository;
        this.flexRepository = flexRepository;
    }

    public void createTestData() {
        if (snowboardRepository.findAll().isEmpty()) {

            //Brands
            Brand brand1 = new Brand("Burton");

            brandRepository.save(brand1);

            //Bends
            Bend camber = new Bend("Camber", "An advocate of powerful turns and poppy precision, camber speaks to the core values of board design. Offering a snappy suspension, camber distributes weight evenly over the entire length of the board for smooth, continuous edge control from tip to tail. .", "benddetail-camber.svg");
            Bend flatTop = new Bend("Flat Top", "These boards run perfectly flat for the running length of the board, with a few millimeters of early rise rocker in the tip and tail. This shape is the perfect blend of the stability and precision camber offers, as well as the catch-free and playful personality of rocker. With no camber to press out of the board, turning takes very little energy to initiate. Flat boards perform well in all conditions, from powder conditions to hard-packed and groomers. It is great board shape for any rider.", "benddetail-flat-top.svg");
            Bend purePopCamber = new Bend("Pure-Pop Camber", "We call this “Diet Camber” featuring about 70% of the camber profile length that a typical camber board has. The camber zone ends just outside each channel, and a flat zone continues for a few centimeters of length until the board transitions into a small amount of early rise near the nose and tail.  This board bend lies somewhere between the playful flat bend and the precise camber bend. It also offers increased pop as the flat zones before the nose and tail kicks provide additional load and rebound.", "benddetail-purepop.svg");
            Bend flyingV = new Bend("Flying V / Camber/Rocker", "This bend is a hybrid of both camber and rocker, where rocker is the opposite curvature of camber. It has camber underneath both feet and rocker in between the feet, as well as outside the feet. The nose and the tail are lifted off of the snow which makes for a super-playful, floaty ride by reducing the ability to catch your edge and allowing the board to plane better in deep snow. The camber underfoot gives you edge control and pop where you want it, without sacrificing that playfulness where you need it. Flying V can make a board feel softer than its Camber counterpart. For example the Process Flying V vs. Process Camber; Flying V will feel softer even though they have the same materials. Geared towards beginner to intermediate and freestyle riders but provides a versatile platform for progression and exploration.", "benddetail-flying-v.svg");
            Bend directionalCamber = new Bend("Directional Camber", "This board bend has entry rocker that adds lift to the nose while a camber section under both feet maintains momentum and stability through deep-driving turns and variable conditions. This bend caters to those who like the attributes of traditional camber but want something that will get up to speed and float easier in powder.", "benddetail-directional-camber.svg");
            Bend directionalFlatTop = new Bend("Directional Flat Top", "This features a longer entry rocker in the nose that transitions into a flat section just before your front foot for the remainder of the board. This will be the most powder specific board bend as it promotes lift and float for deeper days while not lacking stability and control.", "benddetail-directional-flat-top.svg");

            bendRepository.save(camber);
            bendRepository.save(flatTop);
            bendRepository.save(purePopCamber);
            bendRepository.save(flyingV);
            bendRepository.save(directionalCamber);
            bendRepository.save(directionalFlatTop);

            //Shapes
            Shape allMountainDirectionalShape = new Shape("All Mountain Directional Shape", "The classic snowboard shape, designed to be ridden with a slightly longer nose than tail to concentrate pop in the tail while still giving you plenty of float, flow, and control to rip any terrain or condition.", "shape-directional.svg");
            Shape twinShape = new Shape("Twin Shape", "Perfectly symmetrical for a balanced ride that’s equally versatile when ridden regular or switch. Jib, spin, stomp, and butter with a greater balance of freestyle mobility and cat-like stability no matter which way you point it.", "shape-twin.svg");
            Shape shape3 = new Shape("Directional Twin", "", ""); //Not in use
            Shape freerideDirectionalShape = new Shape("Freeride Directional Shape", "Twin or directional is the age-old question for creative rippers like Terje. Balanced Freeride Geometry ends the debate with setback camber and a sidecut that is centered on your stance to create a twin freestyle feel when riding flat base. On edge it turns tight and quick with the float and prowess expected from a directional deck.", "shape-bfg.svg");

            shapeRepository.save(allMountainDirectionalShape);
            shapeRepository.save(twinShape);
            //shapeRepository.save(shape3);
            shapeRepository.save(freerideDirectionalShape);

            //Flexes
            Flex directionalFlex = new Flex("Directional Flex", "This flex features increased pop in the tail and a more resilient nose that allows riders to easily maintain control through all terrain and conditions.", "flex-directional.svg");
            Flex twinFlex = new Flex("Twin Flex", "The flex is perfectly symmetrical from tip to tail for a balanced ride that’s equally versatile regular or switch.", "flex-twin.svg");

            flexRepository.save(directionalFlex);
            flexRepository.save(twinFlex);

            //Gender
            Gender female = new Gender("Female");
            Gender male = new Gender("Male");

            genderRepository.save(female);
            genderRepository.save(male);

            //RiderLevel
            RiderLevel beginner = new RiderLevel("Beginner", "I'm doing my best in the kids area.");
            RiderLevel intermediate = new RiderLevel("Intermediate", "I ride well in slopes and the park, doing jumps and so.");
            RiderLevel pro = new RiderLevel("Expert", "I can beat Shaun White!");

            riderLevelRepository.save(beginner);
            riderLevelRepository.save(intermediate);
            //riderLevelRepository.save(good);
            riderLevelRepository.save(pro);

            //RidingTypes
            RidingTerrain allMountain = new RidingTerrain("All Mountain");
            RidingTerrain park = new RidingTerrain("Park");
            RidingTerrain powder = new RidingTerrain("Powder");

            ridingTypeRepository.save(allMountain);
            ridingTypeRepository.save(park);
            ridingTypeRepository.save(powder);

            //ShoeSize - not needed for boards but for filtering
            // euSize, jpSize, ukSize, usMensSize, usWomensSize;
            /*
              //Womens sizes
            ShoeSize ss1 = new ShoeSize(32, 19, 0, 0.5, 2);
            ShoeSize ss2 = new ShoeSize(32.5, 19.5, 0.5, 1, 2.5); //
            ShoeSize ss3 = new ShoeSize(33, 20, 1, 1.5, 3);
            ShoeSize ss4 = new ShoeSize(33.5, 20.5, 1.5, 2, 3.5);
            ShoeSize ss5 = new ShoeSize(34, 21, 2, 2.5, 4);
            ShoeSize ss6 = new ShoeSize(34.5, 21.5, 2.5, 3, 4.5);
            ShoeSize ss7 = new ShoeSize(35, 22, 3, 3.5, 5);
            ShoeSize ss8 = new ShoeSize(35.5, 22.5, 3.5, 4, 5.5);
           //ShoeSize ss9 = new ShoeSize(36, 23, 4, 4.5, 6);
            ShoeSize ss10 = new ShoeSize(36.5, 23, 4, 4.5, 6);
            ShoeSize ss11 = new ShoeSize(37, 23.5, 4.5, 5, 6.5);
            ShoeSize ss12 = new ShoeSize(37.5, 24, 5, 5.5, 7);
            ShoeSize ss13 = new ShoeSize(38, 24.5, 5.5, 6, 7.5);
            ShoeSize ss14 = new ShoeSize(39, 25, 6, 6.5, 8);
             */
            // euSize, jpSize, ukSize, usMensSize, usWomensSize
            ShoeSize ss15 = new ShoeSize(39.5, 25.5, 6.5, 7, 8.5, 238, 244, 242);
            ShoeSize ss16 = new ShoeSize(40, 26, 7, 7.5, 9, 240, 246, 243);
            ShoeSize ss17 = new ShoeSize(40.5, 26.5, 7.5, 8, 9.5, 242, 248, 245);
            ShoeSize ss18 = new ShoeSize(41, 27, 8, 8.5, 10, 244, 250, 247);
            ShoeSize ss19 = new ShoeSize(42, 27.5, 8.5, 9, 10.5, 246, 252, 249);
            ShoeSize ss20 = new ShoeSize(42.5, 28, 9, 9.5, 11, 247, 253, 250);
            ShoeSize ss21 = new ShoeSize(43, 28.5, 9.5, 10, 11.5, 249, 255, 252);
            ShoeSize ss22 = new ShoeSize(44, 29, 10, 10.5, 12, 252, 258, 255);
            ShoeSize ss23 = new ShoeSize(44.5, 29.5, 10.5, 11, 12.5, 254, 260, 257);
            ShoeSize ss24 = new ShoeSize(45.5, 30, 11, 11.5, 13, 257, 263, 260);
            ShoeSize ss25 = new ShoeSize(46, 30.5, 11.5, 12, 13.5, 260, 266, 263);
            ShoeSize ss26 = new ShoeSize(46.5, 31, 12, 12.5, 14, 262, 268, 265);
            ShoeSize ss27 = new ShoeSize(47, 31.5, 12.5, 13, 14.5, 265, 271, 268);
            ShoeSize ss28 = new ShoeSize(47.5, 32, 13, 13.5, 15, 268, 274, 271);
            ShoeSize ss29 = new ShoeSize(48.5, 32.5, 13.5, 14, 15.5, 270, 276, 273);
            ShoeSize ss30 = new ShoeSize(49, 33, 14, 14.5, 16, 272, 278, 275);
            ShoeSize ss31 = new ShoeSize(49.5, 33.5, 14.5, 15, 16.5, 275, 280, 277);
            ShoeSize ss32 = new ShoeSize(50, 34, 15, 15.5, 17, 277, 283, 279);

            /*
            shoeSizeRepository.save(ss1);
            shoeSizeRepository.save(ss2);
            shoeSizeRepository.save(ss3);
            shoeSizeRepository.save(ss4);
            shoeSizeRepository.save(ss5);
            shoeSizeRepository.save(ss6);
            shoeSizeRepository.save(ss7);
            shoeSizeRepository.save(ss8);
            shoeSizeRepository.save(ss10);
            shoeSizeRepository.save(ss11);
            shoeSizeRepository.save(ss12);
            shoeSizeRepository.save(ss13);
            shoeSizeRepository.save(ss14);
             */
            shoeSizeRepository.save(ss15);
            shoeSizeRepository.save(ss16);
            shoeSizeRepository.save(ss17);
            shoeSizeRepository.save(ss18);
            shoeSizeRepository.save(ss19);
            shoeSizeRepository.save(ss20);
            shoeSizeRepository.save(ss21);
            shoeSizeRepository.save(ss22);
            shoeSizeRepository.save(ss23);
            shoeSizeRepository.save(ss24);
            shoeSizeRepository.save(ss25);
            shoeSizeRepository.save(ss26);
            shoeSizeRepository.save(ss27);
            shoeSizeRepository.save(ss28);
            shoeSizeRepository.save(ss29);
            shoeSizeRepository.save(ss30);
            shoeSizeRepository.save(ss31);
            shoeSizeRepository.save(ss32);

            //Cores
            // String name, String description, String imagePath
            Core fly900G = new Core("FSC™ Certified Fly® 900G Core", "Our classic tip-to-tail wood core, the 900G model utilizes the best of two wood species to lighten the load by 10% without sacrificing flex, pop, or strength.", "core-fsc-certified-fly-900g-core.svg");
            Core superFly800G = new Core("FSC™ Certified Super Fly® 800G Core", "Lightened up and loaded with pop, our dual-species wood core utilizes dual-density vertical laminations of alternating softwood/hardwood to reduce overall weight with no sacrifice in strength or performance.", "core-fsc-certified-super-fly-800g-core-with-dualzone-egd.svg");
            Core superFly2700G = new Core("FSC™ Certified Super Fly II™ 700G Core", "Stronger and lighter woods target specific areas of the core to provide pop, strength, and reduced weight.", "core-fsc-certified-super-fly-ii-700g-core-with-dualzone-egd.svg");
            Core dragonfly600G = new Core("FSC™ Certified Dragonfly™ 600G Core", "Use of end-grain woods in impact zones allows us to swap heavier woods for lighter weight species without sacrificing strength.", "core-fsc-certified-dragonfly-600g-core-with-multizone-egd.svg");
            Core dragonfly2500G = new Core("FSC™ Certified Dragonfly II™ 500G Core", "Our lightest core ever, the DragonFly II™ integrates carbon laminations inside the core to provide absolute pop and performance with far less material.", "core-fsc-certified-dragonfly-ii-500g-core.svg");

            coreRepository.save(fly900G);
            coreRepository.save(superFly800G);
            coreRepository.save(superFly2700G);
            coreRepository.save(dragonfly600G);
            coreRepository.save(dragonfly2500G);

            //Snowboards
            // Brand boardBrand, String model, Gender boardGender, double stanceSetBack, Bend boardBend, Shape boardShape,  Core core, Flex boardFlex, int stiffness, String imagePath, String introDescription, String description
            Snowboard sb1 = new Snowboard(brand1, "TWC Pro", male, -1.25, camber, allMountainDirectionalShape, directionalFlex, superFly2700G, 6, "TWCPro.webp", "Backed by gold, and designed by Shaun White - get the snap, control, and response to propel your skills to the highest level.", "One look under the hood tells you Shaun White's TWC Pro is revved up and ready to perform alchemy on all-terrain. In superpipes and slopestyle courses around the world, and every condition in between, camber delivers the snappy and stable suspension that White's riding demands. Frostbite Edges eat up bulletproof ice, while the WFO base accelerates past the competition. Similar to the Custom but with a more responsive shape, the TWC Pro is the logical next step for riders ready to upgrade their game.");

            //Specs (String boardLength, int riderWeightMin, int riderWeightMax, String bindingSize, double effectiveLength, double runningLength, double sidcutRadius, int waistWidth, double stanceWidth
            SnowboardSizeSpecs twc156 = new SnowboardSizeSpecs("156", 62, 79, "M", 120.2, 120.2, 7.9, 246, 52);
            snowboardSizeSpecsRepository.save(twc156);
            Terrain twc156t1 = new Terrain(park, 10);
            Terrain twc156t2 = new Terrain(allMountain, 8);
            Terrain twc156t3 = new Terrain(powder, 4);

            terrainRepository.save(twc156t1);
            terrainRepository.save(twc156t2);
            terrainRepository.save(twc156t3);

            sb1.getBoardSizeSpecs().add(twc156);

            sb1.getRidingterrains().add(twc156t1);
            sb1.getRidingterrains().add(twc156t2);
            sb1.getRidingterrains().add(twc156t3);

            sb1.getRiderLevels().add(pro);
            sb1.getRiderLevels().add(intermediate);

            // Brand boardBrand, String model, Gender boardGender, double stanceSetBack, Bend boardBend, Shape boardShape,  Core core, Flex boardFlex, int stiffness, String imagePath, String introDescription, String description
            Snowboard sb2 = new Snowboard(brand1, "Kilroy Custom", male, 0, camber, allMountainDirectionalShape, twinFlex, superFly800G, 5, "Kilroy_Custom.webp", "A twisted evolution of the most trusted board in the game.", "Built for riding any and all terrain, the Burton Kilroy Custom takes the attitude and approach of the most trusted board ever and gives it a new unique shape and construction. Better yet, it’s a board that can be thrashed without worries thanks to a recipe that’s high-performance without the price.");
            SnowboardSizeSpecs kilroyCustom154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs kilroyCustom158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            snowboardSizeSpecsRepository.save(kilroyCustom154);
            snowboardSizeSpecsRepository.save(kilroyCustom158);

            sb2.getBoardSizeSpecs().add(kilroyCustom154);
            sb2.getBoardSizeSpecs().add(kilroyCustom158);

            Terrain kilroyCustomt1 = new Terrain(park, 10);
            Terrain kilroyCustomt2 = new Terrain(allMountain, 7);
            Terrain kilroyCustomt3 = new Terrain(powder, 3);

            terrainRepository.save(kilroyCustomt1);
            terrainRepository.save(kilroyCustomt2);
            terrainRepository.save(kilroyCustomt3);

            sb2.getRidingterrains().add(kilroyCustomt1);
            sb2.getRidingterrains().add(kilroyCustomt2);
            sb2.getRidingterrains().add(kilroyCustomt3);

            sb2.getRiderLevels().add(pro);
            sb2.getRiderLevels().add(intermediate);

            Snowboard sb3 = new Snowboard(brand1, "Instigator", male, -2.5, flatTop, allMountainDirectionalShape, twinFlex, superFly800G, 2, "Instigator.webp", "Shortcut the learning curve with an all-around board that’s catch-free and easy for boosting confidence anywhere you take it.", "Some riders just want to get straight to the fun part. Enjoy a no-fuss feel with the Burton Instigator, a board designed to help accelerate the learning curve and instigate a good time from your first moment on the mountain. The combination of a Flat Top™ bend and convex base keeps things friendly underfoot, creating a catch-free feel that maintains stability and control. The Channel® mounting system gives you the easiest, most adjustable setup with bindings from all major brands (not just Burton’s).");
            SnowboardSizeSpecs instigator140 = new SnowboardSizeSpecs("140", 36, 51, "S", 103.0, 95.0, 6.2, 242, 48);
            SnowboardSizeSpecs instigator145 = new SnowboardSizeSpecs("145", 45, 68, "S/M", 107.5, 99.5, 6.5, 245, 50.5);
            SnowboardSizeSpecs instigator150 = new SnowboardSizeSpecs("150", 54, 82, "M", 112.0, 104.0, 6.8, 248, 53);
            SnowboardSizeSpecs instigator155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 117, 109, 7.1, 252, 56);
            SnowboardSizeSpecs instigator160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122, 114, 7.4, 256, 56);
            SnowboardSizeSpecs instigator150W = new SnowboardSizeSpecs("150W", 54, 82, "L", 112.0, 104.0, 6.8, 256, 56);
            SnowboardSizeSpecs instigator155W = new SnowboardSizeSpecs("155W", 54, 82, "L", 117, 109, 7.1, 260, 56);
            SnowboardSizeSpecs instigator160W = new SnowboardSizeSpecs("160W", 82, 120, "L", 122, 114, 7.4, 265, 56);
            SnowboardSizeSpecs instigator165W = new SnowboardSizeSpecs("165W", 82, 120, "L", 127, 119, 7.8, 270, 56);
            snowboardSizeSpecsRepository.save(instigator140);
            snowboardSizeSpecsRepository.save(instigator145);
            snowboardSizeSpecsRepository.save(instigator150);
            snowboardSizeSpecsRepository.save(instigator155);
            snowboardSizeSpecsRepository.save(instigator160);
            snowboardSizeSpecsRepository.save(instigator150W);
            snowboardSizeSpecsRepository.save(instigator155W);
            snowboardSizeSpecsRepository.save(instigator160W);
            snowboardSizeSpecsRepository.save(instigator165W);

            sb3.getBoardSizeSpecs().add(instigator140);
            sb3.getBoardSizeSpecs().add(instigator145);
            sb3.getBoardSizeSpecs().add(instigator150);
            sb3.getBoardSizeSpecs().add(instigator155);
            sb3.getBoardSizeSpecs().add(instigator160);
            sb3.getBoardSizeSpecs().add(instigator150W);
            sb3.getBoardSizeSpecs().add(instigator155W);
            sb3.getBoardSizeSpecs().add(instigator160W);
            sb3.getBoardSizeSpecs().add(instigator165W);

            Terrain instigatort1 = new Terrain(allMountain, 9);
            Terrain instigatort2 = new Terrain(powder, 4);
            Terrain instigatort3 = new Terrain(park, 4);

            terrainRepository.save(instigatort1);
            terrainRepository.save(instigatort2);
            terrainRepository.save(instigatort3);

            sb3.getRidingterrains().add(instigatort1);
            sb3.getRidingterrains().add(instigatort2);
            sb3.getRidingterrains().add(instigatort3);

            sb3.getRiderLevels().add(beginner);

            // Brand boardBrand, String model, Gender boardGender, double stanceSetBack, Bend boardBend, Shape boardShape,  Core core, Flex boardFlex, int stiffness, String imagePath, String introDescription, String description
            Snowboard sb4 = new Snowboard(brand1, "Process", male, -1.25, camber, twinShape, twinFlex, superFly2700G, 3, "Process.webp", "Lightweight true twin performance tuned to the ride-everything style of top pros like Mark McMorris.", "Constantly evolved to drop ounces and amplify pop, the Burton Process is Mark McMorris’ pick for its twin freestyle playfulness and all-terrain prowess. Now featuring PurePop camber for a forgiving yet snappy feel, the Process is suited to the freestyle rider, but still capable of ripping the entire mountain as proven by the pros who push it. The FSC™ Certified Super Fly II core creates a lighter, lift-off-ready deck, while Squeezebox core profiling transfers energy towards the tip and tail for snappier ollies and effortless stability. Available in two versions, choose the relaxed and floaty Flying V™ or precise control of PurePop camber.");
            SnowboardSizeSpecs process152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 116.5, 112.5, 7.7, 249, 48);
            SnowboardSizeSpecs process155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 119.5, 115.5, 7.9, 251, 53);
            SnowboardSizeSpecs process157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 121.5, 117.5, 8.1, 252, 56);
            SnowboardSizeSpecs process159 = new SnowboardSizeSpecs("159", 68, 91, "L", 123.5, 119.5, 8.2, 255, 56);
            SnowboardSizeSpecs process162 = new SnowboardSizeSpecs("162", 82, 120, "L", 126.5, 122.5, 8.4, 257, 56);
            snowboardSizeSpecsRepository.save(process152);
            snowboardSizeSpecsRepository.save(process155);
            snowboardSizeSpecsRepository.save(process157);
            snowboardSizeSpecsRepository.save(process159);
            snowboardSizeSpecsRepository.save(process162);

            sb4.getBoardSizeSpecs().add(process152);
            sb4.getBoardSizeSpecs().add(process155);
            sb4.getBoardSizeSpecs().add(process157);
            sb4.getBoardSizeSpecs().add(process159);
            sb4.getBoardSizeSpecs().add(process162);

            Terrain processt1 = new Terrain(allMountain, 10);
            Terrain processt2 = new Terrain(powder, 6);
            Terrain processt3 = new Terrain(park, 5);

            terrainRepository.save(processt1);
            terrainRepository.save(processt2);
            terrainRepository.save(processt3);

            sb4.getRidingterrains().add(processt1);
            sb4.getRidingterrains().add(processt2);
            sb4.getRidingterrains().add(processt3);

            sb4.getRiderLevels().add(intermediate);

            Snowboard sb5 = new Snowboard(brand1, "Process Flying V", male, -1.25, flyingV, twinShape, twinFlex, superFly2700G, 2, "Process_Flying_V.webp", "Lightweight true twin performance tuned to the ride-everything style of top pros like Mark McMorris.", "Constantly evolved to drop ounces and amplify pop, the Burton Process is Mark McMorris’ pick for its twin freestyle playfulness and all-terrain prowess. The FSC™ Certified Super Fly II core creates a lighter, lift-off-ready deck, while Squeezebox core profiling transfers energy towards the tip and tail for snappier ollies and effortless stability. Available in two versions, choose the relaxed and floaty Flying V or precise control of PurePop camber. Process is suited to the freestyle rider, but still capable of ripping the entire mountain as proven by the pros who push it.");
            SnowboardSizeSpecs processFV152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 116.5, 112.5, 7.7, 249, 48);
            SnowboardSizeSpecs processFV155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 119.5, 115.5, 7.9, 251, 53);
            SnowboardSizeSpecs processFV157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 121.5, 117.5, 8.1, 252, 56);
            SnowboardSizeSpecs processFV159 = new SnowboardSizeSpecs("159", 68, 91, "L", 123.5, 119.5, 8.3, 255, 56);
            SnowboardSizeSpecs processFV162 = new SnowboardSizeSpecs("162", 82, 120, "L", 126.5, 122.5, 8.4, 257, 56);
            SnowboardSizeSpecs processFV157W = new SnowboardSizeSpecs("157W", 68, 91, "L", 121.5, 117.5, 8.1, 257, 56);
            SnowboardSizeSpecs processFV159W = new SnowboardSizeSpecs("159W", 68, 91, "L", 123.5, 119.5, 8.3, 260, 56);
            SnowboardSizeSpecs processFV162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 126.5, 122.5, 8.4, 262, 56);

            snowboardSizeSpecsRepository.save(processFV152);
            snowboardSizeSpecsRepository.save(processFV155);
            snowboardSizeSpecsRepository.save(processFV157);
            snowboardSizeSpecsRepository.save(processFV159);
            snowboardSizeSpecsRepository.save(processFV162);
            snowboardSizeSpecsRepository.save(processFV157W);
            snowboardSizeSpecsRepository.save(processFV159W);
            snowboardSizeSpecsRepository.save(processFV162W);

            sb5.getBoardSizeSpecs().add(processFV152);
            sb5.getBoardSizeSpecs().add(processFV155);
            sb5.getBoardSizeSpecs().add(processFV157);
            sb5.getBoardSizeSpecs().add(processFV159);
            sb5.getBoardSizeSpecs().add(processFV162);
            sb5.getBoardSizeSpecs().add(processFV157W);
            sb5.getBoardSizeSpecs().add(processFV159W);
            sb5.getBoardSizeSpecs().add(processFV162W);

            Terrain processFVt1 = new Terrain(allMountain, 10);
            Terrain processFVt2 = new Terrain(powder, 6);
            Terrain processFVt3 = new Terrain(park, 4);

            terrainRepository.save(processFVt1);
            terrainRepository.save(processFVt2);
            terrainRepository.save(processFVt3);

            sb5.getRidingterrains().add(processFVt1);
            sb5.getRidingterrains().add(processFVt2);
            sb5.getRidingterrains().add(processFVt3);

            sb5.getRiderLevels().add(intermediate);

            Snowboard sb6 = new Snowboard(brand1, "Family Tree Speed Date", male, -2.5, camber, freerideDirectionalShape, directionalFlex, dragonfly600G, 8, "Family_Tree_Speed_Date .webp", "Go hard in the trench on the Family Tree’s fastest new addition, inspired by snowboarding’s signature event: the banked slalom.", "Our designers called it “the banked slalom board” from day one, so you know it’s built to turn. The Speed Date features a special blend of Balanced Freeride Geometry that thrives on all terrain. Directional Camber combines with a unique shape, aggressive sidecut and just the right amount of taper to burn turns and eat berms for breakfast.");
            SnowboardSizeSpecs familyTreeSpeedDate151 = new SnowboardSizeSpecs("151", 54, 82, "S/M", 114.5, 110.0, 7.2, 246, 53);
            SnowboardSizeSpecs familyTreeSpeedDate156 = new SnowboardSizeSpecs("156", 68, 91, "M", 119.5, 115, 8.1, 248, 56);
            SnowboardSizeSpecs familyTreeSpeedDate161 = new SnowboardSizeSpecs("161", 82, 120, "M/L", 124.5, 120.0, 8.1, 252, 56);

            snowboardSizeSpecsRepository.save(familyTreeSpeedDate151);
            snowboardSizeSpecsRepository.save(familyTreeSpeedDate156);
            snowboardSizeSpecsRepository.save(familyTreeSpeedDate161);

            sb6.getBoardSizeSpecs().add(familyTreeSpeedDate151);
            sb6.getBoardSizeSpecs().add(familyTreeSpeedDate156);
            sb6.getBoardSizeSpecs().add(familyTreeSpeedDate161);

            Terrain familyTreeSpeedDatet1 = new Terrain(powder, 8);
            Terrain familyTreeSpeedDatet2 = new Terrain(allMountain, 9);
            Terrain familyTreeSpeedDatet3 = new Terrain(park, 4);

            terrainRepository.save(familyTreeSpeedDatet1);
            terrainRepository.save(familyTreeSpeedDatet2);
            terrainRepository.save(familyTreeSpeedDatet3);

            sb6.getRidingterrains().add(familyTreeSpeedDatet1);
            sb6.getRidingterrains().add(familyTreeSpeedDatet2);
            sb6.getRidingterrains().add(familyTreeSpeedDatet3);

            sb6.getRiderLevels().add(intermediate);
            sb6.getRiderLevels().add(pro);

            Snowboard sb7 = new Snowboard(brand1, "Family Tree Speed Date Wide", male, -2.5, camber, freerideDirectionalShape, directionalFlex, dragonfly600G, 8, "Family_Tree_Speed_Date .webp", "Go hard in the trench on the Family Tree’s fastest new addition, inspired by snowboarding’s signature event: the banked slalom.", "Our designers called it “the banked slalom board” from day one, so you know it’s built to turn. The Speed Date features a special blend of Balanced Freeride Geometry that thrives on all terrain. Directional Camber combines with a unique shape, aggressive sidecut and just the right amount of taper to burn turns and eat berms for breakfast.");
            SnowboardSizeSpecs familyTreeSpeedDate156Wide = new SnowboardSizeSpecs("156W", 68, 91, "L", 119.5, 115, 7.5, 256, 56);
            snowboardSizeSpecsRepository.save(familyTreeSpeedDate156Wide);

            sb7.getBoardSizeSpecs().add(familyTreeSpeedDate156Wide);

            Terrain familyTreeSpeedDate156Widet1 = new Terrain(powder, 8);
            Terrain familyTreeSpeedDate156Widet2 = new Terrain(allMountain, 9);
            Terrain familyTreeSpeedDate156Widet3 = new Terrain(park, 4);

            terrainRepository.save(familyTreeSpeedDate156Widet1);
            terrainRepository.save(familyTreeSpeedDate156Widet2);
            terrainRepository.save(familyTreeSpeedDate156Widet3);

            sb7.getRidingterrains().add(familyTreeSpeedDate156Widet1);
            sb7.getRidingterrains().add(familyTreeSpeedDate156Widet2);
            sb7.getRidingterrains().add(familyTreeSpeedDate156Widet3);

            sb7.getRiderLevels().add(intermediate);
            sb7.getRiderLevels().add(pro);

            Snowboard sb8 = new Snowboard(brand1, "Free Thinker", male, 0, camber, twinShape, twinFlex, superFly2700G, 7, "Free_Thinker.webp", "Expand your perspective with Danny Davis’ new take on poppy and pow-friendly ride-anything performance.", "The Burton Free Thinker is a true twin spin on Danny Davis’ go-to, built for hot laps in the park, pipe, or mobbing side hits across the mountain. The unique true twin shape opens up the possibilities for creative expression in any direction, while the control of camber keeps it quick and poppy. 45° Carbon Highlights deliver snap without the stiff side effects. Throwback graphics top it off, adding a touch of Burton’s early 90’s roots to an already iconic model.");
            SnowboardSizeSpecs freeThinker150 = new SnowboardSizeSpecs("150", 54, 82, "S/M", 112.5, 108, 7.0, 246, 53);
            SnowboardSizeSpecs freeThinker154 = new SnowboardSizeSpecs("154", 54, 82, "M", 116.5, 112, 7.3, 248, 53);
            SnowboardSizeSpecs freeThinker157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 119.5, 115, 7.5, 252, 56);
            SnowboardSizeSpecs freeThinker160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122.5, 118, 7.7, 255, 56);
            SnowboardSizeSpecs freeThinker157W = new SnowboardSizeSpecs("157W", 68, 91, "L", 119.5, 115, 7.5, 260, 56);
            SnowboardSizeSpecs freeThinker160W = new SnowboardSizeSpecs("160W", 82, 120, "L", 122.5, 118, 7.7, 263, 56);

            snowboardSizeSpecsRepository.save(freeThinker150);
            snowboardSizeSpecsRepository.save(freeThinker154);
            snowboardSizeSpecsRepository.save(freeThinker157);
            snowboardSizeSpecsRepository.save(freeThinker160);
            snowboardSizeSpecsRepository.save(freeThinker157W);
            snowboardSizeSpecsRepository.save(freeThinker160W);

            sb8.getBoardSizeSpecs().add(freeThinker150);
            sb8.getBoardSizeSpecs().add(freeThinker154);
            sb8.getBoardSizeSpecs().add(freeThinker157);
            sb8.getBoardSizeSpecs().add(freeThinker160);
            sb8.getBoardSizeSpecs().add(freeThinker157W);
            sb8.getBoardSizeSpecs().add(freeThinker160W);

            Terrain freeThinkert1 = new Terrain(park, 7);
            Terrain freeThinkert2 = new Terrain(allMountain, 8);
            Terrain freeThinkert3 = new Terrain(powder, 6);

            terrainRepository.save(freeThinkert1);
            terrainRepository.save(freeThinkert2);
            terrainRepository.save(freeThinkert3);

            sb8.getRidingterrains().add(freeThinkert1);
            sb8.getRidingterrains().add(freeThinkert2);
            sb8.getRidingterrains().add(freeThinkert3);

            sb8.getRiderLevels().add(intermediate);
            sb8.getRiderLevels().add(pro);

            Snowboard sb9 = new Snowboard(brand1, "Paramount", male, 0, camber, twinShape, twinFlex, superFly2700G, 4, "Paramount.webp", "The pinnacle formula for high-caliber park performance: twin tip shape with the pop and raw power of camber.", "Launching to the moon or sliding down a rail, the NEW Burton Paramount is the vehicle that will get you there and back again. The precision and response of Camber combines with a classic twin tip shape for a freestyle formula that’s served riders since the birth of the terrain park. A medium flex provides stability and support for stomped landings, while still ensuring enough wiggle room to crank out a press on boxes, rails, and anything else in your path.");
            SnowboardSizeSpecs paramount152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 115.5, 111, 7.6, 250, 53);
            SnowboardSizeSpecs paramount155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.8, 252, 53);
            SnowboardSizeSpecs paramount158 = new SnowboardSizeSpecs("158", 68, 91, "L", 121.5, 117, 7.5, 255, 56);
            SnowboardSizeSpecs paramount162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 121, 7.5, 258, 56);
            snowboardSizeSpecsRepository.save(paramount152);
            snowboardSizeSpecsRepository.save(paramount155);
            snowboardSizeSpecsRepository.save(paramount158);
            snowboardSizeSpecsRepository.save(paramount162);

            sb9.getBoardSizeSpecs().add(paramount152);
            sb9.getBoardSizeSpecs().add(paramount155);
            sb9.getBoardSizeSpecs().add(paramount158);
            sb9.getBoardSizeSpecs().add(paramount162);

            Terrain paramountt1 = new Terrain(park, 8);
            Terrain paramountt2 = new Terrain(allMountain, 8);
            Terrain paramountt3 = new Terrain(powder, 6);

            terrainRepository.save(paramountt1);
            terrainRepository.save(paramountt2);
            terrainRepository.save(paramountt3);

            sb9.getRidingterrains().add(paramountt1);
            sb9.getRidingterrains().add(paramountt2);
            sb9.getRidingterrains().add(paramountt3);

            sb9.getRiderLevels().add(intermediate);
            sb9.getRiderLevels().add(pro);

            Snowboard sb10 = new Snowboard(brand1, "Custom X", male, -1.25, camber, allMountainDirectionalShape, twinFlex, dragonfly600G, 9, "Custom_X.webp", "Get pro-caliber speed and precision with the most aggressive board in Burton’s lineup.", "Pro-caliber is a strong statement for any board, but the Burton Custom X has repeatedly delivered for snowboarding’s most demanding riders due to precise design and powerful drive. The confidence is in the tech, which includes the carbon-fueled snap of Squeezebox High core profiling, a competition-grade base, and 45° Carbon Highlights High-Voltage for the ultimate in lightweight responsiveness. The hardest charging board we make, the Custom X is available in two versions: choose the power of camber or the float and catch-free feel of Flying V™.");
            SnowboardSizeSpecs customX150 = new SnowboardSizeSpecs("150", 54, 82, "M", 113.5, 108, 7.4, 248, 50.5);
            SnowboardSizeSpecs customX154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs customX156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 119.5, 114.5, 7.8, 252, 53);
            SnowboardSizeSpecs customX158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            SnowboardSizeSpecs customX162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 120.5, 8.2, 256, 56);
            SnowboardSizeSpecs customX158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 121.5, 116.5, 7.9, 262, 56);
            SnowboardSizeSpecs customX162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 125.5, 120.5, 8.2, 264, 56);
            SnowboardSizeSpecs customX166W = new SnowboardSizeSpecs("166W", 82, 120, "L", 129.5, 124.5, 8.4, 266, 56);
            snowboardSizeSpecsRepository.save(customX150);
            snowboardSizeSpecsRepository.save(customX154);
            snowboardSizeSpecsRepository.save(customX156);
            snowboardSizeSpecsRepository.save(customX158);
            snowboardSizeSpecsRepository.save(customX162);
            snowboardSizeSpecsRepository.save(customX158W);
            snowboardSizeSpecsRepository.save(customX162W);
            snowboardSizeSpecsRepository.save(customX166W);

            sb10.getBoardSizeSpecs().add(customX150);
            sb10.getBoardSizeSpecs().add(customX154);
            sb10.getBoardSizeSpecs().add(customX156);
            sb10.getBoardSizeSpecs().add(customX158);
            sb10.getBoardSizeSpecs().add(customX162);
            sb10.getBoardSizeSpecs().add(customX158W);
            sb10.getBoardSizeSpecs().add(customX162W);
            sb10.getBoardSizeSpecs().add(customX166W);

            Terrain customXt1 = new Terrain(allMountain, 9);
            Terrain customXt2 = new Terrain(park, 6);
            Terrain customXt3 = new Terrain(powder, 7);

            terrainRepository.save(customXt1);
            terrainRepository.save(customXt2);
            terrainRepository.save(customXt3);

            sb10.getRidingterrains().add(customXt1);
            sb10.getRidingterrains().add(customXt2);
            sb10.getRidingterrains().add(customXt3);

            sb10.getRiderLevels().add(pro);

            Snowboard sb11 = new Snowboard(brand1, "Custom", male, -1.25, camber, allMountainDirectionalShape, twinFlex, superFly2700G, 6, "Custom.webp", "The most trusted board ever, backed by a cult following as snowboarding’s one-answer to all terrain.", "Since its humble beginnings, innovation has defined the Burton Custom series and set it apart as the most popular, versatile, and mimicked board in snowboarding. Since 1996, this icon has reigned supreme and constantly evolved with a proven formula that combines time-honored design with envelope-pushing ingredients to create a lightweight, poppy, and highly versatile board. Offered in two versions, the precision and stability of the Custom camber is the top choice for many pro riders, while the Custom Flying V™ combines camber’s power with the relaxed float of rocker for the best of both worlds.");
            SnowboardSizeSpecs custom150 = new SnowboardSizeSpecs("150", 54, 82, "M", 113.5, 108.5, 7.4, 248, 50.5);
            SnowboardSizeSpecs custom154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs custom156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 119.5, 114.5, 7.8, 252, 53);
            SnowboardSizeSpecs custom158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            SnowboardSizeSpecs custom162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 120.5, 8.2, 256, 56);
            SnowboardSizeSpecs custom154W = new SnowboardSizeSpecs("154W", 54, 82, "L", 117.5, 112, 7.6, 258, 50.5);
            SnowboardSizeSpecs custom158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 121.5, 116.5, 7.9, 262, 56);
            SnowboardSizeSpecs custom162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 125.5, 120.5, 8.2, 264, 56);
            SnowboardSizeSpecs custom166W = new SnowboardSizeSpecs("166W", 82, 120, "L", 129.5, 124.5, 8.4, 266, 56);
            SnowboardSizeSpecs custom170W = new SnowboardSizeSpecs("170W", 82, 120, "L", 133.5, 128.5, 8.7, 270, 56);
            snowboardSizeSpecsRepository.save(custom150);
            snowboardSizeSpecsRepository.save(custom154);
            snowboardSizeSpecsRepository.save(custom156);
            snowboardSizeSpecsRepository.save(custom158);
            snowboardSizeSpecsRepository.save(custom162);
            snowboardSizeSpecsRepository.save(custom154W);
            snowboardSizeSpecsRepository.save(custom158W);
            snowboardSizeSpecsRepository.save(custom162W);
            snowboardSizeSpecsRepository.save(custom166W);
            snowboardSizeSpecsRepository.save(custom170W);

            sb11.getBoardSizeSpecs().add(custom150);
            sb11.getBoardSizeSpecs().add(custom154);
            sb11.getBoardSizeSpecs().add(custom156);
            sb11.getBoardSizeSpecs().add(custom158);
            sb11.getBoardSizeSpecs().add(custom162);
            sb11.getBoardSizeSpecs().add(custom154W);
            sb11.getBoardSizeSpecs().add(custom158W);
            sb11.getBoardSizeSpecs().add(custom162W);
            sb11.getBoardSizeSpecs().add(custom166W);
            sb11.getBoardSizeSpecs().add(custom170W);

            Terrain customt1 = new Terrain(allMountain, 10);
            Terrain customt2 = new Terrain(park, 6);
            Terrain customt3 = new Terrain(powder, 6);

            terrainRepository.save(customt1);
            terrainRepository.save(customt2);
            terrainRepository.save(customt3);

            sb11.getRidingterrains().add(customt1);
            sb11.getRidingterrains().add(customt2);
            sb11.getRidingterrains().add(customt3);

            sb11.getRiderLevels().add(intermediate);
            sb11.getRiderLevels().add(pro);

            Snowboard sb12 = new Snowboard(brand1, "Kilroy", male, -1.25, directionalCamber, allMountainDirectionalShape, twinFlex, superFly800G, 5, "Kilroy.webp", "A twisted evolution of the most trusted board in the game.", "Built for riding any and all terrain, the Men's Burton Kilroy Directional Camber Snowboard takes the attitude and approach of the most trusted board ever and gives it a new unique shape and construction. Better yet, it's a board that can be thrashed without worries thanks to a recipe that's high-performance without the price.");
            SnowboardSizeSpecs kilroy154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs kilroy158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.2, 116.5, 7.9, 254, 56);
            snowboardSizeSpecsRepository.save(kilroy154);
            snowboardSizeSpecsRepository.save(kilroy158);
            sb12.getBoardSizeSpecs().add(kilroy154);
            sb12.getBoardSizeSpecs().add(kilroy158);

            Terrain kilroyt1 = new Terrain(park, 10);
            Terrain kilroyt2 = new Terrain(allMountain, 7);
            Terrain kilroyt3 = new Terrain(powder, 3);

            terrainRepository.save(kilroyt1);
            terrainRepository.save(kilroyt2);
            terrainRepository.save(kilroyt3);

            sb12.getRidingterrains().add(kilroyt1);
            sb12.getRidingterrains().add(kilroyt2);
            sb12.getRidingterrains().add(kilroyt3);

            sb12.getRiderLevels().add(intermediate);
            sb12.getRiderLevels().add(pro);

            Snowboard sb13 = new Snowboard(brand1, "Family Tree Hometown Hero", male, -4, flyingV, freerideDirectionalShape, twinFlex, superFly2700G, 6, "Family_Tree_Hometown.webp", "Designed to thrive in Burton's back yard, this chunder buster loves to go fast, blast, and dodge through the tightest trees.", "Our board designers spend a lot of time poking around in the woods of Vermont, our home state. Tight trees, steep lines, and sudden drops are to be expected, and the Burton Hometown Hero is custom tailored to power through it all. Blast past the tourists and cut straight to the goods. Strategically placed glass stiffens up the nose and tail, allowing the center to flex while retaining snap and response where you need it most. Directional Camber blends with Balanced Freeride Geometry to maintain stability, while an FSC™ Certified Super Fly II™ core pairs with bio-based Super Sap® Epoxy for a low carbon footprint.");
            SnowboardSizeSpecs familyTreeHomeTownHero152 = new SnowboardSizeSpecs("152", 54, 82, "M", 113.7, 108, 7.2, 248, 53);
            SnowboardSizeSpecs familyTreeHomeTownHero156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 117.7, 112, 7.4, 252, 56);
            SnowboardSizeSpecs familyTreeHomeTownHero160 = new SnowboardSizeSpecs("160", 82, 120, "L", 121.7, 116, 7.7, 258, 56);
            snowboardSizeSpecsRepository.save(familyTreeHomeTownHero152);
            snowboardSizeSpecsRepository.save(familyTreeHomeTownHero156);
            snowboardSizeSpecsRepository.save(familyTreeHomeTownHero160);
            sb13.getBoardSizeSpecs().add(familyTreeHomeTownHero152);
            sb13.getBoardSizeSpecs().add(familyTreeHomeTownHero156);
            sb13.getBoardSizeSpecs().add(familyTreeHomeTownHero160);

            Terrain familyTreeHomeTownHerot1 = new Terrain(powder, 8);
            Terrain familyTreeHomeTownHerot2 = new Terrain(allMountain, 7);
            Terrain familyTreeHomeTownHerot3 = new Terrain(park, 3);

            terrainRepository.save(familyTreeHomeTownHerot1);
            terrainRepository.save(familyTreeHomeTownHerot2);
            terrainRepository.save(familyTreeHomeTownHerot3);

            sb13.getRidingterrains().add(familyTreeHomeTownHerot1);
            sb13.getRidingterrains().add(familyTreeHomeTownHerot2);
            sb13.getRidingterrains().add(familyTreeHomeTownHerot3);

            sb13.getRiderLevels().add(intermediate);
            sb13.getRiderLevels().add(pro);

            Snowboard sb14 = new Snowboard(brand1, "Kilroy Twin", male, 0, camber, twinShape, twinFlex, superFly800G, 3, "Kilroy_Twin.jfif", "The workingman's classic: a traditional camber twin, designed to thrive on all terrain.", "The rippers on ground level are looking for a board that can hang without worrying about the cost. The Men's Burton Kilroy Twin Camber Snowboard is here to give the people what they want with a classic twin shape inspired by the Process, but with a refined construction that focuses on strength, speed, and pop.");
            SnowboardSizeSpecs kilroyTwin148 = new SnowboardSizeSpecs("148", 45, 68, "M", 111.5, 107, 7.3, 248, 53);
            SnowboardSizeSpecs kilroyTwin152 = new SnowboardSizeSpecs("152", 54, 82, "M/L", 115.5, 111, 7.6, 250, 53);
            SnowboardSizeSpecs kilroyTwin155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.8, 252, 56);
            SnowboardSizeSpecs kilroyTwin159 = new SnowboardSizeSpecs("159", 68, 91, "L", 122.5, 118, 8.1, 255, 56);
            snowboardSizeSpecsRepository.save(kilroyTwin148);
            snowboardSizeSpecsRepository.save(kilroyTwin152);
            snowboardSizeSpecsRepository.save(kilroyTwin155);
            snowboardSizeSpecsRepository.save(kilroyTwin159);

            sb14.getBoardSizeSpecs().add(kilroyTwin148);
            sb14.getBoardSizeSpecs().add(kilroyTwin152);
            sb14.getBoardSizeSpecs().add(kilroyTwin155);
            sb14.getBoardSizeSpecs().add(kilroyTwin159);

            Terrain kilroyTwint1 = new Terrain(park, 10);
            Terrain kilroyTwint2 = new Terrain(allMountain, 7);
            Terrain kilroyTwint3 = new Terrain(powder, 3);

            terrainRepository.save(kilroyTwint1);
            terrainRepository.save(kilroyTwint2);
            terrainRepository.save(kilroyTwint3);

            sb14.getRidingterrains().add(kilroyTwint1);
            sb14.getRidingterrains().add(kilroyTwint2);
            sb14.getRidingterrains().add(kilroyTwint3);

            sb14.getRiderLevels().add(intermediate);

            Snowboard sb15 = new Snowboard(brand1, "Family Tree Moon Buggy", male, -1.7, directionalCamber, allMountainDirectionalShape, directionalFlex, dragonfly600G, 5, "Family_Tree_Moon_Buggy.webp", "Wider, shorter, surfier, heck, we might as well just say funner in all conditions", "Float in a surf-like state over interstellar landscapes on this playfully plus-sized rig. The Moon Buggy takes a big-kahuna approach to playful pow riding. The spaceship vibes stem from swallow-inspired 3-D construction in the tail, which complements the big nose for effortless float no matter how deep the swell gets.");
            SnowboardSizeSpecs familyTreeMoonBuggy158 = new SnowboardSizeSpecs("158", 68, 91, "L", 113.5, 107, 8.0, 262, 56);
            SnowboardSizeSpecs familyTreeMoonBuggy168 = new SnowboardSizeSpecs("168", 82, 120, "L", 123.5, 117, 8.8, 272, 56);
            snowboardSizeSpecsRepository.save(familyTreeMoonBuggy158);
            snowboardSizeSpecsRepository.save(familyTreeMoonBuggy168);
            sb15.getBoardSizeSpecs().add(familyTreeMoonBuggy158);
            sb15.getBoardSizeSpecs().add(familyTreeMoonBuggy168);

            Terrain familyTreeMoonBuggyt1 = new Terrain(powder, 10);
            Terrain familyTreeMoonBuggyt2 = new Terrain(allMountain, 3);
            Terrain familyTreeMoonBuggyt3 = new Terrain(park, 2);

            terrainRepository.save(familyTreeMoonBuggyt1);
            terrainRepository.save(familyTreeMoonBuggyt2);
            terrainRepository.save(familyTreeMoonBuggyt3);

            sb15.getRidingterrains().add(familyTreeMoonBuggyt1);
            sb15.getRidingterrains().add(familyTreeMoonBuggyt2);
            sb15.getRidingterrains().add(familyTreeMoonBuggyt3);

            sb15.getRiderLevels().add(pro);

            // Snowboard sb12 = new Snowboard(brand1, "Kilroy",  male, -1.25, camber, allMountainDirectionalShape, twinFlex, superFly2700G, 6,  "Kilroy.webp", "", ""); 
            Snowboard sb16 = new Snowboard(brand1, "Deep Thinker", male, -2.5, directionalCamber, allMountainDirectionalShape, directionalFlex, superFly2700G, 6, "Deep_Thinker.jfif", "Open your mind with Danny Davis' new take on extra-poppy, pow-friendly performance.", "The Burton Deep Thinker is a directional spin on Danny Davis' go-to for hot laps in the park, pipe, or mobbing side hits across the mountain. Adding the float and responsiveness of Directional Camber to a unique shape designed with Balanced Freeride Geometry and just a touch of taper ups the all-mountain abilities while keeping the freestyle performance on full blast. 45° Carbon Highlights deliver snappy pop without the stiff side effects. Throwback graphics top it off, adding a touch of Burton's early 90's roots to an already iconic model.");

            SnowboardSizeSpecs deepThinker154 = new SnowboardSizeSpecs("154", 54, 82, "M", 116, 111.5, 7.2, 248, 53);
            SnowboardSizeSpecs deepThinker157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 119, 114.5, 7.4, 252, 56);
            SnowboardSizeSpecs deepThinker160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122, 117.5, 7.6, 255, 56);
            SnowboardSizeSpecs deepThinker157W = new SnowboardSizeSpecs("157W", 68, 91, "L", 118.5, 114, 7.4, 260, 56);
            SnowboardSizeSpecs deepThinker160W = new SnowboardSizeSpecs("160W", 82, 120, "L", 121.5, 117, 7.6, 263, 56);
            SnowboardSizeSpecs deepThinker163W = new SnowboardSizeSpecs("163W", 82, 120, "L", 124.5, 120, 7.8, 265, 56);
            snowboardSizeSpecsRepository.save(deepThinker154);
            snowboardSizeSpecsRepository.save(deepThinker157);
            snowboardSizeSpecsRepository.save(deepThinker160);
            snowboardSizeSpecsRepository.save(deepThinker157W);
            snowboardSizeSpecsRepository.save(deepThinker160W);
            snowboardSizeSpecsRepository.save(deepThinker163W);
            sb16.getBoardSizeSpecs().add(deepThinker154);
            sb16.getBoardSizeSpecs().add(deepThinker157);
            sb16.getBoardSizeSpecs().add(deepThinker160);
            sb16.getBoardSizeSpecs().add(deepThinker157W);
            sb16.getBoardSizeSpecs().add(deepThinker160W);
            sb16.getBoardSizeSpecs().add(deepThinker163W);

            Terrain deepTinkert1 = new Terrain(allMountain, 7);
            Terrain deepTinkert2 = new Terrain(powder, 7);
            Terrain deepTinkert3 = new Terrain(park, 5);

            terrainRepository.save(deepTinkert1);
            terrainRepository.save(deepTinkert2);
            terrainRepository.save(deepTinkert3);

            sb16.getRidingterrains().add(deepTinkert1);
            sb16.getRidingterrains().add(deepTinkert2);
            sb16.getRidingterrains().add(deepTinkert3);

            sb16.getRiderLevels().add(intermediate);
            sb16.getRiderLevels().add(pro);

            // Flight Attendant
            Snowboard sb17 = new Snowboard(brand1, "Flight Attendant", male, -3.5, directionalCamber, freerideDirectionalShape, directionalFlex, superFly2700G, 6, "Flight_Attendant.webp", "Prepare for take-off with a board that makes waves for its abilities to carve and catch air.", "Designed to be a terrain-slaying alternative to more traditional twin shapes, the Burton Flight Attendant is a free spirit that dissects both pow and hard-pack with equal precision. Balanced Freeride Geometry is the secret with setback camber and sidecut that are centered on your stance to create a twin freestyle feel when riding flat base. On edge the board turns tight and quick, with Directional Camber and taper for added float and flow. A blend of big mountain attributes and all-terrain aggression, the Flight Attendant finds the sweet spot for everything from steep lines and spontaneous slashes to wind-lips, pillows, and side hits.");
            SnowboardSizeSpecs flightAttendant152 = new SnowboardSizeSpecs("152", 54, 82, "S/M", 114, 108, 7.2, 244, 53);
            SnowboardSizeSpecs flightAttendant156 = new SnowboardSizeSpecs("156", 68, 91, "M", 118, 112, 7.4, 248, 56);
            SnowboardSizeSpecs flightAttendant159 = new SnowboardSizeSpecs("159", 82, 120, "M/L", 121, 115, 7.6, 250, 56);
            SnowboardSizeSpecs flightAttendant162 = new SnowboardSizeSpecs("162", 82, 120, "M/L", 124, 118, 7.8, 254, 56);
            SnowboardSizeSpecs flightAttendant168 = new SnowboardSizeSpecs("168", 82, 120, "L", 129.5, 123.5, 8.2, 260, 56);
            SnowboardSizeSpecs flightAttendant159W = new SnowboardSizeSpecs("159W", 68, 91, "L", 121, 115, 7.6, 260, 56);
            SnowboardSizeSpecs flightAttendant162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 124, 118, 7.8, 264, 56);
            snowboardSizeSpecsRepository.save(flightAttendant152);
            snowboardSizeSpecsRepository.save(flightAttendant156);
            snowboardSizeSpecsRepository.save(flightAttendant159);
            snowboardSizeSpecsRepository.save(flightAttendant162);
            snowboardSizeSpecsRepository.save(flightAttendant168);
            snowboardSizeSpecsRepository.save(flightAttendant159W);
            snowboardSizeSpecsRepository.save(flightAttendant162W);
            sb17.getBoardSizeSpecs().add(flightAttendant152);
            sb17.getBoardSizeSpecs().add(flightAttendant156);
            sb17.getBoardSizeSpecs().add(flightAttendant159);
            sb17.getBoardSizeSpecs().add(flightAttendant162);
            sb17.getBoardSizeSpecs().add(flightAttendant168);
            sb17.getBoardSizeSpecs().add(flightAttendant159W);
            sb17.getBoardSizeSpecs().add(flightAttendant162W);

            Terrain flightAttendantt1 = new Terrain(allMountain, 8);
            Terrain flightAttendantt2 = new Terrain(powder, 8);
            Terrain flightAttendantt3 = new Terrain(park, 4);

            terrainRepository.save(flightAttendantt1);
            terrainRepository.save(flightAttendantt2);
            terrainRepository.save(flightAttendantt3);

            sb17.getRidingterrains().add(flightAttendantt1);
            sb17.getRidingterrains().add(flightAttendantt2);
            sb17.getRidingterrains().add(flightAttendantt3);

            sb17.getRiderLevels().add(intermediate);
            sb17.getRiderLevels().add(pro);

            // Family Tree One Hitter 
            Snowboard sb18 = new Snowboard(brand1, "Family Tree One Hitter",  male, -2.5, directionalCamber, freerideDirectionalShape, directionalFlex, superFly2700G, 4,  "Family_Tree_One_Hitter.webp", "Spark up the groomers, slash the stashes, and put your signature on every side hit along the way.", "Neck deep pow is always a treat, but nothing beats a day spent hot lapping your favorite runs, smashing side hits, and treating the whole mountain like a terrain park. We baked this mentality into the Burton One Hitter to make it the one board that's hungrier for deep carves and natty airs than you are. With the snappy combo of a rad new shape and Directional Camber, it's built like a missile, but still soft enough to keep things buttery and playful. For good measure, an FSC™ Certified Super Fly II™ core pairs with bio-based Super Sap® Epoxy to cut the carbon footprint."); 
            SnowboardSizeSpecs familyTreeOneHitter152 = new SnowboardSizeSpecs("152", 54, 82, "L", 114, 109, 7.2, 255, 53);
            SnowboardSizeSpecs familyTreeOneHitter156 = new SnowboardSizeSpecs("156", 68, 91, "L", 118, 113, 7.5, 260, 56);
            SnowboardSizeSpecs familyTreeOneHitter160 = new SnowboardSizeSpecs("160", 82, 120, "L", 122, 117, 7.7, 265, 56);
            snowboardSizeSpecsRepository.save(familyTreeOneHitter152);
            snowboardSizeSpecsRepository.save(familyTreeOneHitter156);
            snowboardSizeSpecsRepository.save(familyTreeOneHitter160);
            sb18.getBoardSizeSpecs().add(familyTreeOneHitter152);
            sb18.getBoardSizeSpecs().add(familyTreeOneHitter156);
            sb18.getBoardSizeSpecs().add(familyTreeOneHitter160);

            Terrain familyTreeOneHittert1 = new Terrain(allMountain, 8);
            Terrain familyTreeOneHittert2 = new Terrain(powder, 7);
            Terrain familyTreeOneHittert3 = new Terrain(park, 5);

            terrainRepository.save(familyTreeOneHittert1);
            terrainRepository.save(familyTreeOneHittert2);
            terrainRepository.save(familyTreeOneHittert3);

            sb18.getRidingterrains().add(familyTreeOneHittert1);
            sb18.getRidingterrains().add(familyTreeOneHittert2);
            sb18.getRidingterrains().add(familyTreeOneHittert3);

            sb18.getRiderLevels().add(intermediate);
            sb18.getRiderLevels().add(pro);
            
            // Family Tree Leader Board 
             Snowboard sb19 = new Snowboard(brand1, "Family Tree Leader Board",  male, -2.5, directionalCamber, allMountainDirectionalShape, directionalFlex, superFly2700G, 8,  "Family_Tree_Leader_Board.webp", "A big mountain burner, designed in collaboration with 5-time Xtreme Verbier Champion, Steve Klassen.", "Freeride champions and big mountain billy goats, take note. The Burton Leader Board puts control and response right beneath your feet. Directional Camber blends with Balanced Freeride Geometry to maintain stability through hair-raising lines, while a reduced sidecut and spooned 3-D contours in the nose nix any catchy contact points. An FSC™ Certified Super Fly II™ core reinforced by a carbon I-Beam™ pairs with bio-based Super Sap® Epoxy for a low carbon footprint."); 
             SnowboardSizeSpecs familyTreeLeaderBoard158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 114, 8.6, 252, 56);
            SnowboardSizeSpecs familyTreeLeaderBoard162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 118, 8.8, 255, 56);
            SnowboardSizeSpecs familyTreeLeaderBoard166 = new SnowboardSizeSpecs("166", 82, 120, "L", 126, 122, 9.2, 260, 56);
            snowboardSizeSpecsRepository.save(familyTreeLeaderBoard158);
            snowboardSizeSpecsRepository.save(familyTreeLeaderBoard162);
            snowboardSizeSpecsRepository.save(familyTreeLeaderBoard166);
            sb19.getBoardSizeSpecs().add(familyTreeLeaderBoard158);
            sb19.getBoardSizeSpecs().add(familyTreeLeaderBoard162);
            sb19.getBoardSizeSpecs().add(familyTreeLeaderBoard166);

            Terrain familyTreeLeaderBoardt1 = new Terrain(powder, 10);
            Terrain familyTreeLeaderBoardt2 = new Terrain(allMountain, 5);
            Terrain familyTreeLeaderBoardt3 = new Terrain(park, 2);

            terrainRepository.save(familyTreeLeaderBoardt1);
            terrainRepository.save(familyTreeLeaderBoardt2);
            terrainRepository.save(familyTreeLeaderBoardt3);

            sb19.getRidingterrains().add(familyTreeLeaderBoardt1);
            sb19.getRidingterrains().add(familyTreeLeaderBoardt2);
            sb19.getRidingterrains().add(familyTreeLeaderBoardt3);

            sb19.getRiderLevels().add(intermediate);
            sb19.getRiderLevels().add(pro);
             
            // Skeleton Key
             Snowboard sb20 = new Snowboard(brand1, "Skeleton Key",  male, -5, directionalCamber, freerideDirectionalShape, directionalFlex, superFly2700G, 4,  "Skeleton_Key.webp", "A directional utility tool designed to unlock the full spectrum of freeride terrain.", "The offspring of a one-night stand between two of Burton's most revered all-terrain boards, the Burton Skeleton Key has quickly become a staple in the quivers of our testers and team riders. From Japan-deep pow to Mount Baker's legendary banks, this uniquely hard-charging directional shape fuses camber with a slightly increased waist width that carves like a knife."); 
             SnowboardSizeSpecs skeletonKey150 = new SnowboardSizeSpecs("150", 54, 82, "M/L", 112.5, 106.5, 7.1, 252, 53);
             SnowboardSizeSpecs skeletonKey154 = new SnowboardSizeSpecs("154", 54, 82, "L", 116.5, 110.5, 7.4, 256, 53);
            SnowboardSizeSpecs skeletonKey158 = new SnowboardSizeSpecs("158", 68, 91, "L", 120.5, 114.5, 7.7, 258, 56);
            SnowboardSizeSpecs skeletonKey162 = new SnowboardSizeSpecs("162", 82, 120, "L", 124.5, 118.5, 7.9, 262, 56);
             snowboardSizeSpecsRepository.save(skeletonKey150);
             snowboardSizeSpecsRepository.save(skeletonKey154);
            snowboardSizeSpecsRepository.save(skeletonKey158);
            snowboardSizeSpecsRepository.save(skeletonKey162);
            sb20.getBoardSizeSpecs().add(skeletonKey150);
            sb20.getBoardSizeSpecs().add(skeletonKey154);
            sb20.getBoardSizeSpecs().add(skeletonKey158);
            sb20.getBoardSizeSpecs().add(skeletonKey162);

            Terrain skeletonKeyt1 = new Terrain(allMountain, 8);
            Terrain skeletonKeyt2 = new Terrain(powder, 7);
            Terrain skeletonKeyt3 = new Terrain(park, 4);

            terrainRepository.save(skeletonKeyt1);
            terrainRepository.save(skeletonKeyt2);
            terrainRepository.save(skeletonKeyt3);

            sb20.getRidingterrains().add(skeletonKeyt1);
            sb20.getRidingterrains().add(skeletonKeyt2);
            sb20.getRidingterrains().add(skeletonKeyt3);

            sb20.getRiderLevels().add(pro);
             
            // Throwback
             //Snowboard sb21 = new Snowboard(brand1, "Flight Attendant",  male, -1.25, camber, allMountainDirectionalShape, twinFlex, superFly2700G, 6,  "Flight_Attendant.webp", "", ""); 
             
            // Descendant
             Snowboard sb22 = new Snowboard(brand1, "Descendant",  male, 0, purePopCamber, twinShape, twinFlex, superFly800G, 2,  "Descendant.webp", "A soft and poppy deck that's perfect for taking what you learn in the park to the entire mountain.", "Dominate the park while getting maximum bang for your buck with the feature-packed Burton Descendant. True twin shaping gives it a freestyle punch, allowing you to ride in either direction with equal control. Soft and playful, it also steps up stability and edge control with the catch-free, park-tuned feel of PurePop Camber. Squeezebox Low provides a softer flex that maintains snappiness and ollie power. The Channel® gives you ultimate control of your stance and the fastest setup possible in a system compatible with bindings from all major brands."); 
             SnowboardSizeSpecs descendant148 = new SnowboardSizeSpecs("148", 45, 68, "S/M", 111.5, 107, 7.1, 246, 53);
             SnowboardSizeSpecs descendant152 = new SnowboardSizeSpecs("152", 54, 82, "M", 115.5, 111, 7.3, 248, 53);
             SnowboardSizeSpecs descendant155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.5, 250, 53);
            SnowboardSizeSpecs descendant158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 117, 7.7, 251, 56);
            SnowboardSizeSpecs descendant160 = new SnowboardSizeSpecs("162", 82, 120, "L", 123.5, 119, 7.8, 258, 56);
            SnowboardSizeSpecs descendant155W = new SnowboardSizeSpecs("155W", 54, 82, "L", 118, 114, 7.5, 264, 53);
            SnowboardSizeSpecs descendant158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 121, 117, 7.7, 265, 56);
            snowboardSizeSpecsRepository.save(descendant148);
            snowboardSizeSpecsRepository.save(descendant152);
            snowboardSizeSpecsRepository.save(descendant155);
             snowboardSizeSpecsRepository.save(descendant158);
             snowboardSizeSpecsRepository.save(descendant160);
            snowboardSizeSpecsRepository.save(descendant155W);
            snowboardSizeSpecsRepository.save(descendant158W);
            sb22.getBoardSizeSpecs().add(descendant148);
            sb22.getBoardSizeSpecs().add(descendant152);
            sb22.getBoardSizeSpecs().add(descendant155);
            sb22.getBoardSizeSpecs().add(descendant158);
            sb22.getBoardSizeSpecs().add(descendant160);
            sb22.getBoardSizeSpecs().add(descendant155W);
            sb22.getBoardSizeSpecs().add(descendant158W);

            Terrain descendantt1 = new Terrain(allMountain, 8);
            Terrain descendantt2 = new Terrain(park, 7);
            Terrain descendantt3 = new Terrain(powder, 4);

            terrainRepository.save(descendantt1);
            terrainRepository.save(descendantt2);
            terrainRepository.save(descendantt3);

            sb22.getRidingterrains().add(descendantt1);
            sb22.getRidingterrains().add(descendantt2);
            sb22.getRidingterrains().add(descendantt3);

            sb22.getRiderLevels().add(intermediate);
             
             
            // Family Tree Backseat Driver
             Snowboard sb23 = new Snowboard(brand1, "Family Tree Backseat Driver",  male, 0, directionalFlatTop, allMountainDirectionalShape, directionalFlex, superFly800G, 8,  "Family_Tree_Backseat_Driver.webp", "Free your feet, free you mind – true snowboard construction built to surf on snow.", "Surf-inspired design meets traditional snowboard construction in the Burton Backseat Driver. If you're wondering, \"where do the bindings go?\" They don't. This pow surfer is designed to surf sans-straps everywhere from your backyard to the backcountry. A spoon nose provides float and flow, working in conjunction with a V-hull in the tail that maintains a loose feeling, but transitions into a strong, powerful turn when engaged. This board is built to push boundaries, and spread the joy of surfing on snow."); 
             SnowboardSizeSpecs familyTreeBackseatDriver = new SnowboardSizeSpecs("140", 54, 82, "L", 85, 67, 4.3, 260, 53);

            snowboardSizeSpecsRepository.save(familyTreeBackseatDriver);
           
            sb23.getBoardSizeSpecs().add(familyTreeBackseatDriver);
            
            Terrain familyTreeBackseatDrivert1 = new Terrain(powder, 10);
            Terrain familyTreeBackseatDrivert2 = new Terrain(allMountain, 2);
            Terrain familyTreeBackseatDrivert3 = new Terrain(powder, 0);

            terrainRepository.save(familyTreeBackseatDrivert1);
            terrainRepository.save(familyTreeBackseatDrivert2);
            terrainRepository.save(familyTreeBackseatDrivert3);

            sb23.getRidingterrains().add(familyTreeBackseatDrivert1);
            sb23.getRidingterrains().add(familyTreeBackseatDrivert2);
            sb23.getRidingterrains().add(familyTreeBackseatDrivert3);

            sb23.getRiderLevels().add(pro);
             
            //Name Dropper
             Snowboard sb24 = new Snowboard(brand1, "Name Dropper",  male, 0, purePopCamber, twinShape, twinFlex, superFly800G, 2,  "Name_Dropper.webp", "People will be dropping your name in no time when you unleash the fury on this park-tuned powerhouse.", "Let your riding speak for itself with the Name Dropper's next-generation, park-tuned performance. Off-Axis means all of its key ingredients, from the edges to the poppy core profile, match the angles of your stance for enhanced grip, smoother takeoffs, and stomped landings. PurePop Camber amplifies ollies and loosens up the overall feel for a more playful take on traditional camber, while the addition of effortlessly flexing Off-Axis Squeezebox Low enhances the overall soft freestyle feel."); 
             SnowboardSizeSpecs nameDropper148 = new SnowboardSizeSpecs("148", 45, 68, "M", 112.3, 107.8, 7.1, 247, 53);
             SnowboardSizeSpecs nameDropper151 = new SnowboardSizeSpecs("151", 54, 82, "M/L", 114.9, 110.4, 7.3, 249, 53);
             SnowboardSizeSpecs nameDropper155 = new SnowboardSizeSpecs("155", 54, 82, "M/L", 118.5, 114, 7.5, 251, 56);
            SnowboardSizeSpecs nameDropper158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.1, 116.6, 7.7, 253, 56);
            snowboardSizeSpecsRepository.save(nameDropper148);
            snowboardSizeSpecsRepository.save(nameDropper151);
            snowboardSizeSpecsRepository.save(nameDropper155);
             snowboardSizeSpecsRepository.save(nameDropper158);
            sb24.getBoardSizeSpecs().add(nameDropper148);
            sb24.getBoardSizeSpecs().add(nameDropper151);
            sb24.getBoardSizeSpecs().add(nameDropper155);
            sb24.getBoardSizeSpecs().add(nameDropper158);

            Terrain nameDroppert1 = new Terrain(park, 9);
            Terrain nameDroppert2 = new Terrain(allMountain, 7);
            Terrain nameDroppert3 = new Terrain(powder, 4);

            terrainRepository.save(nameDroppert1);
            terrainRepository.save(nameDroppert2);
            terrainRepository.save(nameDroppert3);

            sb24.getRidingterrains().add(nameDroppert1);
            sb24.getRidingterrains().add(nameDroppert2);
            sb24.getRidingterrains().add(nameDroppert3);

            sb24.getRiderLevels().add(intermediate);
             
             
            // Kilroy 3D 
            Snowboard sb25 = new Snowboard(brand1, "Kilroy 3D",  male, 0, purePopCamber, twinShape, twinFlex, superFly800G, 3,  "Kilroy_3D.webp", "Introducing the park board's next evolution: 3D construction for an even butterier ride.", "The perfect press is still out there, and the Burton Kilroy 3D is hell bent on finding it. 3D contours in the nose and tail remove material where it's least needed, putting a new focus on flex, and opening doors to catch-free buttery exploration. Heck, if the Kilroys are backing it, we're all in."); 
             SnowboardSizeSpecs kilroy3D150 = new SnowboardSizeSpecs("150", 54, 82, "M/L", 114, 109, 7.3, 250, 53);
             SnowboardSizeSpecs kilroy3D154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 118, 113, 7.6, 254, 53);
            SnowboardSizeSpecs kilroy3D158 = new SnowboardSizeSpecs("158", 68, 91, "L", 122, 117, 7.8, 258, 56);
            snowboardSizeSpecsRepository.save(kilroy3D150);
            snowboardSizeSpecsRepository.save(kilroy3D154);
            snowboardSizeSpecsRepository.save(kilroy3D158);
            sb25.getBoardSizeSpecs().add(kilroy3D150);
            sb25.getBoardSizeSpecs().add(kilroy3D154);
            sb25.getBoardSizeSpecs().add(kilroy3D158);

            Terrain kilroy3Dt1 = new Terrain(park, 10);
            Terrain kilroy3Dt2 = new Terrain(allMountain, 7);
            Terrain kilroy3Dt3 = new Terrain(powder, 4);

            terrainRepository.save(kilroy3Dt1);
            terrainRepository.save(kilroy3Dt2);
            terrainRepository.save(kilroy3Dt3);

            sb25.getRidingterrains().add(kilroy3Dt1);
            sb25.getRidingterrains().add(kilroy3Dt2);
            sb25.getRidingterrains().add(kilroy3Dt3);

            sb25.getRiderLevels().add(intermediate);
            sb25.getRiderLevels().add(pro);

            // Ripcord
            Snowboard sb26 = new Snowboard(brand1, "Ripcord",  male, -2.5, flatTop, allMountainDirectionalShape, directionalFlex, fly900G, 2,  "Ripcord.webp", "Blast past the learning curve with the easiest, most progression-friendly men's board we make.", "Blast past the learning curve with the easiest, most progression-friendly men's board we make."); 
            SnowboardSizeSpecs ripcord148 = new SnowboardSizeSpecs("145", 45, 68, "S/M", 111, 106, 7.1, 244, 48);
             SnowboardSizeSpecs ripcord150 = new SnowboardSizeSpecs("150", 54, 82, "M", 116, 111, 7.4, 247, 50.5);
             SnowboardSizeSpecs ripcord154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 120, 118, 7.7, 250, 53);
            SnowboardSizeSpecs ripcord157 = new SnowboardSizeSpecs("157", 68, 91, "M/L", 123, 118, 7.9, 253, 56);
            SnowboardSizeSpecs ripcord159 = new SnowboardSizeSpecs("159", 68, 91, "L", 123.5, 118.5, 7.9, 256, 56);
            SnowboardSizeSpecs ripcord156W = new SnowboardSizeSpecs("156W", 68, 91, "L", 122, 117, 7.8, 258, 56);
            SnowboardSizeSpecs ripcord158W = new SnowboardSizeSpecs("158W", 68, 91, "L", 122.5, 117.5, 7.8, 259, 56);
            SnowboardSizeSpecs ripcord162W = new SnowboardSizeSpecs("162W", 82, 120, "L", 126, 121, 8.1, 261, 56);
            snowboardSizeSpecsRepository.save(ripcord148);
            snowboardSizeSpecsRepository.save(ripcord150);
            snowboardSizeSpecsRepository.save(ripcord154);
             snowboardSizeSpecsRepository.save(ripcord157);
             snowboardSizeSpecsRepository.save(ripcord159);
            snowboardSizeSpecsRepository.save(ripcord156W);
            snowboardSizeSpecsRepository.save(ripcord158W);
            snowboardSizeSpecsRepository.save(ripcord162W);
            sb26.getBoardSizeSpecs().add(ripcord148);
            sb26.getBoardSizeSpecs().add(ripcord150);
            sb26.getBoardSizeSpecs().add(ripcord154);
            sb26.getBoardSizeSpecs().add(ripcord157);
            sb26.getBoardSizeSpecs().add(ripcord159);
            sb26.getBoardSizeSpecs().add(ripcord156W);
            sb26.getBoardSizeSpecs().add(ripcord158W);
            sb26.getBoardSizeSpecs().add(ripcord162W);

            Terrain ripcordt1 = new Terrain(allMountain, 8);
            Terrain ripcordt2 = new Terrain(park, 4);
            Terrain ripcordt3 = new Terrain(powder, 4);

            terrainRepository.save(ripcordt1);
            terrainRepository.save(ripcordt2);
            terrainRepository.save(ripcordt3);

            sb26.getRidingterrains().add(ripcordt1);
            sb26.getRidingterrains().add(ripcordt2);
            sb26.getRidingterrains().add(ripcordt3);

            sb26.getRiderLevels().add(beginner); 
            
            // Custom X Flying V
            Snowboard sb27 = new Snowboard(brand1, "Custom X Flying V",  male, -1.25, flyingV, allMountainDirectionalShape, twinFlex, dragonfly600G, 6,  "Custom_X_FV.webp", "Get pro-caliber speed and precision with the most aggressive board in Burton's lineup.", "Pro-caliber is a strong statement for any board, but the Burton Custom X has repeatedly delivered for snowboarding's most demanding riders due to precise design and powerful drive. The confidence is in the tech, which includes the carbon-fueled snap of Squeezebox High core profiling, a competition-grade base, and 45° Carbon Highlights High-Voltage for the ultimate in lightweight responsiveness. The hardest charging board we make, the Custom X is available in two versions: choose the power of camber or the float and catch-free feel of Flying V."); 
            SnowboardSizeSpecs customXFV154 = new SnowboardSizeSpecs("154", 54, 82, "M/L", 117.5, 112.5, 7.6, 250, 53);
            SnowboardSizeSpecs customXFV156 = new SnowboardSizeSpecs("156", 68, 91, "M/L", 119.5, 114.5, 7.8, 252, 53);
            SnowboardSizeSpecs customXFV158 = new SnowboardSizeSpecs("158", 68, 91, "M/L", 121.5, 116.5, 7.9, 254, 56);
            SnowboardSizeSpecs customXFV162 = new SnowboardSizeSpecs("162", 82, 120, "L", 125.5, 120.5, 8.2, 256, 56);
            snowboardSizeSpecsRepository.save(customXFV154);
            snowboardSizeSpecsRepository.save(customXFV156);
            snowboardSizeSpecsRepository.save(customXFV158);
            snowboardSizeSpecsRepository.save(customXFV162);

            sb27.getBoardSizeSpecs().add(customXFV154);
            sb27.getBoardSizeSpecs().add(customXFV156);
            sb27.getBoardSizeSpecs().add(customXFV158);
            sb27.getBoardSizeSpecs().add(customXFV162);

            Terrain customXFVt1 = new Terrain(allMountain, 9);
            Terrain customXFVt2 = new Terrain(park, 5);
            Terrain customXFVt3 = new Terrain(powder, 7);

            terrainRepository.save(customXFVt1);
            terrainRepository.save(customXFVt2);
            terrainRepository.save(customXFVt3);

            sb27.getRidingterrains().add(customXFVt1);
            sb27.getRidingterrains().add(customXFVt2);
            sb27.getRidingterrains().add(customXFVt3);

            sb27.getRiderLevels().add(pro);

          
            
            //Save all boards to DB
            snowboardRepository.save(sb1);
            snowboardRepository.save(sb2);
            snowboardRepository.save(sb3);
            snowboardRepository.save(sb4);
            snowboardRepository.save(sb5);
            snowboardRepository.save(sb6);
            snowboardRepository.save(sb7);
            snowboardRepository.save(sb8);
            snowboardRepository.save(sb9);
            snowboardRepository.save(sb10);
            snowboardRepository.save(sb11);
            snowboardRepository.save(sb12);
            snowboardRepository.save(sb13);
            snowboardRepository.save(sb14);
            snowboardRepository.save(sb15);
            snowboardRepository.save(sb16);
            snowboardRepository.save(sb17);
            snowboardRepository.save(sb18);
            snowboardRepository.save(sb19);
            snowboardRepository.save(sb20);
            snowboardRepository.save(sb22);
            snowboardRepository.save(sb23);
            snowboardRepository.save(sb24);
            snowboardRepository.save(sb25);
            snowboardRepository.save(sb26);
            snowboardRepository.save(sb27);

        }
    }
}
