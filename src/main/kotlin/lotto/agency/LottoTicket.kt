package lotto.agency

import lotto.agency.number.LottoNumber
import lotto.exception.AlreadySelectedNumberException
import lotto.exception.WonLottoNumberCountInconsistencyException

class LottoTicket(numbers: Set<Int>) {

    var numbers: Set<LottoNumber>
        private set
    lateinit var bonus: LottoNumber

    constructor(vararg numbers: Int) : this(numbers.toSet())

    init {
        validateLottoCount(numbers)
        this.numbers = numbers.map { LottoNumber.valueOf(it) }.toSet()
    }

    fun countMatchWonLottoTicket(wonLottoTicket: LottoTicket): Int {
        return numbers
            .map { lottoTicket -> lottoTicket.number }
            .sorted()
            .count { wonLottoTicket.numbers.map { wonLottoNumber -> wonLottoNumber.number }.contains(it) }
    }

    fun isMatchedBonus(bonus: LottoNumber): Boolean {
        return numbers.map { it.number }.contains(bonus.number)
    }

    private fun validateLottoCount(numbers: Set<Int>) {
        if (numbers.size != LOTTO_COUNT_POLICY) {
            throw WonLottoNumberCountInconsistencyException("로또 당첨 번호는 ${LOTTO_COUNT_POLICY}개를 입력해야합니다.")
        }

        if (numbers.map { it }.distinct().size != LOTTO_COUNT_POLICY) {
            throw AlreadySelectedNumberException("이미 선택된 번호가 있습니다.")
        }
    }

    companion object {
        const val LOTTO_COUNT_POLICY = 6
    }
}
