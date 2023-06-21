package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SixFortyFiveWinningLottoTest {
    @Test
    fun `보너스 숫자가 없으면 기존 당첨 숫자들만 반환합니다`() {
        val validLottoNumber = SixFortyFiveLotto(listOf(1, 3, 5, 6, 7, 21).map { SixFortyFiveNumber(it) })
        val winningLotto = SixFortyFiveWinningLotto(validLottoNumber)

        Assertions.assertIterableEquals(validLottoNumber.numbers, winningLotto.lotto.numbers)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3,5,6,7,21"])
    fun `보너스 숫자가 있으면 보너스 숫자를 포함한 당첨 숫자들이 반환됩니다`(numberStr: String) {
        val validLottoNumber = Utils.parseNumbersFromStr(numberStr, ',')
        val bonusNumber = SixFortyFiveNumber(45)
        val expectedLottoNumberWithBonus = listOf(*validLottoNumber.numbers.toTypedArray(), bonusNumber)

        val winningLotto = SixFortyFiveWinningLotto(validLottoNumber, bonusNumber)

        Assertions.assertIterableEquals(winningLotto.lotto.numbers, expectedLottoNumberWithBonus)
        Assertions.assertEquals(7, winningLotto.lotto.numbers.size)
    }
}
