package lotto.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.dto.WinningStatDto
import lotto.util.OutPutModule

class BuyLottoOutputViewTest : DescribeSpec({
    var outputStore: MutableList<String> = mutableListOf()
    var stubOutputModule: OutPutModule = object : OutPutModule {
        override fun write(outputValue: String) {
            outputStore.add(outputValue)
        }
    }

    beforeEach {
        outputStore = mutableListOf()
        stubOutputModule = object : OutPutModule {
            override fun write(outputValue: String) {
                outputStore.add(outputValue)
            }
        }
    }

    describe("구매한 티켓을 보여준다") {
        it("수동, 자동으로 구매한 티켓을 보여준다") {
            // given
            val buyLottoOutputView = BuyLottoOutputView(stubOutputModule)
            val lottoTickets: List<LottoTicket> = listOf(
                LottoTicket.ofInts(listOf(1, 2, 3, 4, 5, 6)),
                LottoTicket.ofInts(listOf(11, 12, 13, 14, 15, 16)),
                LottoTicket.ofInts(listOf(21, 22, 23, 24, 25, 26)),
            )
            val passiveLottoTicket: List<LottoTicket> = listOf(
                LottoTicket.ofInts(listOf(21, 22, 23, 24, 25, 26)),
                LottoTicket.ofInts(listOf(31, 32, 33, 34, 35, 36))
            )

            // when
            buyLottoOutputView.showAllBoughtTickets(lottoTickets, passiveLottoTicket)

            // then
            outputStore[0] shouldBe """
            수동으로 2장, 자동으로 3장을 구매했습니다.
            [21, 22, 23, 24, 25, 26]
            [31, 32, 33, 34, 35, 36]
            [1, 2, 3, 4, 5, 6]
            [11, 12, 13, 14, 15, 16]
            [21, 22, 23, 24, 25, 26]
            """.trimIndent() + "\n"
        }

        it("수동으로 구매한 티켓이 없는 경우 자동으로 구매한 티켓만 보여준다") {
            // given
            val buyLottoOutputView = BuyLottoOutputView(stubOutputModule)
            val lottoTickets: List<LottoTicket> = emptyList()
            val passiveLottoTicket: List<LottoTicket> = listOf(
                LottoTicket.ofInts(listOf(21, 22, 23, 24, 25, 26)),
                LottoTicket.ofInts(listOf(31, 32, 33, 34, 35, 36))
            )

            // when
            buyLottoOutputView.showAllBoughtTickets(lottoTickets, passiveLottoTicket)

            // then
            outputStore[0] shouldBe """
            수동으로 2장, 자동으로 0장을 구매했습니다.
            [21, 22, 23, 24, 25, 26]
            [31, 32, 33, 34, 35, 36]
            """.trimIndent() + "\n"
        }

        it("자동으로 구매한 티켓이 없는 경우 수동으로 구매한 티켓만 보여준다") {
            // given
            val buyLottoOutputView = BuyLottoOutputView(stubOutputModule)
            val lottoTickets: List<LottoTicket> = listOf(
                LottoTicket.ofInts(listOf(1, 2, 3, 4, 5, 6)),
                LottoTicket.ofInts(listOf(11, 12, 13, 14, 15, 16)),
                LottoTicket.ofInts(listOf(21, 22, 23, 24, 25, 26)),
            )
            val passiveLottoTicket: List<LottoTicket> = emptyList()

            // when
            buyLottoOutputView.showAllBoughtTickets(lottoTickets, passiveLottoTicket)

            // then
            outputStore[0] shouldBe """
            수동으로 0장, 자동으로 3장을 구매했습니다.
            [1, 2, 3, 4, 5, 6]
            [11, 12, 13, 14, 15, 16]
            [21, 22, 23, 24, 25, 26]
            """.trimIndent() + "\n"
        }
    }

    it("당첨 통계 전체를 보여준다") {
        // given
        val buyLottoOutputView = BuyLottoOutputView(stubOutputModule)
        val winingStats = listOf(
            WinningStatDto(LottoRank.ONE, 10),
            WinningStatDto(LottoRank.TWO, 20),
            WinningStatDto(LottoRank.THREE, 30),
        )
        val boughtTicketTotalMoney = Money(1000)

        // when
        buyLottoOutputView.showTotalWinningInformation(boughtTicketTotalMoney, winingStats)

        // then
        outputStore[0] shouldBe """
            당첨통계
            ---------
        """.trimIndent()
        outputStore[1] shouldBe """
            6개 일치 (2000000000원)- 10개
            5개 일치, 보너스 볼 일치 (30000000원)- 20개
            5개 일치 (1500000원)- 30개
        """.trimIndent()
        outputStore[2] shouldBe "총 수익률은 2.0645E7입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    }
})
