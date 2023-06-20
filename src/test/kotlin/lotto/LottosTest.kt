package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottosTest {
    @Test
    fun `로또 결과 통계를 만들 수 있다`() {
        val budget = 5000
        val lottoNumbers1 = LottoNumber.createList(listOf(1, 2, 3, 4, 5, 6))
        val myLotto1 = Lotto(lottoNumbers1)

        val lottoNumbers2 = LottoNumber.createList(listOf(3, 4, 5, 6, 7, 8))
        val myLotto2 = Lotto(lottoNumbers2)

        val lottoNumbers3 = LottoNumber.createList(listOf(4, 5, 6, 7, 8, 9))
        val myLotto3 = Lotto(lottoNumbers3)

        val lottoNumbers4 = LottoNumber.createList(listOf(4, 5, 6, 7, 9, 10))
        val myLotto4 = Lotto(lottoNumbers4)

        val lottoNumbers5 = LottoNumber.createList(listOf(4, 6, 7, 8, 10, 11))
        val myLotto5 = Lotto(lottoNumbers5)

        val winningLottoNumbers = LottoNumber.createList(listOf(3, 4, 7, 9, 10, 11))
        val winningLotto = WinningLotto(Lotto(winningLottoNumbers), LottoNumber.create(8))

        val lottos = Lottos(listOf(myLotto1, myLotto2, myLotto3, myLotto4, myLotto5))
        val statistics = winningLotto.calculateStatistics(lottos, budget)

        assertAll({
            assertThat(statistics.totalPrizeMoney).isEqualTo(50000)
            assertThat(statistics.rateOfReturn).isEqualTo(10.0)
        })
    }
}
