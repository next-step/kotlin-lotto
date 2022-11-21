package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


internal class LottoMachineTest {
    private lateinit var machine: LottoMachine

    @BeforeEach
    fun setUP() {
        machine = LottoMachine()
    }

    @Test
    fun `1000원 마다 로또를 하나씩 발급한다`() {
        val money = 10000
        val lotties = machine.create(money)

        assertThat(lotties.count()).isEqualTo(10)
    }
}