package lotto.dto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoRank
import lotto.domain.Money

class WinningStatDtoTest : DescribeSpec({
    it("당첨 통계는 당첨 정책, 총합 당첨 횟수, 총합 당첨 금액을 가지고 있다") {
        // given
        val wonRank = LottoRank.THIRD
        val totalWinningCount = 30
        val winningStat = WinningStatDto(wonRank, totalWinningCount)
        val winningPrize: Long = wonRank.wonPrize.value

        // then
        winningStat.totalWinningPrize shouldBe Money(winningPrize * totalWinningCount)
    }
})
