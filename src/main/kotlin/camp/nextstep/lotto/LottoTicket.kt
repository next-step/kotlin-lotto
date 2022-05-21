package camp.nextstep.lotto

private const val LOTTO_NUMBERS = 6

class LottoTicket(val numbers: List<Int>) {

    init {
        require(numbers.toSet().size == LOTTO_NUMBERS) { "로또 티켓은 서로 다른 6개의 숫자를 가질 수 있습니다. numbers=$numbers" }
    }
}
