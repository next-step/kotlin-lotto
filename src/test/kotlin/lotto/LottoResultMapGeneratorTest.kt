package lotto

import lotto.domain.LottoGenerator
import lotto.domain.LottoNumberMatcher
import lotto.domain.LottoResultMapGenerator
import lotto.domain.SetGenerator
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultMapGeneratorTest {
    @Test
    fun `일치한 갯수 별로 분류한다`() {
        val lottoNumberMatcher = LottoNumberMatcher(WinningNumbers(listOf(1, 2, 3, 4, 5)))
        val lottoResultMap = LottoResultMapGenerator(lottoNumberMatcher)
        val setGenerator1 =
            object : SetGenerator {
                override fun getSet(): List<Int> {
                    return listOf(1, 2, 3, 4, 7)
                }
            }
        val setGenerator2 =
            object : SetGenerator {
                override fun getSet(): List<Int> {
                    return listOf(1, 2, 3, 6, 7)
                }
            }
        val lottoGenerator1 = LottoGenerator(setGenerator1)
        val lottoGenerator2 = LottoGenerator(setGenerator2)

        val lottos1 = lottoGenerator1.getLottos(2)
        val lottos2 = lottoGenerator2.getLottos(1)
        assertThat(lottoResultMap.getResultMap(lottos1).get(4)).isEqualTo(2)
        assertThat(lottoResultMap.getResultMap(lottos2).get(3)).isEqualTo(1)
    }
}
