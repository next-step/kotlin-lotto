package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoProfitCalculatorTest : DescribeSpec({
    describe("calculateRewardRate 메서드") {
        val givenWinningNumbers = LottoWinningNumber(setOf(1, 2, 3, 4, 5, 6), 7)
        val givenLottoTickets = LottoTickets(
            listOf(
                LottoTicket(setOf(8, 21, 23, 41, 42, 43)),
                LottoTicket(setOf(3, 5, 11, 16, 32, 38)),
                LottoTicket(setOf(7, 11, 16, 35, 36, 44)),
                LottoTicket(setOf(1, 8, 11, 31, 41, 42)),
                LottoTicket(setOf(13, 14, 16, 38, 42, 45)),
                LottoTicket(setOf(7, 11, 30, 40, 42, 43)),
                LottoTicket(setOf(2, 13, 22, 32, 38, 45)),
                LottoTicket(setOf(23, 25, 33, 36, 39, 41)),
                LottoTicket(setOf(1, 3, 5, 14, 22, 45)),
                LottoTicket(setOf(5, 9, 38, 41, 43, 44)),
                LottoTicket(setOf(2, 8, 9, 18, 19, 21)),
                LottoTicket(setOf(13, 14, 18, 21, 23, 35)),
                LottoTicket(setOf(17, 21, 29, 37, 42, 45)),
                LottoTicket(setOf(3, 8, 27, 30, 35, 44))
            )
        )

        val lottoRewardCalculator = LottoRewardCalculator(givenLottoTickets, givenWinningNumbers)

        context("구입 금액이 티켓 가격 보다 높을 때,") {
            it("수익률을 계산한다.") {
                val givenPurchaseAmount: Int = 14000
                val rewardRate = lottoRewardCalculator
                    .calculateRewardRate(givenPurchaseAmount, LottoStore.LOTTO_TICKET_PRICE)

                rewardRate shouldBe 0.35714285714285715
            }
        }

        context("구입 금액이 0 일 때,") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenPurchaseAmount: Int = 0
                    lottoRewardCalculator.calculateRewardRate(givenPurchaseAmount, LottoStore.LOTTO_TICKET_PRICE)
                }
                exception.message shouldBe "구입 금액은 로또 티켓 가격 보다 커야 합니다."
            }
        }
    }
})
