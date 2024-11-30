package lotto.domain

import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 번호는 1부터 45사이의 중복되지 않는 숫자 6개로 이루어져야한다`() {
        val lottoTicket = LottoTicket()
        (1..45).toSet().containsAll(lottoTicket.lottoNumbers) shouldBeEqual true
        lottoTicket.lottoNumbers.size shouldBeEqual 6
    }
}
