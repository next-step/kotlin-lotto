package lotto.domain

import lotto.domain.enum.Priority
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 번호는 6개다`() {
        assertThat(LottoTicket(LottoNumber()).numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 번호 입력으로 6개 미만의 숫자열이 들어가면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            LottoTicket(LottoNumber(listOf(1)))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호는 각각 1 이상 45 이하이다`() {
        assertThat(LottoTicket(LottoNumber()).numbers).allMatch { number -> number in 1..45 }
    }

    @Test
    fun `로또 번호로 음수가 들어가면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            LottoTicket(LottoNumber(listOf(1, 2, 3, 4, 5, -1)))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또는 당첨번호와 몇 개 일치하는지 정보를 알 수 있다`() {
        val winningTicket = LottoCommittee.createWinningTicket("1,2,3,4,5,6")
        val lotto = LottoTicket(LottoNumber(listOf(4, 5, 6, 7, 8, 9)))
        lotto.contains(10)
        assertThat(lotto.priority(winningTicket)).isEqualTo(Priority.FIFTH)
    }
}
