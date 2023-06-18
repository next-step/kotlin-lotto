package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningResult
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinning
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SixFortyFiveWinningEnumTest {
    @Test
    fun `1등 당첨은 보너스볼을 제외한 모든 숫자가 일치해야 합니다`() {
        val numbers = SixFortyFiveLottoNumber(listOf(1, 2, 3, 4, 5, 6))
        val winningNumber = SixFortyFiveLottoWinningNumber(listOf(1, 2, 3, 4, 5, 6))
        winningNumber.bonusNumber = 7

        val winningEnum = SixFortyFiveWinning.valueOf(SixFortyFiveLottoWinningResult.of(numbers, winningNumber))

        Assertions.assertEquals(SixFortyFiveWinning.FIRST, winningEnum)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6 = 1,2,3,4,7,8", "1,2,3,4,5,6 = 1,2,3,4,5,7"], delimiter = '=')
    fun `2등 당첨은 보너스볼을 포함해 5개 또는 6개의 숫자가 일치해야 합니다`(numbersStr: String, winningNumberStr: String) {
        val numbers = SixFortyFiveLottoNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(numbersStr, ','))
        val winningNumber = SixFortyFiveLottoWinningNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(winningNumberStr, ','))
        winningNumber.bonusNumber = 6

        val winningEnum = SixFortyFiveWinning.valueOf(SixFortyFiveLottoWinningResult.of(numbers, winningNumber))

        Assertions.assertEquals(SixFortyFiveWinning.SECOND, winningEnum)
    }

    @Test
    fun `3등 당첨은 보너스볼을 제외하고 5개의 숫자가 일치해야 합니다`() {
        val numbers = SixFortyFiveLottoNumber(listOf(1, 2, 3, 4, 5, 6))
        val winningNumber = SixFortyFiveLottoWinningNumber(listOf(1, 2, 3, 4, 5, 7))
        winningNumber.bonusNumber = 8

        val winningEnum = SixFortyFiveWinning.valueOf(SixFortyFiveLottoWinningResult.of(numbers, winningNumber))

        Assertions.assertEquals(SixFortyFiveWinning.THIRD, winningEnum)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,6,7 = 1,2,3,4,8,9", "1,2,3,4,5,6 = 2,3,4,8,9,10"], delimiter = '=')
    fun `4등 당첨은 총합 4개의 숫자가 일치해야 합니다`(numbersStr: String, winningNumberStr: String) {
        val numbers = SixFortyFiveLottoNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(numbersStr, ','))
        val winningNumber = SixFortyFiveLottoWinningNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(winningNumberStr, ','))
        winningNumber.bonusNumber = 5

        val winningEnum = SixFortyFiveWinning.valueOf(SixFortyFiveLottoWinningResult.of(numbers, winningNumber))

        Assertions.assertEquals(SixFortyFiveWinning.FOURTH, winningEnum)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,6,7 = 1,2,3,8,9,10", "1,2,3,4,5,6 = 3,4,8,9,10,11"], delimiter = '=')
    fun `5등 당첨은 총합 3개의 숫자가 일치해야 합니다`(numbersStr: String, winningNumberStr: String) {
        val numbers = SixFortyFiveLottoNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(numbersStr, ','))
        val winningNumber = SixFortyFiveLottoWinningNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(winningNumberStr, ','))
        winningNumber.bonusNumber = 5

        val winningEnum = SixFortyFiveWinning.valueOf(SixFortyFiveLottoWinningResult.of(numbers, winningNumber))

        Assertions.assertEquals(SixFortyFiveWinning.FIFTH, winningEnum)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3,4,6,7 = 8,9,10,11,12,13", "1,2,3,4,5,6 = 7,8,9,10,11,12", "1,2,3,4,5,6 = 6,7,8,9,10,11"],
        delimiter = '=',
    )
    fun `미당첨은 총합 3개 미만의 숫자가 일치해야 합니다`(numbersStr: String, winningNumberStr: String) {
        val numbers = SixFortyFiveLottoNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(numbersStr, ','))
        val winningNumber = SixFortyFiveLottoWinningNumber(SixFortyFiveLottoUtils.parseNumbersFromStr(winningNumberStr, ','))
        winningNumber.bonusNumber = 5

        val winningEnum = SixFortyFiveWinning.valueOf(SixFortyFiveLottoWinningResult.of(numbers, winningNumber))

        Assertions.assertEquals(SixFortyFiveWinning.MISS, winningEnum)
    }
}
