package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoResultAnalyticsTest : StringSpec({

    "로또 5개를 구입할 때 1등 당첨 1번 + 2등 당첨 2번 + 3등 당첨 1번 + 낙첨 1번이면, 당첨 통계 계산 로직은 총 당첨된 횟수 만큼 통계를 반환한다" {
        forAll(
            row(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 6)), // 1등 당첨
                    LottoTicket(listOf(1, 2, 3, 4, 5, 45)), // 2등 당첨
                    LottoTicket(listOf(1, 2, 3, 4, 45, 6)), // 2등 당첨
                    LottoTicket(listOf(1, 2, 3, 4, 44, 45)), // 3등 당첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)) // 낙첨
                )
            )
        ) { winningNumbers: List<Int>, lottoList: List<LottoTicket> ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTickets = LottoTickets(lottoList)
            val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)

            val winningStatistics = lottoResultAnalytics.getWinningStatistics()
            winningStatistics.get(LottoRanking.FIRST) shouldBe 1
            winningStatistics.get(LottoRanking.SECOND) shouldBe 2
            winningStatistics.get(LottoRanking.THIRD) shouldBe 1
            winningStatistics.get(LottoRanking.FOURTH) shouldBe 0
            winningStatistics.get(LottoRanking.MISS) shouldBe 1
        }
    }

    "로또 10개를 구입할 때 4등 당첨 1번 + 낙첨 9번이면, 수익률은 0.5이다. " {
        forAll(
            row(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(
                    LottoTicket(listOf(1, 2, 3, 43, 44, 45)), // 4등 당첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                )
            )
        ) { winningNumbers: List<Int>, lottoList: List<LottoTicket> ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTickets = LottoTickets(lottoList)
            val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)

            val profitRate = lottoResultAnalytics.getProfitRate(lottoTickets.size())
            profitRate shouldBe 0.5
        }
    }

    "로또 10개를 구입할 때 3등 당첨 1번 + 낙첨 9번이면, 수익률은 5.0이다. " {
        forAll(
            row(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(
                    LottoTicket(listOf(1, 2, 3, 4, 44, 45)), // 3등 당첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                    LottoTicket(listOf(1, 41, 42, 43, 44, 45)), // 낙첨
                )
            )
        ) { winningNumbers: List<Int>, lottoList: List<LottoTicket> ->
            val winningLotto = WinningLotto(winningNumbers)
            val lottoTickets = LottoTickets(lottoList)
            val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)

            val profitRate = lottoResultAnalytics.getProfitRate(lottoTickets.size())
            profitRate shouldBe 5.0
        }
    }
})
