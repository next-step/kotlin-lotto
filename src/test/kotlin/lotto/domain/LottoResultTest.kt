package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `사용자의 로또와 당첨로또가 완전히 동일하면 1등이다`() {
        val userLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        val lottoResult = LottoResult(listOf(userLotto), winningLotto, LottoNumber(10))
        val first = lottoResult.ranks[LottoRank.FIRST]
        assertThat(first).isNotNull
        assertThat(first).contains(userLotto)
    }

    @Test
    fun `사용자의 로또와 당첨로또가 5개 일치하고 보너스 볼이 같으면 2등이다`() {
        val userLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7)
            )
        )

        val lottoResult = LottoResult(listOf(userLotto), winningLotto, LottoNumber(6))
        val second = lottoResult.ranks[LottoRank.SECOND]
        assertThat(second).isNotNull
        assertThat(second).contains(userLotto)
    }

    @Test
    fun `사용자의 로또와 당첨로또가 5개 일치하고 보너스 볼이 다르면 3등이다`() {
        val userLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7)
            )
        )

        val lottoResult = LottoResult(listOf(userLotto), winningLotto, LottoNumber(45))
        val third = lottoResult.ranks[LottoRank.THIRD]
        assertThat(third).isNotNull
        assertThat(third).contains(userLotto)
    }

    @Test
    fun `로또 수익률은 총 비용을 상금을 총 비용으로 나눈 값이다`() {
        val userLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningLotto = Lotto.fromLottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(10),
                LottoNumber(11),
                LottoNumber(12)
            )
        )

        val lottoResult = LottoResult(listOf(userLotto), winningLotto, LottoNumber(10)) // 3개 일치, 5등
        assertThat(lottoResult.calculateProfitRate()).isCloseTo(
            LottoRank.FIFTH.prize.toDouble() / Lotto.LOTTO_PRICE.toDouble(),
            Offset.offset(0.01)
        )
    }
}
