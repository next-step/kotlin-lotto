package lotto.domain

class LottoTicket(numbers: List<Int>) {

    val lottoNumbers: List<LottoNumber>

    init {
        require(numbers.size == NUMBER_SIZE) { "숫자의 개수는 6개여야 합니다." }
        require(numbers.size == numbers.distinct().size) { "숫자가 중복될 수 없습니다." }
        lottoNumbers = numbers.map { LottoNumber(it) }
    }

    companion object {
        const val NUMBER_SIZE = 6
    }
}
