import view.InputView

fun main() {
    val inputView = InputView { readln() }
    LotteryRunner(inputView).startLotto()
}
