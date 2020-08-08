import model.Lotto

class LottoGame {
    fun buy(money: Int): List<Lotto> {
        val list = mutableListOf<Lotto>()

        repeat(money / LOTTO_PRICE) {
            val lotto = Lotto.make()
            list.add(lotto)
        }

        return list.toList()
    }

    companion object {

        const val LOTTO_PRICE = 1_000
    }
}
