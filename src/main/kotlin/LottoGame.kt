import model.Lotto
import model.Money

class LottoGame {
    fun buy(money: Money): List<Lotto> {
        val list = mutableListOf<Lotto>()

        repeat(money.getLottoCount()) { list.add(Lotto.make()) }

        return list.toList()
    }
}
