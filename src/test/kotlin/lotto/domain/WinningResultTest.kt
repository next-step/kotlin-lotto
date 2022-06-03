package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningAmount.FOURTH
import lotto.domain.WinningAmount.MISS
import java.math.BigDecimal

internal class WinningResultTest : StringSpec({

    "수익률은 소수점 아래 둘째자리까지만 구한 후 버린다." {
        // given
        val winningAmountMap = WinningAmount.values().associateWith { 0 }.toMutableMap()
        winningAmountMap[FOURTH] = winningAmountMap[FOURTH]!! + 1
        winningAmountMap[MISS] = winningAmountMap[MISS]!! + 13

        val winningResult = WinningResult(values = winningAmountMap)

        // when
        val yield = winningResult.calculateYield()

        // then
        `yield` shouldBe BigDecimal.valueOf(0.35)
    }
})
