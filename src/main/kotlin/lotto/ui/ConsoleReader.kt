package lotto.ui

object ConsoleReader {
    fun readLine(): String {
        return readlnOrNull()
            ?: throw IllegalArgumentException("null을 입력할 수 없습니다.")
    }
}
