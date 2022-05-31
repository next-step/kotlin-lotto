package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinnerTypeTest {

    val winner = Winner(Lotto(listOf(3, 4, 5, 6, 7, 8).map { LottoNumber(it) }), LottoNumber(9))

    @Test
    fun `3개 일치시 MATCHED_THREE_NUMBERS 를 반환한다`() {
        Assertions.assertThat(WinnerType.valueOf(3, false))
            .isEqualTo(WinnerType.MATCHED_THREE_NUMBERS)
        Assertions.assertThat(WinnerType.valueOf(3, true))
            .isEqualTo(WinnerType.MATCHED_THREE_NUMBERS)
    }

    @Test
    fun `4개 일치시 MATCHED_FOUR_NUMBERS 를 반환한다`() {
        Assertions.assertThat(WinnerType.valueOf(4, false))
            .isEqualTo(WinnerType.MATCHED_FOUR_NUMBERS)
        Assertions.assertThat(WinnerType.valueOf(4, true))
            .isEqualTo(WinnerType.MATCHED_FOUR_NUMBERS)
    }

    @Test
    fun `보너스를 포함하지 않고 5개 일치시 MATCHED_FIVE_NUMBERS 를 반환한다`() {
        Assertions.assertThat(WinnerType.valueOf(5, false))
            .isEqualTo(WinnerType.MATCHED_FIVE_NUMBERS)
    }

    @Test
    fun `보너스를 포함하고 5개 일치시 MATCHED_FIVE_NUMBERS_WITH_BONUS 를 반환한다`() {
        Assertions.assertThat(WinnerType.valueOf(5, true))
            .isEqualTo(WinnerType.MATCHED_FIVE_NUMBERS_WITH_BONUS)
    }

    @Test
    fun `6개 일치시 MATCHED_SIX_NUMBERS 를 반환한다`() {
        Assertions.assertThat(WinnerType.valueOf(6, false))
            .isEqualTo(WinnerType.MATCHED_SIX_NUMBERS)
        Assertions.assertThat(WinnerType.valueOf(6, true))
            .isEqualTo(WinnerType.MATCHED_SIX_NUMBERS)
    }
}
