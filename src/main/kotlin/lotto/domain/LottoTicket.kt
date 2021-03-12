package lotto.domain

class LottoTicket(lottoNumbers: List<LottoNumber>) {
    val value: List<LottoNumber> = lottoNumbers.sortedBy { it.value }

    fun getTicketRank(winningLotto: WinningLotto): Rank {
        val countOfMatch = getCountOfMatch(winningLotto.winningNumbers)
        val bonusMatches = isBonusNumberMatch(winningLotto.bonusNumber)
        return Rank.valueOf(countOfMatch, bonusMatches)
    }

    private fun getCountOfMatch(winningNumbers: List<LottoNumber>): Int {
        return value.count { lottoNumber ->
            winningNumbers.contains(lottoNumber)
        }
    }

    private fun isBonusNumberMatch(bonusNumber: LottoNumber): Boolean {
        return value.contains(bonusNumber)
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        fun generateAuto(): LottoTicket {
            val numbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().slice(0..5)

            return LottoTicket(
                numbers.map { number ->
                    LottoNumber(number)
                }
            )
        }

        fun generateManual(numbers: List<Int>): LottoTicket {
            return LottoTicket(
                numbers.map { number ->
                    LottoNumber(number)
                }
            )
        }
    }
}
