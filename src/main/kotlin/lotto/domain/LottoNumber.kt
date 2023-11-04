package lotto.domain

data class LottoNumber(val value: Int) {

    init {
        require(value in MIN_VALUE..MAX_VALUE) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
    }
}

class LottoNumbers(
    val numbers: List<LottoNumber>
) {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getMatchCount(it: LottoNumbers): Int = numbers.intersect(it.numbers.toSet()).count()

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
