package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningEnum
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SixFortyFiveWinningEnumTest {
    @Test
    fun `1등 당첨은 모든 숫자가 일치해야 합니다`() {
        val lotto = SixFortyFiveLotto(listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber((it)) })
        val winningNumber = listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber((it)) }
        val bonusNumber = SixFortyFiveNumber(7)
        val winningLotto = SixFortyFiveWinningLotto(SixFortyFiveLotto(winningNumber), bonusNumber)

        val winningEnum = SixFortyFiveWinningEnum.valueOf(winningLotto.matchCount(lotto.numbers))

        Assertions.assertEquals(SixFortyFiveWinningEnum.FIRST, winningEnum)
    }

    @Test
    fun `2등 당첨은 보너스볼과 일치하며 5개의 숫자가 일치해야 합니다`() {
        val lotto = SixFortyFiveLotto(listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber((it)) })
        val winningNumber = listOf(1, 2, 3, 4, 5, 8).map { SixFortyFiveNumber((it)) }
        val bonusNumber = SixFortyFiveNumber(6)
        val winningLotto = SixFortyFiveWinningLotto(SixFortyFiveLotto(winningNumber), bonusNumber)

        val winningEnum = SixFortyFiveWinningEnum.valueOf(winningLotto.matchCount(lotto.numbers))

        Assertions.assertEquals(SixFortyFiveWinningEnum.SECOND, winningEnum)
    }

    @Test
    fun `3등 당첨은 보너스볼을 제외하고 5개의 숫자가 일치해야 합니다`() {
        val lotto = SixFortyFiveLotto(listOf(1, 2, 3, 4, 5, 6).map { SixFortyFiveNumber((it)) })
        val winningNumber = SixFortyFiveLotto(listOf(1, 2, 3, 4, 5, 7).map { SixFortyFiveNumber(it) })
        val bonusNumber = SixFortyFiveNumber(8)
        val winningLotto = SixFortyFiveWinningLotto(winningNumber, bonusNumber)

        val winningEnum = SixFortyFiveWinningEnum.valueOf(winningLotto.matchCount(lotto.numbers))

        Assertions.assertEquals(SixFortyFiveWinningEnum.THIRD, winningEnum)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,6,7 = 1,2,3,4,8,9", "1,2,3,4,5,6 = 2,3,4,5,9,10"], delimiter = '=')
    fun `4등 당첨은 총합 4개의 숫자가 일치해야 합니다`(numbersStr: String, winningNumberStr: String) {
        val lotto = Utils.parseNumbersFromStr(numbersStr, ',')
        val winningNumber = Utils.parseNumbersFromStr(winningNumberStr, ',')
        val bonusNumber = SixFortyFiveNumber(6)
        val winningLotto = SixFortyFiveWinningLotto(winningNumber, bonusNumber)

        val winningEnum = SixFortyFiveWinningEnum.valueOf(winningLotto.matchCount(lotto.numbers))

        Assertions.assertEquals(SixFortyFiveWinningEnum.FOURTH, winningEnum)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,6,7 = 1,2,3,8,9,10", "1,2,3,4,5,6 = 2,3,4,9,10,11"], delimiter = '=')
    fun `5등 당첨은 총합 3개의 숫자가 일치해야 합니다`(numbersStr: String, winningNumberStr: String) {
        val lotto = Utils.parseNumbersFromStr(numbersStr, ',')
        val winningNumber = Utils.parseNumbersFromStr(winningNumberStr, ',')
        val bonusNumber = SixFortyFiveNumber(6)
        val winningLotto = SixFortyFiveWinningLotto(winningNumber, bonusNumber)

        val winningEnum = SixFortyFiveWinningEnum.valueOf(winningLotto.matchCount(lotto.numbers))

        Assertions.assertEquals(SixFortyFiveWinningEnum.FIFTH, winningEnum)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3,4,6,7 = 8,9,10,11,12,13", "1,2,3,4,5,6 = 7,8,9,10,11,12", "1,2,3,4,5,6 = 6,7,8,9,10,11"],
        delimiter = '=',
    )
    fun `미당첨은 총합 3개 미만의 숫자가 일치해야 합니다`(numbersStr: String, winningNumberStr: String) {
        val lotto = Utils.parseNumbersFromStr(numbersStr, ',')
        val winningNumber = Utils.parseNumbersFromStr(winningNumberStr, ',')
        val bonusNumber = SixFortyFiveNumber(5)
        val winningLotto = SixFortyFiveWinningLotto(winningNumber, bonusNumber)

        val winningEnum = SixFortyFiveWinningEnum.valueOf(winningLotto.matchCount(lotto.numbers))

        Assertions.assertEquals(SixFortyFiveWinningEnum.MISS, winningEnum)
    }
}
