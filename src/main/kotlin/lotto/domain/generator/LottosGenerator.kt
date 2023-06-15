package lotto.domain.generator

import lotto.domain.Lottos
import lotto.domain.request.LottoOrderRequest

fun interface LottosGenerator {
    fun generate(value: LottoOrderRequest): Lottos
}
