package lotto.domain

class LottoTicket(var numbers: List<LottoNumber>) {
    init {
        require(numbers.size == 6) { "로또번호는 6개의 숫자입니다" }
    }
}
