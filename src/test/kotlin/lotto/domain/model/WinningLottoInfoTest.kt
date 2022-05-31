package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoInfoTest {
    @Test
    fun `WinningLottoInfo는 WinningNumbers와 보너스볼 번호를 보관한다`() {
        val winningNumbers = WinningNumbers.default()
        val bonusBall = LottoNumber[7]
        val winningLottoInfo = WinningLottoInfo(winningNumbers, bonusBall)

        assertThat(winningLottoInfo.numbers).isEqualTo(winningNumbers)
        assertThat(winningLottoInfo.bonusBall).isEqualTo(bonusBall)
    }

    @Test
    fun `당첨 번호와 보너스볼 번호가 중복될 시 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val winningNumbers = WinningNumbers.default()
            val bonusBall = winningNumbers.value.first()

            WinningLottoInfo(winningNumbers, bonusBall)
        }
    }
}
