package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositionsTest {
    private RandomNumberPicker randomNumberPicker;
    private Positions positions;

    @BeforeEach
    void setUp() {
        randomNumberPicker = new RandomNumberPicker();
        positions = new Positions("judy,nunu,pobi", randomNumberPicker);
    }

    @Test
    void move_함수를_호출했을때_진행이_되는_것을_확인() {
        positions.moveCars();

        List<Car> cars = positions.getCars();
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(0).getCarName()).isEqualTo("judy");

        assertThat(cars.get(1).getPosition()).isZero();
        assertThat(cars.get(1).getCarName()).isEqualTo("nunu");

        assertThat(cars.get(2).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getCarName()).isEqualTo("pobi");

    }

    @Test
    void findWinner_함수로_우승자들이_반환됨() {
        positions.moveCars();
        assertThat(positions.findWinner()).containsExactly("judy", "pobi");

        positions.moveCars();
        assertThat(positions.findWinner()).containsExactly("judy", "nunu", "pobi");
    }
}
