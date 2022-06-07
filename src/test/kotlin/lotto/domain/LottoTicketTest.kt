package lotto.domain

import lotto.domain.enum.Priority
import lotto.domain.`interface`.LottoFixedNumbers
import lotto.domain.`interface`.LottoRandomNumbers
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 번호는 6개다`() {
        assertThat(LottoTicket(LottoRandomNumbers().createNumbers()).lottoNumbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 번호는 정렬되어 있다`() {
        val lottoNumbers = LottoFixedNumbers().createNumbers(listOf(6, 5, 4, 3, 2, 1))
        assertThat(LottoTicket(lottoNumbers).lottoNumbers.map { it.number }.toSet()).isEqualTo(setOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또 번호 입력으로 6개 미만의 숫자열이 들어가면 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            LottoTicket(setOf(LottoNumber.of(1)))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 6자리여야 합니다.")
    }

    @Test
    fun `로또 번호는 각각 1 이상 45 이하이다`() {
        val lottoNumbers = LottoRandomNumbers().createNumbers()
        assertThat(LottoTicket(lottoNumbers).lottoNumbers.map { it.number }).allMatch { number -> number in 1..45 }
    }

    @Test
    fun `로또는 당첨번호와 몇 개 일치하는지 정보를 알 수 있다`() {
        val lottoNumbers = LottoFixedNumbers().createNumbers(listOf(4, 5, 6, 7, 8, 9))
        val lotto = LottoTicket(lottoNumbers)
        val winningTicket = LottoCommittee.createWinningTicket("1,2,3,4,5,6", "7")

        assertThat(lotto.priority(winningTicket)).isEqualTo(Priority.FIFTH)
    }
}
