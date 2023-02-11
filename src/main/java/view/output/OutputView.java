package view.output;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private final String RACING_RESULT_MESSAGE = System.lineSeparator() + "실행 결과";
    private final String RACING_WINNER_MESSAGE = "%s가 최종 우승했습니다." + System.lineSeparator();
    private final String DISTANCE_MARK = "-";
    private final String CAR_INFO_DELIMITER = " : ";
    private final String RESULT_DELIMITER = ", ";

    public void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            StringJoiner stringJoiner = new StringJoiner(CAR_INFO_DELIMITER);
            stringJoiner.add(makeCarNames(car));
            stringJoiner.add(makeCarTrack(car));

            System.out.println(stringJoiner);
        }
        System.out.println();
    }

    private String makeCarNames(Car car) {
        return car.getCarName();
    }

    private String makeCarTrack(Car car) {
        return DISTANCE_MARK.repeat(car.getPosition());
    }

    public void printRacingWinners(List<Car> cars) {
        StringJoiner stringJoiner = new StringJoiner(RESULT_DELIMITER);
        cars.forEach(car -> stringJoiner.add(car.getCarName()));

        System.out.printf(RACING_WINNER_MESSAGE, stringJoiner);
    }

    public void printGameResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }
}