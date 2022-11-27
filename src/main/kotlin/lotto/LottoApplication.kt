package lotto

fun main() {
    val inputView = InputView()
    val number = inputView.inputPrice()

    for (i in 1..number) {
        val drawList = LottoMachine().draw()
        println(drawList)
    }

    inputView.inputLastWeekWinningNumbers()

}