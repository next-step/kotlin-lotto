package lotto.domain

fun lotto(vararg numbers: Int): Lotto {
    return Lotto.of(numbers.toList())
}
