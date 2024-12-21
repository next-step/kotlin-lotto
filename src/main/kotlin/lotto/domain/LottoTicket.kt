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
        private const val DELIMITER = ","

        fun generateLottoNumber(): LottoTicket {
            val lottoNumbers =
                (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
                    .shuffled()
                    .take(LOTTO_TICKET_SIZE)
                    .map { LottoNumber.from(it) }
                    .toSet()
            return LottoTicket(lottoNumbers)
        }

        fun makeLottoTicket(line: String): LottoTicket {
            val numbers =
                line.split(DELIMITER)
                    .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자여야 합니다.") }
            return from(numbers.toSet())
        }

        fun from(numbers: Set<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber(it) }.toSet())
        }
    }
}
