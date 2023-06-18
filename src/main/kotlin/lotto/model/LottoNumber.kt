package lotto.model

data class LottoNumber(val number: Int) {

    init {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) {
            "로또 숫자는 $LOTTO_NUMBER_MIN 이상 $LOTTO_NUMBER_MAX 이하 이어야 합니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
    }
}
