package sample.legoset;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sample.App;
import sample.Output;
import sample.legoset.domain.LegoSet;
import sample.legoset.domain.Manual;
import sample.legoset.domain.ModelReport;

import java.time.Period;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = App.class)
@Transactional
//每个测试方法执行后，事务不提交
class ProductRepositoryTest {

    @Autowired
    LegoSetRepository repository;


    @Test
    public void exerciseSomewhatComplexEntity() {
        LegoSet smallCar = createLegoSet("小车 01", 5, 12);
        smallCar.setManual(new Manual("按顺序拼装即可", "张小盒"));
        smallCar.addModel("suv", "升降门 SUV.");
        smallCar.addModel("跑车", "亮红 跑车.");

        repository.save(smallCar);
        Iterable<LegoSet> legoSets = repository.findAll();
        Output.list(legoSets, "Original LegoSet");
        checkLegoSets(legoSets, "按顺序拼装即可", 2);

        smallCar.getManual().setText("按车的形状拼装即可.");
        smallCar.addModel("皮卡", "A 皮卡 后车厢装备了武器.");

        repository.save(smallCar);
        legoSets = repository.findAll();
        Output.list(legoSets, "Updated");
        checkLegoSets(legoSets, "按车的形状拼装即可.", 3);

        smallCar.setManual(new Manual("参考这张图", "张小盒"));

        repository.save(smallCar);
        legoSets = repository.findAll();
        Output.list(legoSets, "Manual replaced");
        checkLegoSets(legoSets, "参考这张图", 3);

    }

    @Test
    public void customQueries() {

        LegoSet smallCars = createLegoSet("小车 - 01", 5, 10);
        smallCars.setManual(new Manual("按顺序拼装即可", "张小盒"));

        smallCars.addModel("SUV", "升降门 SUV.");
        smallCars.addModel("跑车", "亮红 跑车.");

        LegoSet f1赛车 = createLegoSet("F1 赛车", 6, 15);
        f1赛车.setManual(new Manual("此产品能拼装坦克和大炮", "丘吉尔"));

        f1赛车.addModel("F1 Ferrari 2018", "A very fast red car.");

        LegoSet constructionVehicles = createLegoSet("Construction Vehicles", 3, 6);
        constructionVehicles.setManual(
                new Manual("随意组装，发挥你的想象", "王大拿"));

        constructionVehicles.addModel("scoop", "A backhoe loader");
        constructionVehicles.addModel("Muck", "Muck 是非常高级的载重货车");
        constructionVehicles.addModel("lofty", "A mobile crane");
        constructionVehicles.addModel("roley",
                "会唱歌的车.");

        repository.saveAll(Arrays.asList(smallCars, f1赛车, constructionVehicles));

        List<ModelReport> report = repository.reportModelForAge(6);
        Output.list(report, "Model Report");

        assertThat(report).hasSize(7)
                .allMatch(m -> m.getDescription() != null && m.getModelName() != null && m.getSetName() != null);

        int updated = repository.lowerCaseMapKeys();
        // SUV, F1 Ferrari 2018 and Muck get updated
        assertThat(updated).isEqualTo(3);

    }

    private LegoSet createLegoSet(String name, int minimumAge, int maximumAge) {

        LegoSet smallCar = new LegoSet();

        smallCar.setName(name);
        smallCar.setMinimumAge(Period.ofYears(minimumAge));
        smallCar.setMaximumAge(Period.ofYears(maximumAge));

        return smallCar;
    }

    private void checkLegoSets(Iterable<LegoSet> legoSets, String manualText, int numberOfModels) {

        assertThat(legoSets) //
                .extracting( //
                        ls -> ls.getManual().getText(), //
                        ls -> ls.getModels().size()) //
                .containsExactly(new Tuple(manualText, numberOfModels));
    }
}