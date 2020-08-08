package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    internal fun match() {
        val lotto = "1, 2, 3, 4, 5, 6"
        val bonusNo = 7
        val winningLotto = WinningLotto(lotto, bonusNo)
        val userLotto = Lotto.ofComma(lotto)
        assertThat(winningLotto.match(userLotto)).isEqualTo(Rank.FIRST)
    }
}
