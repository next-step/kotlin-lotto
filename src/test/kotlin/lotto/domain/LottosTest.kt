package lotto.domain

import lotto.domain.enum.Priority
import lotto.domain.`interface`.LottoFixedNumbers
import lotto.domain.`interface`.LottoRandomNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `주어진 로또 숫자의 리스트만큼 로또 티켓을 생성할 수 있다`() {
        val lottoNumbers = listOf(
            LottoRandomNumbers().createNumbers(),
            LottoRandomNumbers().createNumbers()
        )

        assertThat(Lottos.of(lottoNumbers).tickets.size).isEqualTo(2)
    }

    @Test
    fun `가진 로또 티켓의 순위 정보를 알 수 있다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lottos = Lottos.of(listOf(LottoFixedNumbers().createNumbers(numbers)))
        val winningTicket = WinningTicket(lottos.tickets[0], 7)
        val priorities = lottos.calculatePriorities(winningTicket)

        assertThat(priorities[Priority.FIRST]).isEqualTo(1)
    }
}
