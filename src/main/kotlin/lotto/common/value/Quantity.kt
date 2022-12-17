package lotto.common.value

@JvmInline
value class Quantity(
    val value: Long
) {

    init {
        require(value >= 0) { "수량의 값은 0보다 큰 정수여야 합니다" }
    }
}
