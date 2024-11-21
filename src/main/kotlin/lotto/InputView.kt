package lotto

class InputView(private val template: String) {
    fun read(): String {
        println(template)
        return readlnOrNull() ?: throw IllegalArgumentException("입력이 없습니다.")
    }

    fun readCsvToInt(): List<Int> {
        return read().split(",")
            .map { it.toInt() }
    }
}
