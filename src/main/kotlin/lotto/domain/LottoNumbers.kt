package lotto.domain

private const val VALID_LOTTO_SIZE = 6

class LottoNumbers(numbers: Collection<Int>) {

    val numbers: Set<LottoNumber> = numbers.mapTo(HashSet()) { LottoNumber(it) }

    init {
        require(this.numbers.size == VALID_LOTTO_SIZE) { "로또 번호는 6자리로 이뤄집니다." }
    }

    fun countSameNumber(other: LottoNumbers): Int {
        return (numbers intersect other.numbers).size
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }
}

