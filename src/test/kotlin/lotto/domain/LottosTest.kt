package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {

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
    fun `match count 테스트`() {
        val lottos = Lottos(listOf(lotto1, lotto2))
        val winningLotto = WinningLotto(lotto1, LottoNumber.of(7))

        val result = lottos.match(winningLotto)

        val first = winningLotto.match(lotto1)
        val third = winningLotto.match(lotto2)

        assertThat(result.elements.keys).contains(first, third)
        assertThat(result.elements[first] ?: throw NullPointerException()).isEqualTo(1)
        assertThat(result.elements[third] ?: throw NullPointerException()).isEqualTo(1)
    }
}
