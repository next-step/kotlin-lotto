package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.enums.RankType
import lotto.enums.RankType.FIRST_RANK
import lotto.enums.RankType.FOURTH_RANK
import lotto.enums.RankType.NO_RANK
import lotto.enums.RankType.THIRD_RANK

class StatisticsTest : DescribeSpec({
    describe("Statistics test") {
        context("lottoRank Test") {
            it("사용자가 구매한 로또번호 리스트의 등수를 계산한다") {
                val winningLotto = Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6))
                val userLottos =
                    listOf(
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 7)),
                    )

                val actual: Map<RankType, Int> = Statistics.lottoRank(userLottos, winningLotto)

                actual[NO_RANK] shouldBe 0
                actual[FIRST_RANK] shouldBe 3
                actual[THIRD_RANK] shouldBe 1
                actual[FOURTH_RANK] shouldBe 0
                actual[NO_RANK] shouldBe 0
            }
        }
    }
})
