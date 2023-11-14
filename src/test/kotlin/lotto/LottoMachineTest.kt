package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또를 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine(1000)

        val lottoList: List<Lotto> = lottoMachine.buyLottoList()

        assertThat(lottoList).hasSize(1)
    }

    @Test
    fun `로또를 여러 개 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine(2000)

        val lottoList: List<Lotto> = lottoMachine.buyLottoList()

        assertThat(lottoList).hasSize(2)
    }
}
