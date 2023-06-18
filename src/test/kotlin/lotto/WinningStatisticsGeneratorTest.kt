package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LotteryTickets
import lotto.domain.LottoRanking
import lotto.domain.util.WinningStatisticsGenerator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class WinningStatisticsGeneratorTest {

    private lateinit var generator: WinningStatisticsGenerator

    @BeforeEach
    fun setup() {
        generator = WinningStatisticsGenerator
    }

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 각 등수별 개수를 알 수 있다`() {
        val lotteryTickets = LotteryTickets(
            listOf(
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 5, 6)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 5, 45)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 5, 7)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 7, 8)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 7, 8, 9)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 7, 8, 9, 10)),
            ),
        )
        val winLottoNumber = LottoTestHelper.makeWinningLottoNumbers((1..6).toList(), 45)

        val result = generator.getRankingCountStatistics(
            lotteryTickets = lotteryTickets, winningLottoNumber = winLottoNumber
        )

        result[LottoRanking.FIRST] shouldBe 1
        result[LottoRanking.SECOND] shouldBe 1
        result[LottoRanking.THIRD] shouldBe 1
        result[LottoRanking.FOURTH] shouldBe 1
        result[LottoRanking.FIFTH] shouldBe 1
        result[LottoRanking.MISS] shouldBe 1
    }

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 총 수익률을 계산할 수 있다`() {
        val lotteryTickets = LotteryTickets(
            (1..14).map {
                LottoTestHelper.makeLotteryTicket((it..it + 5).toList())
            },
        )
        val winLottoNumber = LottoTestHelper.makeWinningLottoNumbers(
            numbers = listOf(17, 18, 19, 20, 21, 22),
            bonusNumber = 1,
        )

        val result = generator.getRevenueRateStatistics(
            lotteryTickets = lotteryTickets, winningLottoNumber = winLottoNumber
        )

        result shouldBe BigDecimal("0.35")
    }
}
