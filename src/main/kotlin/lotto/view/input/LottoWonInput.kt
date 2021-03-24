package lotto.view.input

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

data class LottoWonInput(private val wonNumbers: Set<LottoNumber>) : Set<LottoNumber> by wonNumbers {
    init {
        require(wonNumbers.size == LottoTicket.LOTTO_NUMBER_COUNT) { "로또 당첨번호는 ${LottoTicket.LOTTO_NUMBER_COUNT} 개 여야 합니다." }
    }

    constructor(wonNumbers: String) : this(
        wonNumbers.split(LOTTO_NUMBER_SPLITTER)
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("당첨번호는 숫자여야 합니다.") }
            .map { LottoNumber.from(it) }
            .toSet()
    )

    companion object {
        private const val LOTTO_NUMBER_SPLITTER = ","
    }
}
