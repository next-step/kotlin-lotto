package camp.nextstep.lotto.ticket

class LottoTicket(numbers: List<Int>) {

    val numbers = numbers.sorted()

    init {
        require(numbers.toSet().size == LOTTO_NUMBERS) { "로또 티켓은 서로 다른 ${LOTTO_NUMBERS}개의 숫자를 가질 수 있습니다. numbers=$numbers" }
        require(numbers.all { it in LOTTO_NUMBER_RANGE }) { "로또 번호는 ${LOTTO_NUMBER_RANGE.first}부터 ${LOTTO_NUMBER_RANGE.last}까지 발급 가능합니다." }
    }

    companion object {
        const val LOTTO_NUMBERS = 6
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
