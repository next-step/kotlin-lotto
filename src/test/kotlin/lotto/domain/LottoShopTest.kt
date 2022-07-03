package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.lottoticket.LottoNumbers
import java.math.BigDecimal

internal class LottoShopTest : FreeSpec({

    "5,000원을 기준으로" - {
        // given
        val money = Money(BigDecimal.valueOf(5_500))
        val lottoShop = LottoShop()

        listOf(
            row(5, 0, 5),
            row(2, 3, 5),
            row(1, 4, 5),
            row(0, 5, 5),
        ).forEach { (manualTicketCount, autoTicketCount, totalTicketCount) ->
            "수동을 $manualTicketCount 개 사면 자동을 $autoTicketCount 개 사서 총 $totalTicketCount 개가 된다." {
                val manualNumbersList =
                    List(manualTicketCount) { LottoNumbers.createWithSortByList(listOf(1, 2, 3, 4, 5, 6)) }
                val lottoTickets = lottoShop.sellLottoTickets(money, manualNumbersList)
                lottoTickets.totalCount shouldBe totalTicketCount
            }
        }
    }

    "현재 입력금액에 따라 원하는 만큼의 로또 티켓을 구매할 수 있는지 없는지 알 수 있다." {
        // given
        val lottoShop = LottoShop()

        // when, then
        lottoShop.canNotPurchasableBy(money = Money(BigDecimal.valueOf(5_999)), 6) shouldBe false
        lottoShop.canNotPurchasableBy(money = Money(BigDecimal.valueOf(6_000)), 6) shouldBe true
    }
})
