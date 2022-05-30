package lotto.domain.prize

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPrizeTest {
    @ParameterizedTest
    @CsvSource(
        "0, false, 0",
        "1, false, 0",
        "2, false, 0",
        "3, false, 5000",
        "4, false, 50000",
        "5, false, 1500000",
        "5, true, 30000000",
        "6, false, 2000000000"
    )
    fun `일치하는 번호 수에 따라 당첨 금액이 달라진다`(numberOfMatches: Int, matchesBonus: Boolean, expected: Int) {
        Assertions.assertThat(LottoPrize.of(numberOfMatches, matchesBonus).prizeAmount).isEqualTo(expected)
    }
}
