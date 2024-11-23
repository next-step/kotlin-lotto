package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `일치한 갯수 별로 분류한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberGenerator1 =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoNumberGenerator2 = LottoNumberGenerator { listOf(1, 2, 3, 6, 7) }
        val lottoMachine1 = LottoMachine(lottoNumberGenerator1)
        val lottoMachine2 = LottoMachine(lottoNumberGenerator2)

        val lottos1 = lottoMachine1.makeLottos(2)
        val lottos2 = lottoMachine2.makeLottos(1)
        assertThat(LottoResult.getResultMap(lottos1, winningNumbers).get(4)).isEqualTo(2)
        assertThat(LottoResult.getResultMap(lottos2, winningNumbers).get(3)).isEqualTo(1)
    }
}
