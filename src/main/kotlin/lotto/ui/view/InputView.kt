package lotto.ui.view

object InputView {
    fun getPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")

        return readLine()?.toIntOrNull() ?: 0
    }

    fun getWinningLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readLine()?.split(",")?.map{ stringNumber -> stringNumber.toInt() } ?: emptyList()
    }
}