package lotto.view

object InputView {
    fun getTicketCount(): Int {
        println("구입금액을 입력해 주세요.")
        val count = readln().toInt() / 1000
        println("${count}개를 구매했습니다.")
        return count
    }

    fun getWinningNumbers(ticketLength: Int): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val numbers = readln().split(",").map { it.trim().toInt() }

        require(numbers.size == ticketLength) { "당첨 번호는 ${ticketLength}개 여야 합니다" }

        return numbers
    }
}
