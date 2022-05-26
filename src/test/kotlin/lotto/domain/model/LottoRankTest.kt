package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `WinningLotto는 몇 개 일치해야 하는지와 당첨 금액을 보관한다`() {
        assertThat(LottoRank.FOURTH.numberOfMatches).isEqualTo(3)
        assertThat(LottoRank.FOURTH.winnings).isEqualTo(5_000)

        assertThat(LottoRank.THIRD.numberOfMatches).isEqualTo(4)
        assertThat(LottoRank.THIRD.winnings).isEqualTo(50_000)

        assertThat(LottoRank.SECOND.numberOfMatches).isEqualTo(5)
        assertThat(LottoRank.SECOND.winnings).isEqualTo(1_500_000)

        assertThat(LottoRank.FIRST.numberOfMatches).isEqualTo(6)
        assertThat(LottoRank.FIRST.winnings).isEqualTo(2_000_000_000)
    }
}
