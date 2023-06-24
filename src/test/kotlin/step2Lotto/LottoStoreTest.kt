package step2Lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import step2Lotto.domain.LottoStore
import step2Lotto.domain.dto.Lotto
import java.lang.IllegalArgumentException

class LottoStoreTest {
    private val lottoStore = LottoStore(FixedLottoGenerator())

    @Test
    fun `구입 금액이 1000원 미만일 시 예외를 리턴한다`() {
        shouldThrow<IllegalArgumentException> {
            lottoStore.purchaseLottoTickets(999)
        }
    }

    @Test
    fun `로또 구매`() {
        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )

        lottoStore.purchaseLottoTickets(3000) shouldBe lottoTickets
    }
}
