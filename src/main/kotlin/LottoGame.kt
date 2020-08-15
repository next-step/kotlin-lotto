import model.Lotto
import model.Money
import model.WinningLotto
import model.WinningResult

class LottoGame {
    private var list: MutableList<Lotto> = mutableListOf()
    private lateinit var money: Money

    fun buy(money: Money): List<Lotto> {
        this.money = money

        repeat(money.getLottoCount()) { list.add(Lotto.make()) }

        return list.toList()
    }

    fun match(winningLotto: WinningLotto): WinningResult {
        return WinningResult(list, winningLotto, money)
    }
}
