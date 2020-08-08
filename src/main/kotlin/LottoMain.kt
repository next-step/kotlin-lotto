import view.InputView

fun main() {
    val inputView = InputView()
    val money = inputView.getMoney { readLine() }
    println(money)
}
