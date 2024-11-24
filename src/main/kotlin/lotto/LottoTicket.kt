package lotto

class LottoTicket(numbers: List<LottoNumber>) {
    val numbers: List<LottoNumber> = numbers.sorted()

    init {
        require(numbers.size == 6) {
            "로또 번호는 총 6개여야 합니다"
        }
        require(numbers.size == numbers.distinct().size) {
            "로또 번호는 모두 서로 다른 번호여야 합니다"
        }
    }

    fun countOfMatches(other: LottoTicket): Int {
        val lottoNumbersOfMatches = this.numbers intersect other.numbers.toSet()
        return lottoNumbersOfMatches.size
    }

    fun matchesBonusBall(bonusNumber: LottoNumber): Boolean = bonusNumber in numbers
}
