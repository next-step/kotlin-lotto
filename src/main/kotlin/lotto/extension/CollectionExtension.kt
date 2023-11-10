package lotto.extension

import lotto.domain.Lotto
import lotto.domain.LottoReward

fun List<Lotto>.getPrice(): Int =
    this.size * Lotto.LOTTO_PRICE

fun List<LottoReward>.getAmount(): Int =
    this.sumOf { it.reward }
