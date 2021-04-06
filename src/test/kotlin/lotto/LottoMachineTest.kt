package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `로또 발행 수동 X`() {
        val amount = 10000
        val lottoMachine = LottoMachine()
        val lottoPaper: LottoPaper = lottoMachine.issue(amount, listOf())
        assertThat(lottoPaper.size).isEqualTo(10)
    }

    @Test
    fun `로또 발행 수동 O`() {
        val amount = 10000
        val lottoMachine = LottoMachine()
        val lottoPaper: LottoPaper = lottoMachine.issue(amount, listOf("1,2,3,4,5,6"))
        assertThat(lottoPaper.size).isEqualTo(10)
        assertThat(lottoPaper.lottoNumbers).contains(LottoNumber(listOf(1, 2, 3, 4, 5, 6)))
    }
}
