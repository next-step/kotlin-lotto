package lotto.ui

import java.math.BigDecimal

enum class BenefitOutcome(
    val description: String,
    val predicate: (BigDecimal) -> Boolean,
) {
    GAIN("이익", { it >= BigDecimal.ONE }),
    LOSS("손해", { it < BigDecimal.ONE }),
    ;

    companion object {
        fun from(rateOfReturn: BigDecimal): BenefitOutcome {
            return values().first { it.predicate(rateOfReturn) }
        }
    }
}
