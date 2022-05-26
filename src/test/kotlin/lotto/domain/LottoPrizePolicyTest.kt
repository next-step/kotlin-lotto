package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoPrizePolicyTest : DescribeSpec({
    val wonLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoTicketNumber(it) }
    val wonMatchedCount = 3
    val wonPrize = Money(3000)
    val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonLottoNumbers, wonPrize)

    it("우승한 경우 상품을 준다") {
        // given
        val wonLottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 10, 20, 30))

        // when
        val prize = lottoPrizePolicy.won(wonLottoTicket)

        // then
        prize shouldBe wonPrize
    }

    it("우승하지 못한 경우 상품을 주지 않는다") {
        // given
        val defeatedLottoTicket = LottoTicket.ofInts(listOf(1, 2, 40, 10, 20, 30))

        // when
        val prize = lottoPrizePolicy.won(defeatedLottoTicket)

        // then
        prize shouldBe null
    }
})
