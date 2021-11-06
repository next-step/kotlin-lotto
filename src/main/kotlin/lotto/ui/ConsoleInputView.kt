package lotto.ui

object ConsoleInputView {

    fun getBuyAmount(): Int {
        println("구입 금액을 입력해주세요.")
        return getInt()
    }

    fun getWinning(): List<Int> {
        println("지난주 당첨 번호를 입력해주세요.")
        return getInts()
    }

    fun getBonus(): Int {
        println("보너스 볼을 입력해 주세요.")
        return getInt()
    }

    private fun getInput(): String = requireNotNull(readLine())

    private fun getInt(): Int {
        return toInt(getInput())
    }

    private fun getInts(): List<Int> {
        return getInput().split(",")
            .map { toInt(it.trim()) }
    }

    private fun toInt(string: String): Int {
        return string.toIntOrNull() ?: throw IllegalArgumentException("$string 은/는 정수가 아닙니다.")
    }
}
