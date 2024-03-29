package boardFinder.demo.service;

import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.domain.SnowboardSizeSpecs;
import boardFinder.demo.repository.ShoeSizeRepository;
import boardFinder.demo.repository.SnowboardRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class SnowboardService {

    private SnowboardRepository snowboardRepo;
    private List<Snowboard> currentList;
    private List<Snowboard> filteredList;
    private List<Snowboard> alternativeFilteredList;

    private ShoeSizeRepository shoeSizeRepository;
    private ShoeSize riderShoeSize;
    private int riderWeight;
    private Snowboard selectedSnowboard;
    List<String> recommendedLengths = new ArrayList();

    @Autowired
    public SnowboardService(SnowboardRepository snowboardRepo, ShoeSizeRepository shoeSizeRepository) {
        this.snowboardRepo = snowboardRepo;
        this.shoeSizeRepository = shoeSizeRepository;
    }

    @PostConstruct
    public List<Snowboard> getAllSnowboards() {
        currentList = snowboardRepo.getAllSnowboards();
        filteredList = new ArrayList<>(currentList);
        return currentList;
    }

    public ShoeSize findRiderShoeSize(double shoeSize) {
        riderShoeSize = null;
        return shoeSizeRepository.findByEuSize(shoeSize);

    }

    public List<Snowboard> resetFilteredList() {
        filteredList = new ArrayList<>(currentList);
        return filteredList;
    }

    public List<Snowboard> resetAlternativeFilteredList() {
        alternativeFilteredList = new ArrayList<>(currentList);
        return alternativeFilteredList;
    }

    public Snowboard filterById(long id) {
        return snowboardRepo.findById(id);
    }

    List<Snowboard> filterByGender(List<Snowboard> snowboardList, String riderGender) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardGender().getSex().equalsIgnoreCase(riderGender)).collect(Collectors.toList());
        return snowboardList;
    }

    List<Snowboard> filterByRiderWeight(List<Snowboard> snowboardList, int riderWeight) {
        snowboardList = snowboardList.stream()
                .filter((s) -> s.getBoardSizeSpecs().stream().anyMatch(b -> b.getRiderWeightMin() <= riderWeight && b.getRiderWeightMax() >= riderWeight)).collect(Collectors.toList());
        return snowboardList;
    }

    List<Snowboard> filterByShoeSize(List<Snowboard> snowboardList, double shoeSize) {

        riderShoeSize = findRiderShoeSize(shoeSize);

        snowboardList = snowboardList.stream()
                .filter((s) -> s.getBoardSizeSpecs().stream().anyMatch(b -> b.getWaistWidth() <= riderShoeSize.getWaistWidthMax() && b.getWaistWidth() >= riderShoeSize.getWaistWidthMin())).collect(Collectors.toList());

        return snowboardList;
    }

    List<Snowboard> filterByRiderLevel(List<Snowboard> snowboardList, String riderLevel) {
        snowboardList = snowboardList.stream()
                .filter((b) -> b.getRiderLevels().stream().anyMatch(rl -> rl.getRiderLevel().equalsIgnoreCase(riderLevel))).collect(Collectors.toList());
        return snowboardList;
    }

    List<Snowboard> filterByRidingTerrain(List<Snowboard> snowboardList, String ridingType) {
        snowboardList = snowboardList.stream()
                .filter((b) -> b.getRidingterrains().stream().anyMatch(rt -> rt.getRidingType().getRidingTypeName().equalsIgnoreCase(ridingType) && rt.getValue() > 5)).collect(Collectors.toList());
        return snowboardList;
    }

    List<Snowboard> filterByShape(List<Snowboard> snowboardList, String shape) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardShape().getShapeName().equalsIgnoreCase(shape)).collect(Collectors.toList());
        return snowboardList;
    }

    List<Snowboard> filterByBrand(List<Snowboard> snowboardList, String brand) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardBrand().getBrandName().equalsIgnoreCase(brand)).collect(Collectors.toList());
        return snowboardList;
    }

    List<Snowboard> filterByFlex(List<Snowboard> snowboardList, String flex) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardFlex().getFlex().equalsIgnoreCase(flex)).collect(Collectors.toList());
        return snowboardList;
    }

    List<Snowboard> filterByBend(List<Snowboard> snowboardList, String bend) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardBend().getName().equalsIgnoreCase(bend)).collect(Collectors.toList());
        return snowboardList;
    }

    //Alternative filter methods
    List<Snowboard> filterByAlternativeBend(List<Snowboard> snowboardList, String bend) {
        //Regular Camber, "Pure-Pop Camber, Directional Camber Bend.id 1, 3, 5
        if (bend.equalsIgnoreCase("Regular Camber")) {
            snowboardList = snowboardList.stream()
                    .filter(s
                            -> s.getBoardBend().getName().equalsIgnoreCase("Pure-Pop Camber")
                    || s.getBoardBend().getName().equalsIgnoreCase("Directional Camber")).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Pure-Pop Camber")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardBend().getName().equalsIgnoreCase("Regular Camber")
                    || s.getBoardBend().getName().equalsIgnoreCase("Directional Camber")).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Directional Camber")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardBend().getName().equalsIgnoreCase("Regular Camber")
                    || s.getBoardBend().getName().equalsIgnoreCase("Pure-Pop Camber")).collect(Collectors.toList());
        }
        //"Flat Top, Flying V / Camber/Rocker, Directional Flat Top 2, 4, 6
        if (bend.equalsIgnoreCase("Flat Top")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardBend().getName().equalsIgnoreCase("Flying V / Camber/Rocker")
                    || s.getBoardBend().getName().equalsIgnoreCase("Directional Flat Top")).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Flying V / Camber/Rocker")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardBend().getName().equalsIgnoreCase("Flat Top")
                    || s.getBoardBend().getName().equalsIgnoreCase("Directional Flat Top")).collect(Collectors.toList());
        }
        if (bend.equalsIgnoreCase("Directional Flat Top")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardBend().getName().equalsIgnoreCase("Flat Top")
                    || s.getBoardBend().getName().equalsIgnoreCase("Flying V / Camber/Rocker")).collect(Collectors.toList());
        }

        return snowboardList;
    }

    List<Snowboard> filterByAlternativeShape(List<Snowboard> snowboardList, String shape) {
        if (shape.equalsIgnoreCase("All Mountain Directional Shape")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardShape().getShapeName().equalsIgnoreCase("Twin Shape")
                    || s.getBoardShape().getShapeName().equalsIgnoreCase("Freeride Directional Shape")).collect(Collectors.toList());
        }
        if (shape.equalsIgnoreCase("Twin Shape")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardShape().getShapeName().equalsIgnoreCase("All Mountain Directional Shape")
                    || s.getBoardShape().getShapeName().equalsIgnoreCase("Freeride Directional Shape")).collect(Collectors.toList());
        }
        if (shape.equalsIgnoreCase("Freeride Directional Shape")) {
            snowboardList = snowboardList.stream()
                    .filter(s -> s.getBoardShape().getShapeName().equalsIgnoreCase("Twin Shape")
                    || s.getBoardShape().getShapeName().equalsIgnoreCase("All Mountain Directional Shape")).collect(Collectors.toList());
        }
        return snowboardList;

    }

    public List<Snowboard> filter(Map<String, Object> map) {
        currentList = snowboardRepo.getAllSnowboards();
        filteredList = new ArrayList<>(currentList);
        resetFilteredList();
        if (map.get("gender") != null) {
            filteredList = filterByGender(filteredList, map.get("gender").toString());
        }
        if (map.get("riderWeight") != null) {
            filteredList = filterByRiderWeight(filteredList, Integer.parseInt(map.get("riderWeight").toString()));
        }
        if (map.get("shoeSize") != null) {
            filteredList = filterByShoeSize(filteredList, Double.parseDouble(map.get("shoeSize").toString()));
        }
        if (map.get("riderLevel") != null) {
            filteredList = filterByRiderLevel(filteredList, map.get("riderLevel").toString());
        }
        if (map.get("preferredTerrain") != null) {
            filteredList = filterByRidingTerrain(filteredList, map.get("preferredTerrain").toString());
        }
        if (map.get("shape") != null && !map.get("shape").toString().equalsIgnoreCase("Any")) {
            filteredList = filterByShape(filteredList, map.get("shape").toString());
        }
        if (map.get("flex") != null && !map.get("flex").toString().equalsIgnoreCase("Any")) {
            filteredList = filterByFlex(filteredList, map.get("flex").toString());
        }
        if (map.get("bend") != null && !map.get("bend").toString().equalsIgnoreCase("Any")) {
            filteredList = filterByBend(filteredList, map.get("bend").toString());
        }

        filteredList = sortFilteredBoardsafterTerrainValue(filteredList, map);

        return filteredList;
    }

    public List<Snowboard> filterWithAlternativeBendAndShape(Map<String, Object> map) {
        currentList = snowboardRepo.getAllSnowboards();
        alternativeFilteredList = new ArrayList<>(currentList);

        resetAlternativeFilteredList();

        filteredList = filter(map);

        Set<Long> boardIds = filteredList.stream()
                .map(Snowboard::getId)
                .collect(Collectors.toSet());

        alternativeFilteredList = alternativeFilteredList.stream().filter(snowboard
                -> !boardIds.contains(snowboard.getId())
        ).collect(Collectors.toList());

        alternativeFilteredList = sortFilteredBoardsafterTerrainValue(alternativeFilteredList, map);

        if (map.get("gender") != null) {
            alternativeFilteredList = filterByGender(alternativeFilteredList, map.get("gender").toString());
        }
        if (map.get("riderWeight") != null) {
            alternativeFilteredList = filterByRiderWeight(alternativeFilteredList, Integer.parseInt(map.get("riderWeight").toString()));
        }

        if (map.get("shoeSize") != null) {
            alternativeFilteredList = filterByShoeSize(alternativeFilteredList, Double.parseDouble(map.get("shoeSize").toString()));
        }
        if (map.get("riderLevel") != null) {
            alternativeFilteredList = filterByRiderLevel(alternativeFilteredList, map.get("riderLevel").toString());
        }
        if (map.get("preferredTerrain") != null) {
            alternativeFilteredList = filterByRidingTerrain(alternativeFilteredList, map.get("preferredTerrain").toString());
        }
        alternativeFilteredList = sortFilteredBoardsafterTerrainValue(alternativeFilteredList, map);

        return alternativeFilteredList;
    }

    public List<String> getRecommendedBoardLengths(Map<String, Object> map) {
        recommendedLengths.clear();
        riderWeight = 0;
        riderShoeSize = findRiderShoeSize(Double.parseDouble(map.get("shoeSize").toString()));
        riderWeight = Integer.parseInt(map.get("riderWeight").toString());

        selectedSnowboard = filterById(Long.parseLong(map.get("boardId").toString()));

        for (SnowboardSizeSpecs s : selectedSnowboard.getBoardSizeSpecs()) {
            for (int i = riderShoeSize.getWaistWidthIdeal(); i <= riderShoeSize.getWaistWidthMax(); i++) {
                if (s.getWaistWidth() == i && s.getRiderWeightMin() <= riderWeight && s.getRiderWeightMax() >= riderWeight) {
                    recommendedLengths.add(s.getBoardLength());
                    if (recommendedLengths.size() == 2) {
                        break;
                    }
                }
            }
        }
        if (selectedSnowboard.getBoardSizeSpecs().size() >= 2 && recommendedLengths.size() < 2) {
            for (SnowboardSizeSpecs s : selectedSnowboard.getBoardSizeSpecs()) {
                for (int i = riderShoeSize.getWaistWidthIdeal(); i >= riderShoeSize.getWaistWidthMin(); i--) {
                    if (s.getWaistWidth() == i && s.getRiderWeightMin() <= riderWeight && s.getRiderWeightMax() >= riderWeight) {
                        recommendedLengths.add(s.getBoardLength());
                        if (recommendedLengths.size() == 2) {
                            break;
                        }
                    }
                }
            }
            Collections.sort(recommendedLengths);
        }
        return recommendedLengths;
    }

    public List<Snowboard> sortFilteredBoardsafterTerrainValue(List<Snowboard> snowboardList, Map<String, Object> map) {

        Comparator<Snowboard> compareRiderTerrainValue = (Snowboard s1, Snowboard s2) -> s1.getRiderTerrainValueByName(map.get("preferredTerrain").toString()).compareTo(s2.getRiderTerrainValueByName(map.get("preferredTerrain").toString()));
        Collections.sort(snowboardList, compareRiderTerrainValue.reversed());

        return snowboardList;
    }

}
