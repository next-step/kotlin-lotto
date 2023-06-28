package Lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import Lotto.domain.Lotto
import Lotto.domain.LottoStore

class LottoStoreTest {
    private val lottoStore = LottoStore(FixedLottoGenerator())

    @Test
    fun `구입 금액이 1000원 미만일 시 예외를 리턴한다`() {
        shouldThrow<IllegalArgumentException> {
            lottoStore.purchaseLottoTickets(999)
        }
    }

    @Test
    fun `로또를 구입 금액에 맞는 장 수를 구매한다`() {
        val lottoTickets = listOf(
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
            Lotto(arrayOf(1, 2, 3, 4, 5, 6)),
        )

        lottoStore.purchaseLottoTickets(3000) shouldBe lottoTickets
    }
}
