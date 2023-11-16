package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `로또 묶음과 당첨로또 번호, 보너스볼을 안다면 로또 등수 별로 그룹할 수 있다`() {
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
                LottoNumber(10)
            )
        )
        val bonusBall = LottoNumber(6)
        val lottos = Lottos(listOf(userLotto))

        val groupByLottoRank = lottos.groupByLottoRank(winningLotto, bonusBall)

        assertThat(groupByLottoRank.size).isEqualTo(1)
        assertThat(groupByLottoRank[LottoRank.SECOND]).isEqualTo(Lottos(listOf(userLotto)))
    }
}
