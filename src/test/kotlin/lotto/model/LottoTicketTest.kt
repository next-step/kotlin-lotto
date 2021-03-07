package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {
    @Test
    fun `LottoTicket 은 생성될때 6자리의 번호가 자동 으로 생성되며, 크기순으로 정렬된다`() {
        val lottoTicket = LottoTicket()

        assertThat(lottoTicket.numbers.size).isEqualTo(6)
        assertThat(isSorted(lottoTicket.numbers)).isTrue()
    }

    private fun isSorted(numbers: LottoNumbers): Boolean {
        for (i in 0 until numbers.lastIndex) {
            if (numbers[i].number > numbers[i + 1].number) {
                return false
            }
        }
        return true
    }
}
