package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Price

class LottoMachine(
    private val lottoGenerator: LottoGenerator,
) {

    fun automaticBuy(automaticCount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(automaticCount) {
            val lottoNumbers = (MIN_NUMBER..MAX_NUMBER)
                .shuffled()
                .subList(START_INDEX, END_INDEX)
                .sorted()
                .map { number -> LottoNumber(number) }
            val lotto = lottoGenerator.generate(
                numbers = lottoNumbers,
                price = Price(LOTTO_PRICE)
            )

            lottos.add(lotto)
        }

        return lottos.toList()
    }

    fun passivityBuy(
        passivityLottoNumbers: List<List<LottoNumber>>
    ): List<Lotto> {
        return passivityLottoNumbers.map { passivityLottoNumber ->
            lottoGenerator.generate(
                numbers = passivityLottoNumber,
                price = Price(LOTTO_PRICE),
            )
        }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val START_INDEX = 0
        private const val END_INDEX = 6
        const val LOTTO_PRICE = 1000
    }
}
