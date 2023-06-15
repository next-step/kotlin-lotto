package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.request.LottoOrderRequest

object AutoLottosGenerator : LottosGenerator {
    private const val START_INDEX = 0

    override fun generate(value: LottoOrderRequest): Lottos {
        val remainingMoney = Money(value.remainingMoney)

        return if (remainingMoney >= Lotto.PRICE) {
            val capacity = (remainingMoney / Lotto.PRICE).value

            return (0 until capacity).map { Lotto(generateRandom()) }
                .let(::Lottos)
        } else {
            Lottos.EMPTY_LOTTOS
        }
    }

    private fun generateRandom(): Set<LottoNumber> = LottoNumber.all().shuffled()
        .subList(START_INDEX, Lotto.VALID_LENGTH)
        .toSet()
}
