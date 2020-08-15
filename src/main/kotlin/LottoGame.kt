import model.*

class LottoGame {
    private var list: MutableList<Lotto> = mutableListOf()
    private lateinit var money: Money
    private lateinit var manual: LottoManual

    fun buy(money: Money, manual: LottoManual): List<Lotto> {
        this.money = money
        this.manual = manual

        repeat(money.getAutoCreateCount(manual)) { list.add(Lotto.make()) }

        return list.toList()
    }

    fun match(winningLotto: WinningLotto): WinningResult {
        return WinningResult(list, winningLotto, money)
    }
}
