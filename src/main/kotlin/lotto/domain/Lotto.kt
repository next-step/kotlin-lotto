package lotto.domain

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 ${LOTTO_NUMBER_SIZE}개만 가능합니다." }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { "로또 번호는 1~45 사이의 숫자만 가능합니다." }
    }
    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
    }
}
