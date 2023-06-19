package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LotteryShopKoTest : StringSpec({

    "구매한 금액에 해당하는 로또 갯수 반환" {
        val lotteryShop = LotteryShop()
        val actualInput = 14_000
        lotteryShop.buy(actualInput).lotteryCount shouldBe 14
    }

    "일치하는 로또 갯수에 의한 당첨 금액" {
        val first = WinnerPrize.getPrize(6)
        val second = WinnerPrize.getPrize(5)
        val third = WinnerPrize.getPrize(4)
        val last = WinnerPrize.getPrize(3)

        first.money shouldBe 2_000_000_000
        second.money shouldBe 1_500_000
        third.money shouldBe 50_000
        last.money shouldBe 5_000
    }

    "구매한 로또들과 지난 주 당첨 번호가 일치하는지 확인" {
        val lastWinnerNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotteryTickets = listOf(
            Lottery(listOf(1, 2, 3, 4, 39, 43)),
            Lottery(listOf(9, 11, 21, 27, 28, 32)),
            Lottery(listOf(4, 5, 14, 17, 31, 35)),
            Lottery(listOf(11, 13, 17, 22, 25, 34)),
            Lottery(listOf(1, 3, 5, 21, 41, 42)),
            Lottery(listOf(6, 7, 17, 19, 32, 35)),
            Lottery(listOf(2, 12, 19, 34, 35, 37)),
            Lottery(listOf(1, 3, 5, 6, 39, 44)),
            Lottery(listOf(2, 5, 8, 10, 13, 23)),
            Lottery(listOf(7, 29, 30, 31, 34, 36))
        )

        val lotteryResults = LotteryStatistic.getWinStatistic(lotteryTickets, lastWinnerNumbers).first

        lotteryResults.forEach {
            when (it.prize) {
                3 -> it.matchCount shouldBe 1
                4 -> it.matchCount shouldBe 2
                5 -> it.matchCount shouldBe 0
                6 -> it.matchCount shouldBe 0
            }
        }
    }
})
