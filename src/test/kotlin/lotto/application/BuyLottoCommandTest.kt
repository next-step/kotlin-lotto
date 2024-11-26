package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.LottoPayment
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("NonAsciiCharacters")
class BuyLottoCommandTest {
    @Test
    fun `로또를 구매할 금액이 없으면 예외를 던진다`() {
        assertThrows<IllegalArgumentException> {
            BuyLottoCommand(
                LottoPayment.from(1000L),
                Lotto.from(
                    LottoLine.from(1, 2, 3, 4, 5, 6),
                    LottoLine.from(7, 8, 9, 10, 11, 12),
                ),
            )
        }
    }
}
