package lotto

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

internal class WinningLottoNumbersTest {
    @Test
    fun `2등 당첨`() {
        val inputLottoNumbers = LottoNumbers(makeLottoNumbers(1, 2, 3, 4, 5, 45))
        val winningLottoNumbers = WinningLottoNumbers(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(winningLottoNumbers, LottoNumber(45))

        val win = winningLottoNumbers.win(inputLottoNumbers, bonusNumber)

        assertThat(win == Rank.SECOND)
    }

    @Test
    fun `3등 당첨`() {
        val inputLottoNumbers = LottoNumbers(makeLottoNumbers(1, 2, 3, 4, 5, 45))
        val winningLottoNumbers = WinningLottoNumbers(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(winningLottoNumbers, LottoNumber(7))

        val win = winningLottoNumbers.win(inputLottoNumbers, bonusNumber)

        assertThat(win == Rank.SECOND)
    }

    private fun makeLottoNumbers(vararg elements: Int): Set<LottoNumber> {
        val mutableSetOf = mutableSetOf<LottoNumber>()
        for (number in elements) {
            mutableSetOf.add(LottoNumber(number))
        }
        return mutableSetOf.toSet()
    }

}