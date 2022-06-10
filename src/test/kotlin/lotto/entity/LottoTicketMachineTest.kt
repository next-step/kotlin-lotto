package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LottoTicketMachineTest {

    @Test
    fun `출력(print)하면 LottoTicket(Class)을 생성한다`() {
        // given
        val testMachine = LottoTicketMachine()
        val numbers = listOf<Int>(1, 2, 3, 4, 5, 6)

        // when
        val resultTicket = testMachine.print(numbers)

        // then
        Assertions.assertThat(resultTicket).hasSameClassAs(LottoTicket(numbers))
    }

    @Test
    fun `getRandomNumber`() {}
}
