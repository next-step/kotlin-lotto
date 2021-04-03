package lotto.view

object InputView {
    private fun readLine(message: String): String {
        var input: String? = null

        while (input.isNullOrBlank()) {
            if (message.isNotEmpty()) {
                println(message)
            }
            input = readLine()
        }

        return input
    }

    fun readMoney(): Int {
        return readLine("구입금액을 입력해 주세요.").toInt()
    }

    fun readManualTicketCount(): Int {
        return readLine("수동으로 구매할 로또 수를 입력해 주세요.").toInt()
    }

    fun readWinningNumbers(): List<Int> {
        return readLine("지난 주 당첨 번호를 입력해 주세요.").split(",").map { it.toInt() }
    }

    fun readBonusNumber(): Int {
        return readLine("보너스 볼을 입력해 주세요.").toInt()
    }

    fun readListOfCandidateNumbers(times: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return (1..times).map {
            readLine("").split(",").map { it.toInt() }
        }
    }
}
