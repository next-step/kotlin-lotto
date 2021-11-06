package lotto.domain

import lotto.domain.model.BonusNumber
import lotto.domain.model.LottoNumber
import lotto.domain.model.WinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `당첨넘버와 보너스넘버가 중복될때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
            WinningNumber(
                numbers = WinningNumbers(numbers), BonusNumber(LottoNumber(6))
            )
        }
    }

    @Test
    fun `당첨번호 사이즈가 5일때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
            )
            WinningNumber(
                numbers = WinningNumbers(numbers), BonusNumber(LottoNumber(8))
            )
        }
    }

    @Test
    fun `당첨번호 사이즈가 7일때 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            val numbers = listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
                LottoNumber(7),
            )
            WinningNumber(
                numbers = WinningNumbers(numbers), BonusNumber(LottoNumber(8))
            )
        }
    }
}
