package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoStore
import lotto.domain.PurchaseAmount
import org.junit.jupiter.api.Test

class LottoStoreTest {
    private val lottoStore = LottoStore(FixedLottoGenerator())

    @Test
    fun `구입 금액이 1000원 미만일 시 예외를 리턴한다`() {
        shouldThrow<IllegalArgumentException> {
            lottoStore.purchaseLottoTickets(PurchaseAmount(999))
        }
    }

    @Test
    fun `로또를 구입 금액에 맞는 장 수를 구매한다`() {
        val lottoTickets = listOf(
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
        )

        lottoStore.purchaseLottoTickets(PurchaseAmount(3000)) shouldBe lottoTickets
    }
}
