package lotto.view

object InputView {
    fun readCash(): Int {
        return readInt("구입금액을 입력해 주세요.")
    }

    fun readLastWeekMatchNumbers(): Pair<List<Int>, Int> {
        val numbers = readListOfInt("지난 주 당첨 번호를 입력해 주세요.")
        val bonusNumber = readInt("보너스 볼을 입력해 주세요.")
        return numbers to bonusNumber
    }

    private fun readInt(question: String): Int {
        println(question)
        return readln().toIntOrThrow()
    }

    private fun readListOfInt(question: String): List<Int> {
        println(question)
        return readln().split(",")
            .map {
                it.trim()
            }.map {
                it.toIntOrThrow()
            }
    }

    private fun String.toIntOrThrow(): Int = toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값일 수 없습니다.")
}
