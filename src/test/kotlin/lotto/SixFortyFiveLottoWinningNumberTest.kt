package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SixFortyFiveLottoWinningNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [2, 4, 8, 9, 22])
    fun `1 ~ 45사이의 수를 갖습니다`(bonusNumber: Int) {
        val validLottoNumber = listOf(1, 3, 5, 6, 7, 21)

        SixFortyFiveLottoWinningNumber(validLottoNumber).bonusNumber = bonusNumber
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `1 ~ 45사이의 수가 아니면 에러를 발생합니다`(invalidNumber: Int) {
        val validLottoNumber = listOf(1, 3, 5, 6, 7, 21)

        assertThrows<RuntimeException>(ErrorCode.INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER.msg) {
            SixFortyFiveLottoWinningNumber(validLottoNumber).bonusNumber = invalidNumber
        }
    }

    @Test
    fun `보너스 숫자가 없으면 기존 당첨 숫자들만 반환합니다`() {
        val validLottoNumber = listOf(1, 3, 5, 6, 7, 21)

        val winningNumber = SixFortyFiveLottoWinningNumber(validLottoNumber)

        Assertions.assertIterableEquals(validLottoNumber, winningNumber.value)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3,5,6,7,21"])
    fun `보너스 숫자가 있으면 보너스 숫자를 포함한 당첨 숫자들이 반환됩니다`(numberStr: String) {
        val validLottoNumber = SixFortyFiveLottoUtils.parseNumbersFromStr(numberStr, ',')
        val bonusNumber = 45
        val expectedLottoNumberWithBonus = listOf(*validLottoNumber.toTypedArray(), bonusNumber)

        val winningNumber = SixFortyFiveLottoWinningNumber(validLottoNumber)
        winningNumber.bonusNumber = bonusNumber

        Assertions.assertIterableEquals(winningNumber.value, expectedLottoNumberWithBonus)
        Assertions.assertEquals(7, winningNumber.value.size)
    }
}
