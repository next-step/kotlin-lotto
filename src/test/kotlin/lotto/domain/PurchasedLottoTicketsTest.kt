package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import lotto.domain.PurchasedLottoTickets.Companion.INVALID_PURCHASED_COUNT_MESSAGE
import lotto.view.lottoNumberGenerator
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchasedLottoTicketsTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1, -100])
    fun `구매한 로또 티켓 개수가 1개 미만일 경우 에러가 발생한다 `(purchasedCount: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_PURCHASED_COUNT_MESSAGE) {
            PurchasedLottoTickets(purchasedCount = purchasedCount, lottoNumberGenerator = { lottoNumberGenerator() })
        }
    }
}
