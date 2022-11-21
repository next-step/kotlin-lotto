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
    fun `요청받은 횟수 만큼 로또를 생성한다`() {
        val lottos = machine.create(10)

        assertThat(lottos.count()).isEqualTo(10)
    }
}
