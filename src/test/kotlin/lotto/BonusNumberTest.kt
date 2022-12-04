package lotto

import org.junit.jupiter.api.Test

internal class BonusNumberTest {

    @Test
    fun `생성 제한 테스트`() {
        val winningLottoNumbers = WinningLottoNumbers(makeLottoNumbers(1, 2, 3, 4, 5, 6))
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            BonusNumber(winningLottoNumbers, LottoNumber(1))
        }
    }

    private fun makeLottoNumbers(vararg elements: Int): Set<LottoNumber> {
        val mutableSetOf = mutableSetOf<LottoNumber>()
        for (number in elements) {
            mutableSetOf.add(LottoNumber(number))
        }
        return mutableSetOf.toSet()
    }
}