package lotto.domain

class LottoGame(money: Int) {
    val count = money / PRICE
    private val lottoNums = mutableListOf<Lotto>()

    fun makeLottoNums(): MutableList<Lotto> {
        repeat(count) { lottoNums.add(Lotto.buy()) }
        return lottoNums
    }

    companion object {
        const val PRICE = 1000
    }
}
