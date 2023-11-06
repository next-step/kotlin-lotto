package stringLettersCalculator

class StringNumber(
    private val numberString: String,
) {
    init {
        require(
            numberString.all { char ->
                char.isDigit()
            }
        ) {
            throw RuntimeException("0 이상의 정수만 입력해 주세요.")
        }
    }

    fun toInt(): Int = numberString.toInt()
}
