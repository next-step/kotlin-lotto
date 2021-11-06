package lotto.domain.money

data class Won(override val value: Int) : Money {
    override val displayValue: String = "$value$MONETARY_UNIT"

    operator fun plus(other: Money) = Won(value + other.value)

    companion object {
        const val MONETARY_UNIT = "원"
    }
}
