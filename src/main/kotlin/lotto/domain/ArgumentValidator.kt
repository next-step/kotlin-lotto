package lotto.domain

class ArgumentValidator(value: String) {
    val intValue: Int = value.toInt()
    init {
        require(value.isNotBlank()) { BLANK_ERROR_MESSAGE }
        require(value.toIntOrNull() != null) { NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요."
        const val BLANK_ERROR_MESSAGE = "입력값이 없습니다."
    }
}
