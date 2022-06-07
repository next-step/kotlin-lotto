package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketMachineTest {
    @Test
    fun `로또 번호 개수를 잘못입력하면 에러`() {
        val nums = listOf(1, 2, 3, 4, 5)

        assertThrows<IllegalArgumentException> {
            LottoTicketMachine.issue(nums)
        }
    }

    @Test
    fun `올바른 숫자 범위의 값을 받으면 티켓을 발권해준다`() {
        val nums = listOf(1, 2, 3, 4, 5, 6)

        val issueTicket = LottoTicketMachine.issue(nums)

        assertThat(issueTicket).isInstanceOf(LottoTicket::class.java)
    }

    @Test
    fun `잘못된 숫자 범위의 값을 받으면 에러를 던진다`() {
        val nums = listOf(1, 2, 3, 4, 5, 56)

        assertThrows<IllegalArgumentException> {
            LottoTicketMachine.issue(nums)
        }
    }
}
