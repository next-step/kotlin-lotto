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
        val result = lottos.matchAll(matchLotto)
        assertThat(result.same(3)).isEqualTo(0)
        assertThat(result.same(4)).isEqualTo(1)
        assertThat(result.same(5)).isEqualTo(0)
        assertThat(result.same(6)).isEqualTo(2)
    }
}
