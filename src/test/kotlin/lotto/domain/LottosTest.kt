package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {

    @Test
    fun `로또 목록을 생성할 수 있다`() {
        val lottoGenerator = LottoGenerator(RandomNumberGenerator())
        val budget = Budget.valueOf(5000)
        val generatedLottos = lottoGenerator.generateLottos(budget)

        val lottos = Lottos(generatedLottos)
        assertThat(lottos.lottos).hasSize(5)
    }

    @Test
    fun `로또 목록에서 입력된 로또와 일치하는 갯수 목록을 리턴한다`() {
        val lottoNumbers1 = (1..6).map { LottoNumber.valueOf(it) }
        val lottoNumbers2 = (2..7).map { LottoNumber.valueOf(it) }
        val lottoNumbers3 = (3..8).map { LottoNumber.valueOf(it) }
        val lottoNumbers4 = (1..6).map { LottoNumber.valueOf(it) }
        val givenLotto1 = Lotto(lottoNumbers1)
        val givenLotto2 = Lotto(lottoNumbers2)
        val givenLotto3 = Lotto(lottoNumbers3)
        val givenLotto4 = Lotto(lottoNumbers4)

        val lottos = Lottos(listOf(givenLotto1, givenLotto2, givenLotto3, givenLotto4))
        val compareLotto = Lotto(lottoNumbers1)
        val bonusNumber = LottoNumber.valueOf(45)

        val actual = lottos.getMatchedRewards(compareLotto, bonusNumber)

        assertThat(actual.values).containsExactly(2, 1, 1)
    }

    @Test
    fun `로또 예산을 입력받아 로또 목록을 생성하여 리턴한다`() {
        val budget = Budget.valueOf(5000)

        val actual = Lottos.createLottos(budget)

        assertThat(actual.lottos).hasSize(5)
    }
}
