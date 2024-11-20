package stringcalculator

@JvmInline
value class Number(private val amount: Int) {
    init {
        require(amount in 0..100_000_000) { "숫자의 범위는 0 이상 1억 이하입니다." }
    }

    constructor(amountInput: String) : this(amountInput.toInt())

    fun plus(other: Number): Number {
        return Number(amount + other.amount)
    }
}
