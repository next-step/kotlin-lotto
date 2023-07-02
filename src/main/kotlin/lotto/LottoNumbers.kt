package lotto

class LottoNumbers(numbers: List<LottoNumber>) {
    val numbers: Set<LottoNumber>

    init {
        require(numbers.size == SIZE) { LOTTO_NUMBERS_INVALID_SIZE_MESSAGE.format(numbers.size) }

        this.numbers = numbers.toSortedSet(compareBy(LottoNumber::number))

        require(this.numbers.size == numbers.size) { LOTTO_NUMBERS_DUPLICATE_MESSAGE.format(numbers.map { it.number }) }
    }

    fun match(other: LottoNumbers): Int {
        val intersect = numbers.intersect(other.numbers)
        return intersect.size
    }

    companion object {
        const val SIZE = 6
        const val LOTTO_NUMBERS_INVALID_SIZE_MESSAGE = "로또 번호는 6개의 숫자로 이루어져야 합니다. size:%d"
        const val LOTTO_NUMBERS_DUPLICATE_MESSAGE = "로또 번호는 중복된 숫자가 존재할 수 없습니다. numbers:%s"

        fun from(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber.from(it) })
        }
    }
}
