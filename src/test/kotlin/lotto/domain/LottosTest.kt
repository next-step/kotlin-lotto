package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {

    private val winningLotto = Lotto(
        setOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )
    )

    private val lotto1 = Lotto(
        setOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )
    )

    private val lotto2 = Lotto(
        setOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(7)
        )
    )

    @Test
    fun `match 테스트`() {
        val lottos = Lottos(listOf(lotto1, lotto2))
        val match = lottos.match(winningLotto)

        val first = Rank.of(winningLotto.matchCount(lotto1))
        val third = Rank.of(winningLotto.matchCount(lotto2))

        assertThat(match.elements.keys).contains(first, third)
        assertThat(match.elements[first] ?: throw NullPointerException()).isEqualTo(1)
        assertThat(match.elements[third] ?: throw NullPointerException()).isEqualTo(1)
    }
}
