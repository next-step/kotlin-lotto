package lotto

object InputView {
    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }
    fun inputLastWeekWinningNumbers(): WinningLottoNumbers {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val inputLastWeekWinningNumbers = readln()
        val parse = Parser().parse(inputLastWeekWinningNumbers).toSet()
        return WinningLottoNumbers(parse)
    }
}
