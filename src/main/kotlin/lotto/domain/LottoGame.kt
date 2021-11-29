package lotto.domain

class LottoGame(private val money: Int) {
    val count = money / PRICE

    fun getLottoNums(): MutableList<Lotto> {
        val lottoNums = mutableListOf<Lotto>()
        repeat(count) { lottoNums.add(Lotto()) }
        return lottoNums
    }

    companion object {
        const val PRICE = 1000
    }
}
