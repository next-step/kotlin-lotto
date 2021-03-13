package lotto.model

import lotto.model.game.Lotto
import lotto.model.game.LottoNumber
import lotto.model.game.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `보너스번호는 당첨번호와 중복될 수 없다`(bonusNum: Int) {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(winningNumbers)
        val bonusNumber = LottoNumber(bonusNum)

        // when, then
        assertThrows<IllegalArgumentException> { WinningLotto(lotto, bonusNumber) }
    }
}
