package lotto.domain

import lotto.domain.numberGenerator.LottoNumberGenerator

class Lottos(val lottoList: List<LottoNumbers>) {

    fun getSize(): Int {
        return lottoList.size
    }

    operator fun plus(other: Lottos): Lottos {
        return Lottos(this.lottoList + other.lottoList)
    }

    companion object {
        private const val PER_LOTTO_PRICE = 1000

        fun of(input: Int, lottoNumberGenerator: LottoNumberGenerator): Lottos {
            val count = input / PER_LOTTO_PRICE
            val lottoList = List(count) { LottoNumbers(lottoNumberGenerator.generateNumbers()) }
            return Lottos(lottoList)
        }
    }
}
