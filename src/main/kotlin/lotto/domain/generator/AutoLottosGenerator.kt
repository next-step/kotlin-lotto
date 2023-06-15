package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.request.LottoOrderRequest

object AutoLottosGenerator : LottosGenerator {

    override fun generate(value: LottoOrderRequest): Lottos {
        val remainingMoney = Money(value.remainingMoney)

        return if (remainingMoney >= Lotto.PRICE) {
            val capacity = (remainingMoney / Lotto.PRICE).value

            return List(capacity.toInt()) {
                Lotto(generateRandom())
            }.let(::Lottos)
        } else {
            Lottos.EMPTY_LOTTOS
        }
    }

    private fun generateRandom(): Set<LottoNumber> = LottoNumber.all().shuffled()
        .take(Lotto.VALID_LENGTH)
        .toSet()
}
