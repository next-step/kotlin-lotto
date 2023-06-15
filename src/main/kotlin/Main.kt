import view.InputView

fun main() {
    val inputView = InputView { readln() }
    LottoRunner(inputView).startLotto()
}
