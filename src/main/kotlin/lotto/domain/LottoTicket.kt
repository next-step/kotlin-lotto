package lotto.domain

import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER

class LottoTicket(val value: List<LottoNumber>) {

    init {
        checkValidateLottoTicket()
    }

    private fun checkValidateLottoTicket() {
        if(value.size != LENGTH_OF_LOTTO) throw RuntimeException("로또의 숫자는 6개가 존재해야 합니다.")
    }

    fun getTicketRank(winningLotto: WinningLotto): Rank {
        val countOfMatch = getCountOfMatch(winningLotto.winningNumbers.value)
        val bonusMatches = isBonusNumberMatch(winningLotto.bonusNumber)
        return Rank.valueOf(countOfMatch, bonusMatches)
    }

    private fun getCountOfMatch(lottoNumbers: List<LottoNumber>): Int {
        return value.count { lottoNumber ->
            lottoNumbers.contains(lottoNumber)
        }
    }

    private fun isBonusNumberMatch(bonusNumber: LottoNumber): Boolean {
        return value.contains(bonusNumber)
    }

    companion object {
        private val LENGTH_OF_LOTTO = 6

        fun generateAuto(): LottoTicket {
            val numbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
                .shuffled()
                .take(LENGTH_OF_LOTTO)
                .sorted()

            return LottoTicket(
                numbers.map { number ->
                    LottoNumber.from(number)
                }
            )
        }

        fun generateManual(numbers: List<Int>): LottoTicket {
            return LottoTicket(
                numbers.map { number ->
                    LottoNumber.from(number)
                }
            )
        }
    }
}
