package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class 당첨_통계_테스트 : StringSpec({

    "로또 5개를 구입할 때 1등 당첨 1번 + 2등 당첨 1번 + 3등 당첨 2번 + 4등 당첨 1번 + 낙첨 1번이면," +
            "당첨 통계 계산 로직은 총 당첨된 횟수 만큼 통계를 반환한다" {
                forAll(
                    row(
                        listOf(1, 2, 3, 4, 5, 6),
                        30,
                        listOf(
                            LottoTicket(listOf(1, 2, 3, 4, 5, 6)), // 1등 당첨
                            LottoTicket(listOf(1, 2, 3, 4, 5, 30)), // 2등 당첨
                            LottoTicket(listOf(1, 2, 3, 4, 5, 45)), // 3등 당첨
                            LottoTicket(listOf(1, 2, 3, 4, 45, 6)), // 4등 당첨
                            LottoTicket(listOf(1, 2, 3, 4, 44, 45)), // 5등 당첨
                            LottoTicket(listOf(1, 41, 42, 43, 44, 45)) // 낙첨
                        )
                    )
                ) { winningNumbers: List<Int>, bonusNumber: Int, lottoList: List<LottoTicket> ->
                    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
                    val lottoTickets = LottoTickets(lottoList)
                    val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)

                    val winningStatistics = lottoResultAnalytics.getWinningStatistics()
                    winningStatistics.get(LottoRanking.FIRST) shouldBe 1
                    winningStatistics.get(LottoRanking.SECOND) shouldBe 1
                    winningStatistics.get(LottoRanking.THIRD) shouldBe 2
                    winningStatistics.get(LottoRanking.FOURTH) shouldBe 1
                    winningStatistics.get(LottoRanking.FIFTH) shouldBe 0
                    winningStatistics.get(LottoRanking.MISS) shouldBe 1
                }
            }
})

class 수익률_계산_테스트 : StringSpec({

    "로또 10개를 구입할 때 5등 당첨 1번 + 낙첨 9번이면, 수익률은 0.5이다. " {
        forAll(
            row(
                listOf(1, 2, 3, 4, 5, 6),
                30,
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
        ) { winningNumbers: List<Int>, bonusNumber: Int, lottoList: List<LottoTicket> ->
            val winningLotto = WinningLotto(winningNumbers, bonusNumber)
            val lottoTickets = LottoTickets(lottoList)
            val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)

            val profitRate = lottoResultAnalytics.getProfitRate(lottoTickets.size() * LottoPolicy.LOTTO_PRICE)
            profitRate shouldBe 0.5
        }
    }

    "로또 10개를 구입할 때 4등 당첨 1번 + 낙첨 9번이면, 수익률은 5.0이다. " {
        forAll(
            row(
                listOf(1, 2, 3, 4, 5, 6),
                30,
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
        ) { winningNumbers: List<Int>, bonusNumber: Int, lottoList: List<LottoTicket> ->
            val winningLotto = WinningLotto(winningNumbers, bonusNumber)
            val lottoTickets = LottoTickets(lottoList)
            val lottoResultAnalytics = winningLotto.createResultAnalytics(lottoTickets)

            val profitRate = lottoResultAnalytics.getProfitRate(lottoTickets.size() * LottoPolicy.LOTTO_PRICE)
            profitRate shouldBe 5.0
        }
    }
})
