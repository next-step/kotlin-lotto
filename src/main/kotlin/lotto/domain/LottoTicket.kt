package lotto.domain

class LottoTicket(var numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또번호는 ${LOTTO_NUMBER_COUNT}개의 숫자입니다" }
    }
    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
