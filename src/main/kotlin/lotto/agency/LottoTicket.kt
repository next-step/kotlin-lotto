package lotto.agency

import lotto.exception.AlreadySelectedNumberException
import lotto.exception.WonLottoNumberCountInconsistencyException

class LottoTicket(numbers: List<LottoNumber>) {

    val numbers: List<LottoNumber>

    init {
        validateLottoCount(numbers)
        this.numbers = numbers
    }

    fun countMatchWonLottoTicket(wonLottoTicket: LottoTicket): Int {
        return numbers
            .map { lottoTicket -> lottoTicket.number }
            .sorted()
            .count { wonLottoTicket.numbers.map { wonLottoNumber -> wonLottoNumber.number }.contains(it) }
    }

    fun validateDuplicate(number: LottoNumber) {
        if (numbers.contains(number))
            throw AlreadySelectedNumberException("입력한 번호는 이미 선택된 번호입니다.")
    }

    private fun validateLottoCount(numbers: List<LottoNumber>) {
        if (numbers.size != LOTTO_COUNT_POLICY) {
            throw WonLottoNumberCountInconsistencyException("로또 당첨 번호는 ${LOTTO_COUNT_POLICY}개를 입력해야합니다.")
        }

        if (numbers.map { it.number }.distinct().size != LOTTO_COUNT_POLICY) {
            throw AlreadySelectedNumberException("이미 선택된 번호가 있습니다.")
        }
    }

    companion object {
        const val LOTTO_COUNT_POLICY = 6
    }
}
