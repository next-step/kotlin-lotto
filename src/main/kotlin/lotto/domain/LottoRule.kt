package lotto.domain

object LottoRule {
    const val LOTTO_NUMBER_COUNT = 6
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45

    fun validate(numbers: Set<Int>) {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다." }
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) {
            "로또 번호는 ${LOTTO_NUMBER_MIN}부터 $LOTTO_NUMBER_MAX 사이여야 합니다."
        }
    }

    fun validate(number: Int) {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) {
            "로또 번호는 ${LOTTO_NUMBER_MIN}부터 $LOTTO_NUMBER_MAX 사이여야 합니다."
        }
    }
}
