package lotto.statistics

import lotto.Lotto
import lotto.number.Numbers

fun getLotto(fromInts: List<Int>): Lotto = Lotto(numbers = Numbers.fromInts(fromInts))

fun getLotto(
    fromInts: List<Int>,
    size: Int,
    defaultValue: Int,
) = Lotto(Numbers.fromInts(fromInts + List(size = size) { defaultValue }))
