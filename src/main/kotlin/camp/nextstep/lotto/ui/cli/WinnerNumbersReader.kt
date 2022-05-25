package camp.nextstep.lotto.ui.cli

object WinnerNumbersReader {

    fun read(numbers: Int): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val readLine = requireNotNull(readLine())
        val winnerNumbers = readLine.split(",").map { it.trim().toInt() }
        require(winnerNumbers.size == numbers) { "$numbers 개의 당첨 번호를 입력해주세요." }
        return winnerNumbers
    }
}
