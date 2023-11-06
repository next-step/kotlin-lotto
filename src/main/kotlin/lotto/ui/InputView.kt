package lotto.ui

class InputView {
    fun getNumbers() {
        println("구입금액을 입력해 주세요.")
        val money = readln().toInt()
    }

    fun getWinningNumbers(){
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
    }
}
