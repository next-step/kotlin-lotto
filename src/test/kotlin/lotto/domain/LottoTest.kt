package lotto.domain

import lotto.domain.value.HitLotto
import lotto.domain.value.LottoNumber
import lotto.strategy.TestStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {
    private val lotto = Lotto(TestStrategy())

    @Test
    fun `로또는 여섯 개의 숫자를 가진다`() {
        val lottoNumber = lotto.getLotto()
        val expect = List(6) { i -> LottoNumber(i + 1) }
        assertThat(lottoNumber).isEqualTo(expect)
    }

    @Test
    fun `몇개의 당첨 번호가 맞아 몇등을 했는지 알 수 있다`() {
        val winningNumber = List(6) { i -> LottoNumber(i + 1) }
        val actual = lotto.hitLotto(winningNumber)
        assertThat(actual).isEqualTo(HitLotto.SIX)
    }

    @Test
    fun `ToStringTest`() {
        val actual = lotto.toString()
        assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]\n")
    }
}
