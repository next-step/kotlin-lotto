import model.Lotto
import model.Money

class LottoGame {
    fun buy(money: Money): List<Lotto> {
        val list = mutableListOf<Lotto>()

        repeat(money.value / LOTTO_PRICE) {
            val lotto = Lotto.make()
            list.add(lotto)
        }

        return list.toList()
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
