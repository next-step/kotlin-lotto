package lotto.domain.money

import lotto.domain.money.PrizeMoney.Companion.FIFTH_PLACE_PRIZE
import lotto.domain.money.PrizeMoney.Companion.FIRST_PLACE_PRIZE
import lotto.domain.money.PrizeMoney.Companion.FOURTH_PLACE_PRIZE
import lotto.domain.money.PrizeMoney.Companion.LAST_PLACE_PRIZE
import lotto.domain.money.PrizeMoney.Companion.THIRD_PLACE_PRIZE
import lotto.domain.money.PrizeMoney.Companion.fifthPlacePrize
import lotto.domain.money.PrizeMoney.Companion.firstPlacePrize
import lotto.domain.money.PrizeMoney.Companion.fourthPlacePrize
import lotto.domain.money.PrizeMoney.Companion.lastPlacePrize
import lotto.domain.money.PrizeMoney.Companion.thirdPlacePrize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("로또 상금 객체 `PrizeMoney` 테스트")
internal class PrizeMoneyTest {

    @DisplayName("각 등수에 따라 정해진 당첨 금액으로 `PrizeMoney` 객체 생성")
    @ParameterizedTest
    @MethodSource("prizeMoneyParametersByPlace")
    fun `receive a prize money of two billion if first place`(givenPlaceMoney: Int, expectedPrizeMoney: Int) {
        // Arrange
        // Act
        // Assert
        assertThat(givenPlaceMoney).isEqualTo(expectedPrizeMoney)
    }

    companion object {
        @JvmStatic
        fun prizeMoneyParametersByPlace(): Stream<Arguments> =
            Stream.of(
                Arguments.of(firstPlacePrize.value, FIRST_PLACE_PRIZE),
                Arguments.of(thirdPlacePrize.value, THIRD_PLACE_PRIZE),
                Arguments.of(fourthPlacePrize.value, FOURTH_PLACE_PRIZE),
                Arguments.of(fifthPlacePrize.value, FIFTH_PLACE_PRIZE),
                Arguments.of(lastPlacePrize.value, LAST_PLACE_PRIZE)
            )
    }
}
