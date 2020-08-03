package lotto

const val MAX_NUMBER = 45
const val MIN_NUMBER = 1
const val LOTTO_COUNT = 6

class LottoNumber(vararg _numbers: Int) {
    constructor(_numbers: List<Int>) : this(*_numbers.toIntArray())

    var numbers: List<Int>
        private set

    init {
        require(_numbers.size == LOTTO_COUNT) { "LottoNumber는 ${LOTTO_COUNT}개의 숫자가 필요합니다." }
        require(_numbers.distinct().size == LOTTO_COUNT) { "LottoNumber는 중복되지 않은 ${LOTTO_COUNT}개의 숫자가 필요합니다." }
        require(_numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "LottoNumber는 ${MIN_NUMBER}이상 ${MAX_NUMBER}이하의 숫자가 필요합니다." }

        numbers = listOf(*_numbers.toTypedArray())
    }

    fun equalsCount(winningNumber: LottoNumber): Int {
        return numbers.intersect(winningNumber.numbers).count()
    }
}
