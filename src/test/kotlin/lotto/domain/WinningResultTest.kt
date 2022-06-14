package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningAmount.FIRST
import lotto.domain.WinningAmount.FOURTH
import lotto.domain.WinningAmount.MISS
import lotto.domain.WinningAmount.SECOND
import lotto.domain.WinningAmount.THIRD
import java.math.BigDecimal

internal class WinningResultTest : StringSpec({

    "수익률은 소수점 아래 둘째자리까지만 구한 후 버린다." {
        // given
        val winningResult = WinningResult(
            amountWithWinnings = mapOf(
                Pair(FIRST, 0),
                Pair(SECOND, 0),
                Pair(THIRD, 0),
                Pair(FOURTH, 1),
                Pair(MISS, 13),
            )
        )

        // when
        val yield = winningResult.calculateYield()

        // then
        `yield` shouldBe BigDecimal.valueOf(0.35)
    }
})
