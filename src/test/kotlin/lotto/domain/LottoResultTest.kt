package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `사용자의 로또와 당첨로또가 완전히 동일하면 1등이다`() {
        val userLotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningLotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        val lottoResult = LottoResult(listOf(userLotto), winningLotto)
        val first = lottoResult.ranks[LottoRank.FIRST]
        assertThat(first).isNotNull
        assertThat(first).contains(userLotto)
    }

    @Test
    fun `로또 수익률은 총 비용을 상금을 총 비용으로 나눈 값이다`() {
        val userLotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningLotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(10),
                LottoNumber(11),
                LottoNumber(12)
            )
        )

        val lottoResult = LottoResult(listOf(userLotto), winningLotto) // 3개 일치, 4등
        assertThat(lottoResult.calculateProfitRate()).isCloseTo(
            LottoRank.FOURTH.prize.toDouble() / Lotto.LOTTO_PRICE.toDouble(),
            Offset.offset(0.01)
        )
    }
}
