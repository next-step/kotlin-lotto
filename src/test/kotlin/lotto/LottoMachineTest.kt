package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {

    @Test
    internal fun `로또 발행`() {
        val amount = 10000
        val lottoMachine = LottoMachine()
        val lottoPaper: LottoPaper = lottoMachine.issue(amount)
        assertThat(lottoPaper.size).isEqualTo(10)
    }
}
