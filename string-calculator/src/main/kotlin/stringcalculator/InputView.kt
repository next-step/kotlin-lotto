package stringcalculator

object InputView {
    fun inputString(): String = readlnOrNull()?.takeIf { it.isNotBlank() }
        ?: throw RuntimeException("[InputView] 입력값이 null이거나 공백일 수 없습니다.")
}
