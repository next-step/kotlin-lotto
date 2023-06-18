package lotto.domain

import lotto.domain.numberGenerator.NumberGenerator
import lotto.domain.numberGenerator.RandomLottoNumberGenerator

class Lottos private constructor(val lottoList: List<LottoNumbers>) {

    fun getSize(): Int {
        return lottoList.size
    }

    companion object {
        const val PER_LOTTO_PRICE = 1000

        fun of(input: Int, numberGenerator: NumberGenerator = RandomLottoNumberGenerator()): Lottos {
            val count = input / PER_LOTTO_PRICE
            val lottoList = List(count) { LottoNumbers(numberGenerator) }
            return Lottos(lottoList)
        }
    }
}
