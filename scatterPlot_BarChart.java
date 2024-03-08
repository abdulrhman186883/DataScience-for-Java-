package Ch_05.Video05_08.End;

import java.util.List;
import java.util.stream.Collectors;

public class scatterPlot_BarChart {
    // BarChart Steps ! 1- load the file 2- add the filters for the data and put it in lists , then set the javaFX library code
    @Override
    public void start(Stage primaryStage) {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map((line) -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        // Show a bar chart of the average mpg of cars, based on their "origin" (1=america, 2=europe, 3=asia)
        List<CarRecord> americanCars = cars.stream()
                .filter((car) -> car.origin == 1)
                .collect(Collectors.toList());
        List<CarRecord> europeanCars = cars.stream()
                .filter((car) -> car.origin == 2)
                .collect(Collectors.toList());
        List<CarRecord> asianCars = cars.stream()
                .filter((car) -> car.origin == 3)
                .collect(Collectors.toList());

        Series series = new Series();
        series.getData().add(new Data("American", CarRecordUtil.getAverageMpg(americanCars)));
        series.getData().add(new Data("European", CarRecordUtil.getAverageMpg(europeanCars)));
        series.getData().add(new Data("Asian", CarRecordUtil.getAverageMpg(asianCars)));

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Origin");
        yAxis.setLabel("Average mpg");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setAnimated(false);
        barChart.getData().add(series);
        barChart.setTitle("Average mpg of different car origins");
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);
        barChart.setHorizontalZeroLineVisible(false);

        Scene scene = new Scene(barChart, 700, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

// to set up the scatter plot also add the file , 2- filter on the data and collect it to list and then add it to series of JAvaFX library and design
    @Override
    public void start(Stage primaryStage) {
        List<String> lines = TextLoader.getLines("auto-mpg.data");
        List<CarRecord> cars = lines.stream()
                .map((line) -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        List<CarRecord> olderCars = cars.stream()
                .filter((car) -> car.year <= 76)
                .collect(Collectors.toList());

        List<CarRecord> newerCars = cars.stream()
                .filter((car) -> car.year > 76)
                .collect(Collectors.toList());

        Series olderCarSeries = new Series();
        olderCars.forEach((car) -> {
            olderCarSeries.getData().add(new Data(car.weight, car.mpg));
        });

        Series newerCarSeries = new Series();
        newerCars.forEach((car) -> {
            newerCarSeries.getData().add(new Data(car.weight, car.mpg));
        });

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weight");
        yAxis.setLabel("MPG");

        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);

        scatterChart.getData().add(olderCarSeries);
        scatterChart.getData().add(newerCarSeries);
        scatterChart.setTitle("Weight vs. Mileage");
        scatterChart.setHorizontalGridLinesVisible(false);
        scatterChart.setVerticalGridLinesVisible(false);
        scatterChart.setHorizontalZeroLineVisible(false);

        Scene scene = new Scene(scatterChart, 900, 1000);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
