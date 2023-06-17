import view.InputView

fun main() {
    val inputView = InputView { readln() }
    val (winningNums, bonusBall) = setWinningInfo(inputView)
    LotteryRunner.startLotto(inputView.enterMoney(), winningNums, bonusBall)
}
private fun setWinningInfo(inputView: InputView): Pair<Set<Int>, Int> {
    val winningNums = inputView.registerWinningNums()
    val bonusBall = inputView.registerBonusBall()
    return Pair(winningNums, bonusBall)
}

fun getLotteriesSize(inputView: InputView): Int {
    val money = inputView.enterMoney()

    require(money > 1000) { "돈이 부족합니다." }

    val lottoSize = money / 1000
    println("${lottoSize}개를 구매했습니다.")

    return lottoSize
}
