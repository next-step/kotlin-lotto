package lotto.domain.model

@JvmInline
value class NumberOfMatches(val value: Int) {
    override fun toString(): String {
        return value.toString()
    }
}
