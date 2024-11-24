package lotto

object InputView {
    fun readMessage(message: String): String {
        println(message)
        return readlnOrNull() ?: throw IllegalArgumentException("입력이 없습니다.")
    }

    fun readCsvToInt(message: String): List<Int> {
        println(message)
        val input = readlnOrNull() ?: throw IllegalArgumentException("입력이 없습니다.")

        return input.split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 값: '$it'. 입력은 ','로 구분된 숫자여야 합니다.")
            }
    }
}
