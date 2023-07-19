package lottogame.ui

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class BenefitOutcomeTest {
    @Test
    fun `수익률이 1 이상이면 이익이다`() {
        val rateOfReturn = BigDecimal.valueOf(1)

        val benefitOutcome = BenefitOutcome.from(rateOfReturn)

        benefitOutcome shouldBe BenefitOutcome.GAIN
    }

    @Test
    fun `수익률이 1 미만이면 손해이다`() {
        val rateOfReturn = BigDecimal.valueOf(0.99)

        val benefitOutcome = BenefitOutcome.from(rateOfReturn)

        benefitOutcome shouldBe BenefitOutcome.LOSS
    }
}
