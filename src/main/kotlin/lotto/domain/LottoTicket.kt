package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_MAX_NUMBER
import lotto.domain.LottoNumber.Companion.LOTTO_MIN_NUMBER

data class LottoTicket(private val numbers: Set<LottoNumber>) : Collection<LottoNumber> by numbers {
    constructor(numbers: List<LottoNumber>) : this(numbers.toSet())

    init {
        require(numbers.size == LOTTO_TICKET_SIZE) { "로또 티켓 번호가 잘못 입력되었습니다" }
    }

    fun calculateRank(winningLotto: WinningLotto): LottoRank {
        val matchCount = winningLotto.calculateMatchCount(numbers)
        val isMatchedBonus = winningLotto.isMatchedBonusNumber(numbers)
        return LottoRank.getRank(matchCount, isMatchedBonus)
    }

    companion object {
        const val LOTTO_TICKET_SIZE = 6

        fun generateLottoNumber(): LottoTicket {
            val lottoNumbers =
                (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
                    .shuffled()
                    .take(LOTTO_TICKET_SIZE)
                    .map { LottoNumber.from(it) }
                    .toSet()
            return LottoTicket(lottoNumbers)
        }

        fun from(numbers: Set<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber.from(it) }.toSet())
        }
    }
}
