import model.*

class LottoGame {
    private var list: MutableList<Lotto> = mutableListOf()
    private lateinit var money: Money
    private lateinit var manual: LottoManual

    fun buy(money: Money, manual: LottoManual, manualLottoList: List<Lotto> = emptyList()): List<Lotto> {
        this.money = money
        this.manual = manual

        list.addAll(manualLottoList)
        repeat(autoMakeCount()) { list.add(Lotto.make()) }

        return list.toList()
    }

    fun autoMakeCount(): Int {
        return money.getAutoCreateCount(manual)
    }

    fun match(winningLotto: WinningLotto): WinningResult {
        return WinningResult(list, winningLotto, money)
    }
}
