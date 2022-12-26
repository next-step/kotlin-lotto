package lotto.domain

class LottoTicket(
    val numbers: Set<LottoNumber>
) {

    init {
        require(numbers.size == 6) {
            "로또 숫자는 6개여야만 해요."
        }
    }
}
