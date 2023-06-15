package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.request.LottoOrderRequest

object ManualLottosGenerator : LottosGenerator {

    override fun generate(value: LottoOrderRequest): Lottos =
        value.manualNumbersList.map { Lotto(generateManual(it)) }.let(::Lottos)

    private fun generateManual(input: List<String>): Set<LottoNumber> =
        input.map(String::toInt).map(LottoNumber::valueOf).toSet()
}
