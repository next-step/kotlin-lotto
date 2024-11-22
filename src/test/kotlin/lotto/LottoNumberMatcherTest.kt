package lotto

import lotto.domain.LottoGenerator
import lotto.domain.LottoNumberMatcher
import lotto.domain.SetGenerator
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberMatcherTest {
    @Test
    fun `당첨 번호과 로또 번호들을 비교하여 번호의 일치 갯수를 구한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberMatcher = LottoNumberMatcher(winningNumbers)
        val setGenerator =
            object : SetGenerator {
                override fun getSet(): List<Int> {
                    return listOf(1, 2, 3, 4, 7)
                }
            }
        val lottoGenerator = LottoGenerator(setGenerator)
        val lottos = lottoGenerator.getLottos(1)
        assertThat(lottos.map { lottoNumberMatcher.matchNumbers(it) }).containsExactly(4)
    }
}
