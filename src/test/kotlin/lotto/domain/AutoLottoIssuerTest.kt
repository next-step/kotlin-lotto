package lotto.domain

import io.kotest.matchers.equals.shouldBeEqual
import lotto.util.createLottoNumbers
import org.junit.jupiter.api.Test

class AutoLottoIssuerTest {
    @Test
    fun `정해진 개수 만큼 자동 로또를 생성 할 수 있다`() {
        val lottoTickets = AutoLottoIssuer.issueAutoLottoTickets(3) { createLottoNumbers(1, 2, 3, 4, 5, 6) }
        lottoTickets.lottoTickets.size shouldBeEqual 3
    }
}
