package lotto.domain

import lotto.domain.strategy.NumberGenerateStrategy

class LottoTicket private constructor(val numbers: Set<LottoNumber>) {
    fun getMatchCount(lottoNumbers: List<LottoNumber>): Int {
        return lottoNumbers.filter { numbers.contains(it) }.count()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val lottoCache = object {
            val list = (1..45).map { LottoNumber(it) }
        }

        fun create(numberStrategy: NumberGenerateStrategy): LottoTicket {
            val numbers = HashSet<LottoNumber>()
            while (numbers.size != LOTTO_NUMBER_COUNT) {
                numbers.add(lottoCache.list[numberStrategy.generate() - 1])
            }
            return LottoTicket(numbers)
        }
    }
}
