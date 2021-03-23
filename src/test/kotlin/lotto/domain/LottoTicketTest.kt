package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {

    private val winningTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
    private val bonusNumber = LottoNumber.from(10)
    private lateinit var lottoTicket: LottoTicket

    @BeforeEach
    fun init() {
        lottoTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 10))
    }

    @Test
    fun `로또 1개 수동으로 만들기`() {
        assertThat(lottoTicket.value).containsExactly(
            LottoNumber.from(1), LottoNumber.from(2),
            LottoNumber.from(3), LottoNumber.from(4),
            LottoNumber.from(5), LottoNumber.from(10)
        )
    }

    @Test
    fun `로또 티켓 생성시 번호가 모자를 경우 Exception 발생`() {
        assertThrows<IllegalArgumentException> { LottoTicket(listOf(1, 2, 3, 4, 5)) }
    }

    @Test
    fun `당첨 번호 개수 확인`() {
        assertThat(lottoTicket.getCountOfMatch(winningTicket)).isEqualTo(5)
    }

    @Test
    fun `보너스 넘버가 포함되는지 확인`() {
        assertThat(lottoTicket.isNumberContains(bonusNumber)).isTrue()
    }
}
