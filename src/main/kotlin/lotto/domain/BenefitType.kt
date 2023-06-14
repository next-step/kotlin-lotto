package lotto.domain

private typealias BenefitCondition = (Double) -> Boolean

enum class BenefitType(
    private val benefitCondition: BenefitCondition,
    val exposureName: String,
) {
    GAIN(
        benefitCondition = { rateOfReturn -> rateOfReturn >= 1.0 },
        exposureName = "이득",
    ),
    LOSS(
        benefitCondition = { rateOfReturn -> rateOfReturn < 1.0 },
        exposureName = "손해",
    ),
    ;

    companion object {
        fun valueOf(rateOfReturn: Double): BenefitType = values().find { it.benefitCondition(rateOfReturn) } ?: LOSS
    }
}
