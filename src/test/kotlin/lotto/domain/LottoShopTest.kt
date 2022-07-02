package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe
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
                val manualNumbersList = List(manualTicketCount) { listOf(1, 2, 3, 4, 5, 6) }
                val lottoNumbersList =
                    lotto.domain.lottoticket.LottoNumbers.createWithSortByNumbersList(manualNumbersList)
                val lottoTickets = lottoShop.sellLottoTickets(money, lottoNumbersList)
                lottoTickets.totalCount shouldBe totalTicketCount
            }
        }
    }

    "수동 로또티켓을 살 수 없는 금액이 주어지면 예외가 발생한다." {
        // given
        val money = Money(BigDecimal.valueOf(5_500))
        val manualNumbersList = List(6) { listOf(1, 2, 3, 4, 5, 6) }
        val lottoShop = LottoShop()

        val lottoNumbersList =
            lotto.domain.lottoticket.LottoNumbers.createWithSortByNumbersList(manualNumbersList)

        // when
        val exception =
            shouldThrowExactly<IllegalArgumentException> { lottoShop.sellLottoTickets(money, lottoNumbersList) }

        // then
        exception.message shouldBe "주어진 금액으로는 입력한 만큼의 수동 로또를 구매할 수 없습니다."
    }
})
