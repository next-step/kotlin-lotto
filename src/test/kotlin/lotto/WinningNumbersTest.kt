package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningNumbersTest {
    private var winningNumbers: WinningNumbers = WinningNumbers(LottoNumbers.from("1,2,3,4,5,6"))

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6=FIRST",
        "1,2,3,4,5,7=SECOND",
        "1,2,3,4,7,8=THIRD",
        "1,2,3,7,8,9=FORTH",
        "1,2,7,8,9,10=LOSE",
        "1,7,8,9,10,11=LOSE",
        "7,8,9,10,11,12=LOSE",
        delimiter = '='
        )
    fun `당첨번호를 통해 로또 번호의 Rank 를 구할 수 있다`(text: String, rank: Rank) {
        val lottoNumbers = LottoNumbers.from(text)
        val resultRank = winningNumbers.calculateRank(lottoNumbers)

        resultRank shouldBe rank
    }
}
