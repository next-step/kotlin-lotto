package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `WinningLotto는 몇 개 일치해야 하는지와 당첨 금액을 보관한다`() {
        assertThat(WinningLotto.FOURTH.numberOfMatches).isEqualTo(3)
        assertThat(WinningLotto.FOURTH.winnings).isEqualTo(5_000)

        assertThat(WinningLotto.THIRD.numberOfMatches).isEqualTo(4)
        assertThat(WinningLotto.THIRD.winnings).isEqualTo(50_000)

        assertThat(WinningLotto.SECOND.numberOfMatches).isEqualTo(5)
        assertThat(WinningLotto.SECOND.winnings).isEqualTo(1_500_000)

        assertThat(WinningLotto.FIRST.numberOfMatches).isEqualTo(6)
        assertThat(WinningLotto.FIRST.winnings).isEqualTo(2_000_000_000)
    }
}
