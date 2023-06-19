package lotto

import lotto.vo.LottoNumber
import lotto.vo.Money

object LottoShop {
    val LOTTO_PRICE = Money(1000)

    fun sellLottos(cash: Money): Lottos {
        val amountOfLotto = cash.amount / LOTTO_PRICE.amount
        val generatedLottos = mutableListOf<Lotto>()
        repeat(amountOfLotto.toInt()) {
            generatedLottos.add(generateLotto())
        }

        return Lottos(generatedLottos)
    }

    private fun generateLotto(): Lotto {
        val lottoNums = (1..45).map(::LottoNumber).shuffled().subList(0, 6)

        return Lotto.from(lottoNums)
    }
}
