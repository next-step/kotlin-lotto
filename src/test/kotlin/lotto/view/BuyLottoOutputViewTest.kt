package lotto.view

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.mockk
import io.mockk.verify
import lotto.domain.LottoPrizePolicy
import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.dto.WinningStatDto
import lotto.util.OutPutModule

class BuyLottoOutputViewTest : DescribeSpec({
    val stubOutputModule: OutPutModule = mockk<OutPutModule>(relaxed = true)

    it("구매한 티켓을 보여준다") {
        // given
        val buyLottoOutputView = BuyLottoOutputView(stubOutputModule)
        val lottoTickets: List<LottoTicket> = listOf(
            LottoTicket.ofInts(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket.ofInts(listOf(11, 12, 13, 14, 15, 16)),
            LottoTicket.ofInts(listOf(21, 22, 23, 24, 25, 26)),
        )

        // when
        buyLottoOutputView.showAllBoughtTickets(lottoTickets)

        // then
        verify {
            stubOutputModule.write(
                "3를 구매했습니다\n" +
                    "[1, 2, 3, 4, 5, 6]\n" +
                    "[11, 12, 13, 14, 15, 16]\n" +
                    "[21, 22, 23, 24, 25, 26]\n"
            )
        }
    }

    it("당첨 통계 전체를 보여준다") {
        // given
        val buyLottoOutputView = BuyLottoOutputView(stubOutputModule)
        val winingStats = listOf(
            WinningStatDto(LottoPrizePolicy(3, Money(3000)), 30),
            WinningStatDto(LottoPrizePolicy(4, Money(4000)), 40),
            WinningStatDto(LottoPrizePolicy(5, Money(5000)), 50),
        )
        val boughtTicketTotalMoney = Money(1000)

        // when
        buyLottoOutputView.showTotalWinningInformation(boughtTicketTotalMoney, winingStats)

        // then
        verify {
            stubOutputModule.write("당첨통계\n" + "---------")
            stubOutputModule.write(
                "3개 일치 (3000)-30개\n" +
                    "4개 일치 (4000)-40개\n" +
                    "5개 일치 (5000)-50개"
            )
            stubOutputModule.write("총 수익률은 500.0입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }
})
