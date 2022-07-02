package lotto.entity

import lotto.entity.LottoTicket.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.entity.LottoTicket.Companion.MINIMUM_LOTTO_NUMBER
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTicketMachineTest {
    @Test
    fun `3200원을 넣으면 티켓이 3장 나온다`() {
        // when
        val tickets = LottoTicketMachine.printMaxTicket(Wallet(3200)).tickets

        // then
        Assertions.assertThat(tickets.size).isEqualTo(3)
    }

    @Test
    fun `3200원을 넣으면 티켓이 4장 나오지 않는다`() {
        // when
        val tickets = LottoTicketMachine.printMaxTicket(Wallet(3200)).tickets

        // then
        Assertions.assertThat(tickets.size).isNotEqualTo(4)
    }

    @Test
    fun `출력 하면 로또 티켓을 생성한다`() {
        // given
        val numbers = listOf<Int>(1, 2, 3, 4, 5, 6)

        // when
        val resultTicket = LottoTicketMachine.print(numbers)

        // then
        Assertions.assertThat(resultTicket).hasSameClassAs(LottoTicket(numbers))
    }

    @Test
    fun `출력한 로또 티켓은 입력한 숫자를 로또 번호로 가진다`() {
        // given
        val numbers = listOf<Int>(1, 2, 3, 4, 5, 6)

        // when
        val resultTicket = LottoTicketMachine.print(numbers)

        // then
        Assertions.assertThat(resultTicket.numbers).isEqualTo(numbers)
    }

    @Test
    fun `생성되는 로또 번호는 각각 1 이상 45 이하이다`() {
        // when
        val numbers = LottoTicketMachine.getRandomNumber()

        // then
        Assertions.assertThat(numbers).isSubsetOf(MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER)
    }

    @Test
    fun `생성한 로또 번호가 45 초과면 에러가 난다`() {
        // given
        val numbers = listOf<Int>(1, 2, 3, 46, 57, 60)
        // then
        assertThrows<AssertionError> {
            Assertions.assertThat(numbers).isSubsetOf(MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER)
        }
    }

    @Test
    fun `생성한 로또 번호가 1 미만이면 에러가 난다`() {
        // given
        val numbers = listOf<Int>(-1, 2, 3, 4, 5, 6)
        // then
        assertThrows<AssertionError> {
            Assertions.assertThat(numbers).isSubsetOf(MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER)
        }
    }
}
