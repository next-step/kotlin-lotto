package lotto.domain.money

@JvmInline
value class Money(val value: Long) // 돈은 Long의 범위를 벗어날 만큼 큰 값이 입력 될 수 있지만 Long 까지만 고려

fun Iterable<Money>.sum(): Money {
    return Money(sumOf { it.value })
}
