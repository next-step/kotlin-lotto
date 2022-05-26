package lotto

import org.junit.jupiter.api.Test

internal class LottoMatchingTest {
    @Test
    fun `로또 기계에 보너스 값을 전달한다`() {
        LottoMatching().checkResult(
            winningLottoTicket = LottoTicket(numbers = (1..6).map { LottoNumber(it) }),
            bonusLottoNumber = LottoNumber(1)
        )
    }
}
