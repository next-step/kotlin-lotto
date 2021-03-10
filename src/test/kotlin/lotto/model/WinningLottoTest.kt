package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @Test
    fun create() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = Lotto(winningNumbers)
        val bonusNumber = LottoNumber(7)

        // when
        val winningLottoWithBonus = WinningLotto(winningLotto, bonusNumber)

        // then
        assertThat(winningLottoWithBonus.winningLotto).isEqualTo(winningLotto)
        assertThat(winningLottoWithBonus.bonusNumber).isEqualTo(bonusNumber)
    }
}
