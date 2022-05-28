package lotto.domain

object InputValidator {
    private const val ERROR_MSG_FOR_VALID_MANUAL_COUNT = "로또 개수는 %d개 이하로 입력해주세요"
    private const val ERROR_MSG_FOR_VALID_BONUS_NUMBER = "보너스볼은 1~45사이로 입력해주세요"
    private const val ERROR_MSG_FOR_WRONG_LOTTO = "로또 개수는 6개입니다 ,로 구분해주세요"
    private const val LOTTO_LIST_DELIMITER = ","
    private const val LOTTO_SIZE = 6
    private val LOTTO_RANGE = 1..45

    fun checkIsValidMoney(input: String) {
        require(input.toInt() > 0) { ERROR_MSG_FOR_VALID_BONUS_NUMBER }
    }

    fun checkValidBonusBall(input: String) {
        require(input.toInt() in LOTTO_RANGE) { ERROR_MSG_FOR_VALID_BONUS_NUMBER }
    }

    fun checkCountWithMax(input: String, max: Int) {
        require(input.toInt() <= max) {
            ERROR_MSG_FOR_VALID_MANUAL_COUNT.format(max)
        }
    }

    fun checkValidLotto(input: String) {
        val splitted = input.split(LOTTO_LIST_DELIMITER)
        require(splitted.size == LOTTO_SIZE) {
            ERROR_MSG_FOR_WRONG_LOTTO
        }
        require(splitted.all { it.toInt() in LOTTO_RANGE }) {
            ERROR_MSG_FOR_WRONG_LOTTO
        }
    }
}
