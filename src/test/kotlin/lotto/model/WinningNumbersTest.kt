package lotto.model

import lotto.model.WinningNumbers.Companion.of
import lotto.service.LottoGenerator.fromString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningNumbersTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6 : 1,2,3,4,5,6 : 6",
            "1,2,3,4,5,6 : 2,3,4,5,6,7 : 5",
            "1,2,3,4,5,6 : 3,4,5,6,7,8 : 4",
            "1,2,3,4,5,6 : 4,5,6,7,8,9 : 3",
            "1,2,3,4,5,6 : 5,6,7,8,9,10 : 2",
            "1,2,3,4,5,6 : 6,7,8,9,10,11 : 1",
            "1,2,3,4,5,6 : 7,8,9,10,11,12 : 0",
        ],
        delimiter = ':'
    )
    internal fun `일치하는 숫자에 따른 상(Prize)`(
        winningNums: String,
        lottoNums: String,
        expectedMatchCount: Int
    ) {
        val lotto = fromString(lottoNums)

        val dummyNumber = 46
        val winningNumbers = of(fromString(winningNums), dummyNumber)

        val expectedPrize = LottoPrize.of(expectedMatchCount, false)
        assertThat(winningNumbers.prizeOf(lotto)).isEqualTo(expectedPrize)
    }
}
