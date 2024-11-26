package lotto

class LottoTicket(numbers: List<LottoNumber>) {
    private val _numbers: Set<LottoNumber> = numbers.toSortedSet()

    val numbers: List<LottoNumber>
        get() = _numbers.toList() // Getter에서 정렬된 List 반환

    constructor(vararg numbers: Int) : this(numbers.toList().map(::LottoNumber))

    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE) {
            "로또 번호는 총 6개여야 합니다"
        }
        require(numbers.size == _numbers.size) {
            "로또 번호는 모두 서로 다른 번호여야 합니다"
        }
    }

    fun countOfMatches(other: LottoTicket): Int {
        val lottoNumbersOfMatches = this._numbers intersect other._numbers
        return lottoNumbersOfMatches.size
    }

    fun contain(lottoNumber: LottoNumber): Boolean = lottoNumber in _numbers

    override fun toString(): String {
        return "LottoTicket(numbers=$numbers)"
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
