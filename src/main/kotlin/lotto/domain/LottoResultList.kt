package lotto.domain

data class LottoResultList(val resultList: List<LottoRank>) {
    fun count(rank: LottoRank) = resultList.count { it == rank }

    private val prizeMoney = run {
        var total = 0
        for (rank in LottoRank.values()) {
            total += count(rank) * rank.money
        }
        total
    }

    fun getProfitRate(purchase: Money): Float {
        return prizeMoney / purchase.amount.toFloat()
    }

    companion object {
        fun getResult(winningNumbers: WinningNumbers, lottoList: LottoList): LottoResultList {
            return LottoResultList(
                buildList {
                    for (lotto in lottoList.lottoList) {
                        add(LottoRank.of(winningNumbers, lotto.lottoNumbers))
                    }
                }
            )
        }
    }
}
