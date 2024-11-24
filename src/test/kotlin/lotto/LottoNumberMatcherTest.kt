package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberMatcherTest {
    @Test
    fun `당첨 번호과 로또 번호들을 비교하여 번호의 일치 갯수를 구한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        val lottos = lottoMachine.makeLottos(1)
        assertThat(lottos.lottos.map { winningNumbers.matchNumbers(it) }).containsExactly(4)
    }
}
