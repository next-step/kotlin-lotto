package lotto.domain

class LottoTicket(
    val numbers: Set<LottoNumber>
) {

    init {
        require(numbers.size == 6)
    }
}
