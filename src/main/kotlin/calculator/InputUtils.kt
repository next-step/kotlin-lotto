@file: JvmName("InputUtils")

package calculator

const val NOT_ALLOW_LETTER = "정해진 자리 외 문자 입력 불가"
const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"

fun isBlank(text: String?): Boolean = text.isNullOrBlank()

fun checkIllegalLetter(tokens: List<String>) {
    tokens.forEach {
        if(Regex("[^0-9]+").find(it) != null) throw RuntimeException(NOT_ALLOW_LETTER)
    }
}

fun hasCustomDelimiter(text: String): Boolean {
    Regex("//(.)\\\\n").find(text) ?: return false
    return true
}
