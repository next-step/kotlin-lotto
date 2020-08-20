package lotto

import lotto.domain.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTest {
    @DisplayName("getPrize 확인하기")
    @Test
    fun validatePrize() {
        assertThat(Prize.getPrize(4))
            .isEqualTo(Prize.FOURTH)
    }

    @DisplayName("2등 확인하기")
    @Test
    fun checkSecondPrize() {
        assertThat(Prize.getPrize(5, true))
            .isEqualTo(Prize.SECOND)
    }

    @DisplayName("3등 확인하기")
    @Test
    fun checkThirdPrize() {
        assertThat(Prize.getPrize(5, false))
            .isEqualTo(Prize.THIRD)
    }

    @DisplayName("꽝 확인하기")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun checkNonPrize(countOfMatch: Int) {
        assertThat(Prize.getPrize(countOfMatch, false))
            .isEqualTo(Prize.MISS)
    }
}
