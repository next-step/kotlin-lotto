package lotto.domain.model

@JvmInline
value class Count(val value: Int) {
    init {
        require(value >= 0)
    }

    override fun toString(): String {
        return "$value"
    }
}
