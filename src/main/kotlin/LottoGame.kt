import model.Lotto
import model.Money
import model.WinningLotto
import model.WinningResult

class LottoGame {
    private var _list: MutableList<Lotto> = mutableListOf()
    private lateinit var _money: Money

    fun buy(money: Money): List<Lotto> {
        _money = money

        repeat(money.getLottoCount()) { _list.add(Lotto.make()) }

        return _list.toList()
    }

    fun match(winningLotto: WinningLotto): WinningResult {
        return WinningResult(_list, winningLotto, _money)
    }
}
