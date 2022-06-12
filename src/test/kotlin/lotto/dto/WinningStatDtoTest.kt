package lotto.dto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoPrizePolicy
import lotto.domain.Money

class WinningStatDtoTest : DescribeSpec({
    it("당첨 통계는 당첨 정책, 총합 당첨 횟수, 총합 당첨 금액을 가지고 있다") {
        // given
        val winningPrize: Long = 5000
        val totalWinningCount = 30
        val winningStat = WinningStatDto(LottoPrizePolicy(3, Money(winningPrize)), totalWinningCount)

        // then
        winningStat.totalWinningPrize shouldBe Money(winningPrize * totalWinningCount)
    }
})
