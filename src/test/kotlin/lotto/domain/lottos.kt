package lotto.domain

fun lotto(vararg numbers: Int): Lotto {
    return Lotto.of(numbers.toList())
}

fun lottoCoupon(vararg numbers: Int): LottoCoupon {
    return LottoCoupon(
        Lotto.of(numbers.toList())
    )
}
