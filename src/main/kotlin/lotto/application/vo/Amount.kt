package lotto.application.vo

private const val MIN_AMOUNT = 0

@JvmInline
value class Amount(val value: Long) {
    init {
        require(value >= MIN_AMOUNT) { "구입 금액은 $MIN_AMOUNT 이상이어야 합니다." }
    }

    operator fun plus(other: Amount): Amount = Amount(value + other.value)
}
