package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    internal fun `지난 주 당첨 번호를 입력하면 당첨 통계를 반환한다`() {
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 10, 11)),
                Lotto(listOf(11, 12, 13, 14, 15, 16))
            )
        )
        val matchLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val statistics = LottoStatistics(lottos = lottos, target = matchLotto)
        assertThat(statistics).containsExactlyEntriesOf(
            mapOf(
                Prize.SIX_MATCHED to 2,
                Prize.FOUR_MATCHED to 1
            )
        )
    }

    @Test
    internal fun `총 수익률과 결과적으로 손해인지 이득인지 알려준다`() {
        val originalBudget = 1_000L
        val lottos = Lottos(
            listOf(
                Lotto(listOf(11, 12, 13, 14, 15, 16))
            )
        )
        val matchLotto = Lotto(listOf(1, 2, 3, 11, 12, 13))
        val result = LottoStatistics(lottos = lottos, target = matchLotto)
        assertThat(result.profit(originalBudget)).isEqualTo(5L)
    }
}
