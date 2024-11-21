package lotto

object InputView {
    fun readMessage(message: String): String {
        println(message)
        return readlnOrNull() ?: ""
    }

    fun readCsvToInt(message: String): List<Int> {
        println(message)
        return readlnOrNull()?.split(",")?.map { it.trim().toInt() } ?: emptyList()
    }
}
