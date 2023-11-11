package lotto

object LottoNumber {
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val ERR_MSG_OUT_OF_LOTTO_RANGE = "로또의 범위를 넘어서는 번호입니다."

    fun validateRange(number: Int) {
        require(number in MIN_NUMBER..MAX_NUMBER) { ERR_MSG_OUT_OF_LOTTO_RANGE }
    }
}
