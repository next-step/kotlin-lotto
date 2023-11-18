package lotto

import lotto.domain.Lotto
import lotto.domain.LottoAmount
import lotto.domain.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {

    @Test
    fun `로또를 머신의 돈 만큼 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine(LottoAmount(1000))

        val lottoList: List<Lotto> = lottoMachine.buyLottoList()

        assertThat(lottoList).hasSize(1)
    }

    @Test
    fun `로또를 여러 개 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine(LottoAmount(2000))

        val lottoList: List<Lotto> = lottoMachine.buyLottoList()

        assertThat(lottoList).hasSize(2)
    }

    @Test
    fun `로또를 한 개 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine(LottoAmount(1000))

        assertDoesNotThrow { lottoMachine.buyLotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `돈이 없을 때 로또 구매 시도 시 에러가 발생한다`() {
        val lottoMachine: LottoMachine = LottoMachine()

        assertThrows<IllegalArgumentException> { lottoMachine.buyLotto(listOf(1, 2, 3, 4, 5, 6)) }
    }
}
