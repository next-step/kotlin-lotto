package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LottoTicketMachineTest {

    @Test
    fun `출력(print)하면 LottoTicket(Class)을 생성한다`() {
        // given
        val numbers = listOf<Int>(1, 2, 3, 4, 5, 6)

        // when
        val resultTicket = LottoTicketMachine.print(numbers)

        // then
        Assertions.assertThat(resultTicket).hasSameClassAs(LottoTicket(numbers))
    }

    @Test
    fun `로또 번호는 각각 1 이상 45 이하이다`() {}
}
