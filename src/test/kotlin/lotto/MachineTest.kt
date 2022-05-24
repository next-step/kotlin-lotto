package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MachineTest {

    @Test
    fun `로또 기계는 금액을 전달 받는다`() {
        Machine(10000)
    }
}
