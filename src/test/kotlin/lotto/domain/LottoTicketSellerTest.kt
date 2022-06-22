package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

internal class LottoTicketSellerTest : FreeSpec({

    "중복되지 않는 6개의 번호를 가진 로또티켓을 발급한다." {
        // when
        val ticketSeller = LottoTicketSeller()
        val lottoTickets = ticketSeller.buyLottoTickets(money = lotto.domain.lottoticket.LottoTicket.PRICE)
        val lottoTicket = lottoTickets.values.first()

        // then
        lottoTicket.lottoNumbers.values.shouldHaveSize(6)
    }

    "입력된 총 금액에 구입가능 금액만큼 나눠서 로또를 구매한다." - {
        val seller = LottoTicketSeller()

        listOf(
            row(1_000, 1),
            row(2_000, 2),
            row(5_500, 5),
            row(4_999, 4),
        ).forEach { (moneyValue, lottoCount) ->
            "'$moneyValue' 로는 '$lottoCount' 만큼 구매할 수 있다." {
                val money = Money(moneyValue.toBigDecimal())
                val lottoTickets = seller.buyLottoTickets(money = money)

                lottoTickets.values shouldHaveSize lottoCount
            }
        }
    }

    "구입가능 금액보다 적을 경우 예외가 발생한다." - {
        val seller = LottoTicketSeller()

        listOf(
            1,
            10,
            999
        ).forEach { moneyValue ->
            "'$moneyValue' 로는 로또를 구매할 수 없다." {
                val money = Money(BigDecimal.valueOf(moneyValue.toLong()))
                val exception = shouldThrowExactly<IllegalArgumentException> { seller.buyLottoTickets(money = money) }
                exception.message shouldBe "로또 구입을 위한 최소 금액은 1000 입니다."
            }
        }
    }
})
