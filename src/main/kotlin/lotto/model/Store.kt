package lotto.model

class Store(private val buyer: Buyer) {

    fun confirmLottoWining(lottoNumbers: List<Int>): List<Prize> {
        val results = mutableListOf<Prize>()
        for (lotto in buyer.purchasedLottos) {
            val matchCount = lotto.numbers.count { lottoNumbers.contains(it) }
            results.add(Prize.findByMatchCount(matchCount))
        }
        return results
    }
}
