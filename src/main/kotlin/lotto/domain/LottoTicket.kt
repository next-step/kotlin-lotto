package lotto.domain

class LottoTicket(numbers: List<Int>) {

    val lottoNumbers: List<LottoNumber>

    init {
        require(numbers.size == NUMBER_SIZE) { "숫자의 개수는 ${NUMBER_SIZE}개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { "숫자가 중복될 수 없습니다." }
        lottoNumbers = numbers.map { LottoNumber(it) }
    }

    fun contains(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }

    companion object {
        const val NUMBER_SIZE = 6
    }
}
