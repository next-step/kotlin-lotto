package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {

    @Test
    fun `수동 입력받은 번호로 로또 티켓을 정상 생성한다`() {
        val manualNumbers = setOf(1, 2, 3, 4, 5, 6)
        val lottoTicket = LottoTicket(manualNumbers)
        assertThat(lottoTicket.numbers.size).isEqualTo(6)
    }

    @Test
    fun `수동 입력받은 번호가 6개가 아니라면 예외를 발생시킨다`() {
        val manualNumbers = setOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException>(message = "로또 번호는 6개여야 합니다.") {
            LottoTicket(manualNumbers)
        }
    }

    @Test
    fun `로또 번호는 정렬되어있다`() {
        val manualNumbers = setOf(6, 5, 4, 3, 2, 1)
        val lottoTicket = LottoTicket(manualNumbers)
        assertThat(lottoTicket.numbers.map { it.number })
            .isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `자동 생성된 로또 티켓은 6개의 로또 번호를 가지고 있다`() {
        val lottoTicket = LottoTicket.autoGenerate()
        assertThat(lottoTicket.numbers.size).isEqualTo(6)
    }

    @Test
    fun `자동 생성된 로또 티켓도 정렬되어 있다`() {
        val lottoTicket = LottoTicket.autoGenerate()
        val numbers = lottoTicket.numbers.map { it.number }
        assertThat(numbers).isEqualTo(numbers.sorted())
    }

}