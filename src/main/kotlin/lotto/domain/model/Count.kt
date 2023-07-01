package lotto.domain.model

@JvmInline
value class Count(val value: Int) {
    init {
        require(value >= 0) { "음수가 될 수 없습니다" }
    }

    override fun toString(): String {
        return "$value"
    }

    operator fun times(money: Money): Int {
        return value * money.value
    }
}
