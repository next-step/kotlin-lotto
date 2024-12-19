package lotto.dto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import org.junit.jupiter.api.Test

class PurchaseDetailTest {
    @Test
    fun `수동으로 구입할 로또의 수량은 구입금액보다 많을 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            PurchaseDetail(
                purchaseAmount = 1_000,
                manualLottoTickets =
                    LottoTickets(
                        listOf(
                            LottoTicket.from(setOf(1, 2, 3, 4, 5, 7)),
                            LottoTicket.from(setOf(1, 2, 3, 4, 5, 9)),
                            LottoTicket.from(setOf(1, 2, 3, 4, 8, 9)),
                        ),
                    ),
            )
        }.also {
            it.message shouldBe "수동으로 구입할 로또의 수량이 구입금액보다 많습니다"
        }
    }

    @Test
    fun `자동으로 구입할 로또의 수량은 구입금액보다 많을 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            PurchaseDetail(
                purchaseAmount = 5_000,
                autoLottoQuantity = 10,
                manualLottoQuantity = 3,
                manualLottoTickets =
                    LottoTickets(
                        listOf(
                            LottoTicket.from(setOf(1, 2, 3, 4, 5, 7)),
                            LottoTicket.from(setOf(1, 2, 3, 4, 5, 9)),
                            LottoTicket.from(setOf(1, 2, 3, 4, 8, 9)),
                        ),
                    ),
            )
        }.also {
            it.message shouldBe "자동으로 구입할 로또의 수량이 구입금액보다 많습니다"
        }
    }

    @Test
    fun `만원 구매금액으로 수동 로또 3장을 구입하면 자동 로또는 7장이다`() {
        val purchaseDetail =
            PurchaseDetail(
                purchaseAmount = 10_000,
                manualLottoTickets =
                    LottoTickets(
                        listOf(
                            LottoTicket.from(setOf(1, 2, 3, 4, 5, 7)),
                            LottoTicket.from(setOf(1, 2, 3, 4, 5, 9)),
                            LottoTicket.from(setOf(1, 2, 3, 4, 8, 9)),
                        ),
                    ),
            )
        purchaseDetail.autoLottoQuantity shouldBe 7
    }
}
