package lotto

fun List<Lotto>.getPrice(): Int =
    this.size * Lotto.LOTTO_PRICE

fun List<LottoReward>.getAmount(): Int =
    this.sumOf { it.reward }
