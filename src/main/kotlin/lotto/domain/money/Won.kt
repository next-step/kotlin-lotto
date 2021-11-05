package lotto.domain.money

data class Won(override val value: Int) : Money {
    override val displayValue: String = "$value$MONETARY_UNIT"

    companion object {
        const val MONETARY_UNIT = "원"
    }
}
