package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.EarningRate
import java.math.BigDecimal
import java.math.RoundingMode

class EarningRateTest : StringSpec({

    "14000원을 투자해서 5000원을 벌어들인 경우 0.35의 수익률이 발생해야한다" {
        val earningRate = EarningRate { result ->
            val decimal = result.toBigDecimal()
            decimal.setScale(2, RoundingMode.DOWN)
        }
        val result = earningRate.calculate(14000, 5000)
        result shouldBe BigDecimal.valueOf(0.35)
    }
})
