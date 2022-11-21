package stringcalculator

data class InputNumber(
    val value: Int
) {
    constructor(string: String) : this(string.toInt())

    init {
        require(value >= 0) {
            throw RuntimeException("error : $value $NEGATIVE_NOT_ALLOWED_MESSAGE")
        }
    }

    companion object {
        const val NEGATIVE_NOT_ALLOWED_MESSAGE = "0과 양의 정수 입력만 허용"
    }
}
