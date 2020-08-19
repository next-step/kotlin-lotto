package lotto.domain

class LottoTicket(val lottoNumbers: Set<LottoNumber>) {

    constructor(list: List<String>) : this(list.map { LottoNumber.get(it.toInt()) }.toSet())

    override fun toString(): String {
        return lottoNumbers.joinToString(",")
    }

    fun matchCount(winningNumbers: LottoTicket): Int {
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
