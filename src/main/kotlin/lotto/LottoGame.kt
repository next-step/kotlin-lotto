package lotto

class LottoGame {

    fun getLottoCount(amount: Int): Int {
        return amount / PRICE_PER_LOTTO
    }

    fun getLottoList(count: Int): List<Lotto> {
        return mutableListOf<Lotto>().apply {
            repeat(count) {
                this.add(Lotto.of())
            }
        }
    }

    fun result(lottoList: List<Lotto>, lastLotto: Lotto): List<LottoResult?> {
        return lottoList.map { lotto ->
            val count = lotto.numbers.intersect(lastLotto.numbers).count()
            LottoResult.findByMatchCount(count)
        }
    }

    fun getTotalWinningMoney(result: List<LottoResult?>): Int {
        return result.sumOf { it?.matchResult?.winningMoney?.times(it.count) ?: 0 }
    }

    companion object {
        private const val PRICE_PER_LOTTO = 1000
    }
}
