package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {

    @Test
    fun `보너스 숫자가 기존 당첨번호와 중복되면 IllegalArgumentException을 throw한다`() {
        // given
        val lotteryPaper = LotteryPaper(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val bonusNumber = LottoNumber(6)

        // then
        assertThrows<IllegalArgumentException> {
            WinningNumber(lotteryPaper, bonusNumber)
        }
    }
}
