package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumbers

class LottoTicket(numbers: List<Int>) {

    val numbers = numbers.sorted()

    init {
        require(numbers.toSet().size == LottoNumbers.LOTTO_NUMBERS) { "로또 티켓은 서로 다른 ${LottoNumbers.LOTTO_NUMBERS}개의 숫자를 가질 수 있습니다. numbers=$numbers" }
        require(numbers.all { it in LottoNumbers.LOTTO_NUMBER_RANGE }) { "로또 번호는 ${LottoNumbers.LOTTO_NUMBER_RANGE.first}부터 ${LottoNumbers.LOTTO_NUMBER_RANGE.last}까지 발급 가능합니다." }
    }
}
