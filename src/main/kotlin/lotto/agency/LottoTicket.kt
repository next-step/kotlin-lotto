package lotto.agency

import lotto.exception.AlreadySelectedNumberException
import lotto.exception.WonLottoNumberCountInconsistencyException

class LottoTicket(numbers: List<LottoNumber>) {

    var numbers: List<LottoNumber>

    init {
        if (numbers.size != 6) {
            throw WonLottoNumberCountInconsistencyException("로또 당첨 번호는 6개를 입력해야합니다.")
        }

        this.numbers = numbers.toList()
    }

    fun checkDuplicate(number: Int) {
        if (numbers.contains(LottoNumber(number)))
            throw AlreadySelectedNumberException("이미 선택된 번호입니다.")
    }

    fun countMatchWonLottoTicket(wonLottoTicket: LottoTicket): Int {
        return numbers.map { it.number }
            .sorted()
            .count { wonLottoTicket.numbers.map { it.number }.contains(it) }
    }
}
