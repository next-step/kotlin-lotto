package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class WinnerTypeTest {

    @ParameterizedTest
    @CsvSource(
        "3,false,MATCHED_THREE_NUMBERS", "3,true,MATCHED_THREE_NUMBERS",
        "4,false,MATCHED_FOUR_NUMBERS", "4,true,MATCHED_FOUR_NUMBERS",
        "5,false,MATCHED_FIVE_NUMBERS", "5,true,MATCHED_FIVE_NUMBERS_WITH_BONUS",
        "6,false,MATCHED_SIX_NUMBERS", "6,true,MATCHED_SIX_NUMBERS",
    )
    fun `매치된 수에 따라 적절한 WinnerType을 반환한다`(matchedNumber: Int, matchedBonus: Boolean, winnerType: WinnerType) {
        Assertions.assertThat(WinnerType.valueOf(matchedNumber, matchedBonus))
            .isEqualTo(winnerType)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `valueOf메서드 호출시 matchedNumber가 0~2 범위를 내에서는 null을 반환한다`(i: Int) {
        Assertions.assertThat(WinnerType.valueOf(i, true))
            .isNull()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun `valueOf메서드 호출시 matchedNumber가 0~6 범위를 벗어나면 예외가 발생한다`(i: Int) {
        Assertions.assertThatThrownBy { WinnerType.valueOf(i, true) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
