package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `로또 구매 갯수만큼 로또 번호를 생성한다`() {
        val lottoNumberGenerator =
            LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 4, 7, 8)) }
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        val lottos = lottoMachine.makeLottosAuto(4)
        repeat(4) {
            assertThat(lottos.lottos[it].numbers.lottoNumbers.map { it.number })
                .containsExactlyInAnyOrder(1, 2, 3, 4, 7, 8)
        }
    }
}
