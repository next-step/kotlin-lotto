package lotto.domain.dto

import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RankTest {

    @Test
    internal fun `2등 랭킹 찾기`() {
        val lottoResult = LottoMatchResult(5, true)
        val rank = Rank.of(lottoResult)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    internal fun `3등 랭킹 찾기`() {
        val lottoResult = LottoMatchResult(5, false)
        val rank = Rank.of(lottoResult)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    internal fun `1등 랭킹 찾기`() {
        val lottoResult = LottoMatchResult(6, false)
        val rank = Rank.of(lottoResult)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    internal fun `미당첨 랭킹 찾기`() {
        val lottoResult = LottoMatchResult(1, false)
        val rank = Rank.of(lottoResult)
        assertThat(rank).isEqualTo(Rank.NONE)
    }
}
