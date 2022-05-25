package lotto.domain

fun lotto(vararg numbers: Int): Lotto {
    return Lotto.of(numbers.toList())
}

fun lottoCoupon(vararg number: Int): LottoCoupon {
    return LottoCoupon(
        number.map { LottoNumber(it) }
            .toSet()
    )
}
