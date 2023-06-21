package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.view.InputView.splitToIntList
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningNumbersTest {
    private var winningNumbers: WinningNumbers = WinningNumbers(LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.from(7))

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6=FIRST",
        "1,2,3,4,5,7=SECOND",
        "1,2,3,4,5,8=THIRD",
        "1,2,3,4,8,9=FORTH",
        "1,2,3,8,9,10=FIFTH",
        "1,7,8,9,10,11=LOSE",
        "7,8,9,10,11,12=LOSE",
        delimiter = '='
        )
    fun `당첨번호를 통해 로또 번호의 Rank 를 구할 수 있다`(text: String, rank: Rank) {
        val numbers = text.splitToIntList()
        val lottoNumbers = LottoNumbers.from(numbers)
        val resultRank = winningNumbers.calculateRank(lottoNumbers)

        resultRank shouldBe rank
    }

    @Test
    fun `보너스 넘버가 당첨 번호에 포함된 번호면 예외가 발생한다`() {
        val lottoNumbers = LottoNumbers.from(listOf(1,2,3,4,5,6))
        val bonusNumber = LottoNumber.from(6)

        shouldThrow<IllegalArgumentException> { WinningNumbers(lottoNumbers, bonusNumber) }
            .shouldHaveMessage(WinningNumbers.INVALID_BONUS_NUMBER_MESSAGE)
    }
}
