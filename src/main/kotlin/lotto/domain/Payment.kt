package lotto.domain

private const val MIN = 1000

@JvmInline
value class Payment(val value: Int) {
    init {
        require(value % MIN == 0) { "지불금액 단위는 1000원입니다." }
    }

    fun toDouble(): Double {
        return value.toDouble()
    }
}
