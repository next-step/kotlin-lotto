package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    internal fun `지난 주 당첨 번호를 입력하면 당첨 통계를 반환한다`() {
        val lottos = Lottos(listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 10, 11)),
            Lotto(listOf(11, 12, 13, 14, 15, 16))
        ))
        val matchLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val statistics = lottos.matchAll(matchLotto).statistics()
        assertThat(statistics).containsExactly(
            LottoStatistics(Prize.THREE_MATCHED, 0),
            LottoStatistics(Prize.FOUR_MATCHED, 1),
            LottoStatistics(Prize.FIVE_MATCHED, 0),
            LottoStatistics(Prize.SIX_MATCHED, 2)
        )
    }

    @Test
    internal fun `총 수익률과 결과적으로 손해인지 이득인지 알려준다`() {
        val lottos = Lottos(listOf(
            Lotto(listOf(11, 12, 13, 14, 15, 16))
        ))
        val matchLotto = Lotto(listOf(1, 2, 3, 11, 12, 13))
        val result = lottos.matchAll(matchLotto)
        assertThat(result.profit()).isEqualTo(5.0)
    }
}
