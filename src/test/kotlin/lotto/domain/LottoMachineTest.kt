package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    @DisplayName("로또 티켓을 올바르게 생성하는지 테스트")
    fun testGenerateTicket() {
        val lottoMachine = LottoMachine(1000)
        val ticket = lottoMachine.generateTicket()
        val numbers = ticket.getNumbers()
        assertEquals(6, numbers.size)
        assertTrue(numbers.all { it in 1..45 })
    }
}
