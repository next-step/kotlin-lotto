package lotto.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import lotto.domain.LottoPrizePolicy
import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.dto.WinningStatDto

class BuyLottoOutputViewTest : DescribeSpec({

    it("구매한 티켓을 보여준다") {
        // given
        val lottoTickets: List<LottoTicket> = listOf(
            LottoTicket.ofInts(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket.ofInts(listOf(11, 12, 13, 14, 15, 16)),
            LottoTicket.ofInts(listOf(21, 22, 23, 24, 25, 26)),
        )

        // when
        val showAllBoughtTickets = BuyLottoOutputView.showAllBoughtTickets(lottoTickets)

        // then
        showAllBoughtTickets shouldContain """3를 구매했습니다
[1, 2, 3, 4, 5, 6]
[11, 12, 13, 14, 15, 16]
[21, 22, 23, 24, 25, 26]"""
    }

    it("당첨 통계 전체를 보여준다") {
        // given
        val winingStats = listOf(
            WinningStatDto(LottoPrizePolicy(3, Money(3000)), 30),
            WinningStatDto(LottoPrizePolicy(4, Money(4000)), 40),
            WinningStatDto(LottoPrizePolicy(5, Money(5000)), 50),
        )

        // when
        val showAllWinningStat = BuyLottoOutputView.showAllWinningStat(winingStats)

        // then
        showAllWinningStat shouldBe """3개 일치 (3000)-30개
4개 일치 (4000)-40개
5개 일치 (5000)-50개"""
    }

    it("당첨 통계에 수익률을 보여준다") {
        // given
        val winingStats = listOf(
            WinningStatDto(LottoPrizePolicy(3, Money(5000)), 1),
            WinningStatDto(LottoPrizePolicy(4, Money(6000)), 0),
            WinningStatDto(LottoPrizePolicy(5, Money(10000)), 0),
        )

        // when
        val showEarningRate = BuyLottoOutputView.showEarningsRate(Money(14000), winingStats)

        // then
        showEarningRate shouldBe "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    }
})
