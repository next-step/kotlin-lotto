package lotto.domain

class LottoTicket(val lottoNumbers: Set<LottoNumber>) {

    constructor() : this(LottoNumber.generateNumbers())

    override fun toString(): String {
        return lottoNumbers.joinToString(",")
    }

    fun matchCount(winningNumbers: Set<LottoNumber>): Int {
        return lottoNumbers.count {
            winningNumbers.contains(it)
        }
    }

    fun contains(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    fun match(winningLotto: WinningLotto): PrizeResult {
        val matchedCount: Int = matchCount(winningLotto.winningNumbers)
        val isContainBonusNumber = contains(winningLotto.bonusNumber)

        return PrizeResult.findByMatch(matchedCount, isContainBonusNumber)
    }

    companion object {
        const val PRICE: Int = 1000
    }
}
