package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final NumberGeneratePolicy numberGeneratePolicy;
    private Round round;

    public RacingGame(Cars cars, Round round, NumberGeneratePolicy numberGeneratePolicy) {
        this.cars = cars;
        this.round = round;
        this.numberGeneratePolicy = numberGeneratePolicy;
    }

    public static RacingGame createRacingGame(List<String> carsName, String round,
                                              NumberGeneratePolicy numberGeneratePolicy) {
        return new RacingGame(Cars.fromNames(carsName), new Round(round), numberGeneratePolicy);
    }

    public RacingRecord race() {
        cars.driveAll(numberGeneratePolicy);
        return new RacingRecord(cars.getDriveRecord());
    }

    public boolean hasNextGame() {
        if (this.round.isValidRound()) {
            this.round = round.toNextRound();
            return true;
        }
        return false;
    }

    public RacingResult getRacingResult() {
        return new RacingResult(cars.getWinners());
    }
}