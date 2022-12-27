package lotto.domain

class LottoTicket(
    val numbers: Set<LottoNumber>
): Set<LottoNumber> by numbers {

    init {
        require(numbers.size == 6) {
            "로또 숫자는 6개여야만 해요."
        }
    }
}
