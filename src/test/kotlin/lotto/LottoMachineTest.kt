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
            LottoNumberGenerator { LottoNumbers.of(listOf(1, 2, 3, 4, 7)) }
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        val lottos = lottoMachine.makeLottos(4)
        repeat(4) {
            assertThat(lottos.lottos[it].numbers.lottoNumbers[0].number).isEqualTo(1)
            assertThat(lottos.lottos[it].numbers.lottoNumbers[1].number).isEqualTo(2)
            assertThat(lottos.lottos[it].numbers.lottoNumbers[2].number).isEqualTo(3)
            assertThat(lottos.lottos[it].numbers.lottoNumbers[3].number).isEqualTo(4)
            assertThat(lottos.lottos[it].numbers.lottoNumbers[4].number).isEqualTo(7)
        }
    }
}
