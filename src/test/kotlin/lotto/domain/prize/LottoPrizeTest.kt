package lotto.domain.prize

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPrizeTest {
    @ParameterizedTest
    @CsvSource(
        "0, 0",
        "1, 0",
        "2, 0",
        "3, 5000",
        "4, 50000",
        "5, 1500000",
        "6, 2000000000"
    )
    fun `일치하는 번호 수에 따라 당첨 금액이 달라진다`(numberOfMatches: Int, expected: Int) {
        Assertions.assertThat(LottoPrize.of(numberOfMatches).prizeAmount).isEqualTo(expected)
    }
}
