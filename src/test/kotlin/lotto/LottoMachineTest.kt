package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `로또 구매 갯수만큼 로또 번호를 생성한다`() {
        val lottoNumberGenerator =
            LottoNumberGenerator { listOf(1, 2, 3, 4, 7) }
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        val lottos = lottoMachine.makeLottos(4)
        repeat(4) {
            assertThat(lottos[it].numbers).containsExactly(1, 2, 3, 4, 7)
        }
    }
}
