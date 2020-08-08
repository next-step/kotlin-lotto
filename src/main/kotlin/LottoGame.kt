class LottoGame {
    fun buy(money: Int): List<Lotto> {
        val list = mutableListOf<Lotto>()

        repeat(money / LOTTO_PRICE) {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            list.add(lotto)
        }

        return list.toList()
    }

    class Lotto(val list: List<Int> = listOf(1, 2, 3, 4, 5, 6))

    companion object {

        const val LOTTO_PRICE = 1_000
    }
}
