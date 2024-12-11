package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_MAX_NUMBER
import lotto.domain.LottoNumber.Companion.LOTTO_MIN_NUMBER

class LottoTicket(numbers: List<Int>) : Collection<Int> by numbers {
    private val _lottoNumbers: Set<Int>
    val lottoNumbers: Set<Int>
        get() = _lottoNumbers.toSet()

    init {
        require(
            numbers.size == LOTTO_TICKET_SIZE && numbers.toSet().size == LOTTO_TICKET_SIZE,
        ) {
            "로또 티켓 번호가 잘못 입력되었습니다"
        }
        _lottoNumbers = numbers.toSortedSet()
    }

    fun calculateRank(winningLotto: WinningLotto): LottoRank {
        val matchCount = winningLotto.calculateMatchCount(this)
        return LottoRank.getRank(matchCount)
    }

    companion object {
        const val LOTTO_TICKET_SIZE = 6

        fun generateLottoNumber(): LottoTicket {
            val lottoNumbers =
                (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
                    .shuffled()
                    .take(LOTTO_TICKET_SIZE)
            return LottoTicket(lottoNumbers)
        }
    }
}
