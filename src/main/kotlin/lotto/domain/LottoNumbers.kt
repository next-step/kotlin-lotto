package lotto.domain

private const val VALID_LOTTO_SIZE = 6

class LottoNumbers(numbers: Set<LottoNumber>) {

    val numbers = numbers.toSet()

    constructor(numbers: Collection<LottoNumber>) : this(numbers.toSet())

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

@Suppress("FunctionName")
fun LottoNumbers(numbers: Collection<Int>): LottoNumbers {
    val lottoNumbers = numbers.mapTo(HashSet()) { LottoNumber.valueOf(it) }
    return LottoNumbers(lottoNumbers)
}

