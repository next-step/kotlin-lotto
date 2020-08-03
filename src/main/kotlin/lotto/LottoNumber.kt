package lotto

const val MAX_NUMBER = 45
const val MIN_NUMBER = 1

class LottoNumber(vararg _numbers: Int) {
    var numbers: List<Int>
        private set

    init {
        require(_numbers.size == 6) { "LottoNumber는 6개의 숫자가 필요합니다." }
        require(_numbers.distinct().size == 6) { "LottoNumber는 중복되지 않은 6개의 숫자가 필요합니다." }
        require(_numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "LottoNumber는 0이상 45이하의 숫자가 필요합니다." }

        numbers = listOf(*_numbers.toTypedArray())
    }
}
