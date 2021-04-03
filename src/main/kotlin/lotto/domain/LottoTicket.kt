package lotto.domain

import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER
import lotto.domain.result.MatchInfo

class LottoTicket(numbers: Set<LottoNumber>) {
    val numbers: Set<LottoNumber>

    init {
        validateSize(numbers)
        this.numbers = numbers
    }

    private fun validateSize(numbers: Set<LottoNumber>) {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 티켓은 로또 숫자 6개로 이루어져야 합니다." }
    }

    fun getMatchInfo(winningNumbers: LottoTicket, bonusNumber: LottoNumber): MatchInfo {
        val matchCount = winningNumbers.numbers.count { numbers.contains(it) }
        val hasBonus = winningNumbers.numbers.contains(bonusNumber)
        return MatchInfo.of(matchCount, hasBonus)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        private val lottoCache = object {
            val list = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).map { LottoNumber(it) }
        }

        fun create(shuffleStrategy: (List<LottoNumber>) -> List<LottoNumber>): LottoTicket {
            val numbers = HashSet<LottoNumber>()
            while (numbers.size != LOTTO_NUMBER_COUNT) {
                numbers.add(shuffleStrategy(lottoCache.list).first())
            }
            return LottoTicket(numbers)
        }
    }
}
