package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

internal class LottoTicketsTest : FreeSpec({

    "입력된 총 금액에 구입가능 금액만큼 나눠서 로또를 구매한다." - {
        listOf(
            row(1_000, 1),
            row(2_000, 2),
            row(5_500, 5),
            row(4_999, 4),
        ).forEach { (moneyValue, lottoCount) ->
            "'$moneyValue' 로는 '$lottoCount' 만큼 구매할 수 있다." {
                val money = Money(BigDecimal.valueOf(moneyValue.toLong()))
                val lottoTickets = LottoTickets.buyLottos(money = money)

                lottoTickets.values shouldHaveSize lottoCount
            }
        }
    }

    "구입가능 금액보다 적을 경우 예외가 발생한다." - {
        listOf(
            1,
            10,
            999
        ).forEach { moneyValue ->
            "'$moneyValue' 로는 로또를 구매할 수 없다." {
                val money = Money(BigDecimal.valueOf(moneyValue.toLong()))
                val exception = shouldThrowExactly<IllegalArgumentException> { LottoTickets.buyLottos(money = money) }
                exception.message shouldBe "로또 구입을 위한 최소 금액은 1000 입니다."
            }
        }
    }

    "로또들을 당첨 등수별로 나누어서 반환한다." {
        // given
        val winningTicket = WinningTicket.of(listOf(1, 2, 3, 4, 5, 6))

        val lottoTicket1 = LottoTicket(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 5, 6)))
        val lottoTicket2 = LottoTicket(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 5, 9)))
        val lottoTicket3 = LottoTicket(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 9, 10)))
        val lottoTicket4 = LottoTicket(LottoNumbersFixture.of(setOf(1, 12, 5, 9, 45, 7)))

        val lottoTickets = LottoTickets(listOf(lottoTicket1, lottoTicket2, lottoTicket3, lottoTicket4))

        // when
        val results = lottoTickets.totalMatchResults(winningTicket = winningTicket)

        // then
        results[WinningAmount.MISS] shouldBe 1
        results[WinningAmount.FOURTH] shouldBe 0
        results[WinningAmount.THIRD] shouldBe 1
        results[WinningAmount.SECOND] shouldBe 1
        results[WinningAmount.FIRST] shouldBe 1
    }
})
