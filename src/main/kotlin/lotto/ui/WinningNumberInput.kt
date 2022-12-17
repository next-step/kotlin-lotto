package lotto.ui

class WinningNumberInput(value: String = "") : UI {
    var value: String = value
        private set

    override fun draw() {
        println("지난 주 당첨 번호를 입력해 주세요.")
        this.value = readLine()!!
    }

    fun getNumbers(): List<Int> {
        return value
            .split(",")
            .filter { it.isNotBlank() }
            .map {
                val trimmed = it.trim()
                trimmed.toIntOrNull() ?: throw IllegalStateException()
            }
    }
}
