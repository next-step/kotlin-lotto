import model.*

class LottoGame {
    fun buy(money: Money, lottosGenerator: LottosGenerator): List<Lotto> {
        return lottosGenerator.generate(money)
    }

    fun match(list: List<Lotto>, winningLotto: WinningLotto, money: Money): WinningResult {
        return WinningResult(list, winningLotto, money)
    }
}
