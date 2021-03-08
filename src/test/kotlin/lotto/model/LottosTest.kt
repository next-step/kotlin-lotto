package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottosTest {
    @Test
    fun `구매할 수 있는 로또 갯수를 인자로 주면, 해당 갯수만큼 Lotto를 가진 Lottos 객체가 생성된다`() {
        // given
        val lottoCount = 5

        // when
        val myLottos = Lottos(LottoNumberPool, lottoCount)

        // then
        assertThat(myLottos.myLottos.size).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun `당첨번호와 일치카운트를 인자로 주면, 해당 당첨번호와 일치카운트만큼 일치하는 로또 갯수를 반환한다`(checkCount: Int) {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 8, 9)),
                Lotto(listOf(1, 2, 3, 10, 11, 12))
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val count = lottos.check(Lotto(winningNumbers), checkCount)

        // then
        assertThat(count).isEqualTo(1)
    }

    @Test
    fun `당첨번호를 인자로 주면, 수익률을 반환한다`() {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 43, 44, 45)), // 3개 일치
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
                Lotto(listOf(19, 20, 21, 22, 23, 24)),
                Lotto(listOf(25, 26, 27, 28, 29, 30)),
                Lotto(listOf(31, 32, 33, 34, 35, 36))
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val earningRate = lottos.getEarningRate(Lotto(winningNumbers))

        // then
        assertThat(earningRate).isEqualTo(5000.toDouble() / 6000.toDouble())
    }

    @Test
    fun `Coincidence를 인자로 주면, Lottos에서 해당 결과와 같은 결과를 가지는 로또 갯수를 반환한다`() {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 8, 9)),
                Lotto(listOf(1, 2, 3, 4, 10, 11)),
                Lotto(listOf(1, 2, 3, 33, 35, 36)),
                Lotto(listOf(1, 2, 3, 43, 44, 45))
            )
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(7)

        // when
        val countForSix = lottos.getCoincidenceCount(Coincidence.SIX, winningLotto, bonusNumber)
        val countForFiveWithBonus = lottos.getCoincidenceCount(Coincidence.FIVE_WITH_BONUS, winningLotto, bonusNumber)
        val countForFive = lottos.getCoincidenceCount(Coincidence.FIVE, winningLotto, bonusNumber)
        val countForFour = lottos.getCoincidenceCount(Coincidence.FOUR, winningLotto, bonusNumber)
        val countForThree = lottos.getCoincidenceCount(Coincidence.THREE, winningLotto, bonusNumber)

        // then
        assertThat(countForSix).isEqualTo(1)
        assertThat(countForFiveWithBonus).isEqualTo(1)
        assertThat(countForFive).isEqualTo(0)
        assertThat(countForFour).isEqualTo(2)
        assertThat(countForThree).isEqualTo(2)
    }
}
