package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MachineTest {

    @Test
    fun `로또 기계는 금액을 전달 받는다`() {
        assertThat(Machine(10000).price).isEqualTo(Machine(10000).price)
    }
}
