package lotto.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {

    private lateinit var machine: LottoMachine

    @BeforeEach
    fun setup() {
        machine = LottoMachine()
    }

    @DisplayName("발급 매수가 0보다 작은 경우 RuntimeException 예외가 발생해야 한다.")
    @Test
    fun lottoNegative() {
        assertThrows<RuntimeException> {
            machine.createLotto(-1)
        }
    }
}
