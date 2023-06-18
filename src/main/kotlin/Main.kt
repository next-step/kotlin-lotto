import view.InputView

fun main() {
    val inputView = InputView { readln() }
    val winningNums = setWinningInfo(inputView)
    LotteryRunner.startLotto(inputView.enterMoney(), winningNums)
}
private fun setWinningInfo(inputView: InputView): Set<Int> {
    return inputView.registerWinningNums()
}

fun getLotteriesSize(inputView: InputView): Int {
    val money = inputView.enterMoney()

    require(money > 1000) { "돈이 부족합니다." }

    val lottoSize = money / 1000
    println("${lottoSize}개를 구매했습니다.")

    return lottoSize
}
