package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoStatisticSpec : DescribeSpec({
    describe("로또 통계") {
        context("로또 결과와 당첨 번호로 로또 통계를 생성하면") {
            val lottos = Lottos(
                listOf(
                    Lotto(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                ),
            )
            val winningNumbers = setOf(1, 2, 3, 30, 31, 32)

            val lottoStatistic = LottoStatistic(lottos = lottos, winningNumbers = winningNumbers)
            it("로또 결과를 확인할 수 있다.") {
                lottoStatistic.result.numberOfFirst shouldBe 0
                lottoStatistic.result.numberOfThird shouldBe 0
                lottoStatistic.result.numberOfFourth shouldBe 0
                lottoStatistic.result.numberOfFifth shouldBe 1
            }

            it("수익율을 확인할 수 있다.") {
                lottoStatistic.returnOfRate shouldBe 1.0
            }
        }
    }
})
