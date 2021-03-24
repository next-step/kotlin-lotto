package lotto.view.input

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

data class ManualLottoInput(private val lottoNumbers: Set<LottoNumber>) : Set<LottoNumber> by lottoNumbers {
    init {
        require(lottoNumbers.size == LottoTicket.LOTTO_NUMBER_COUNT) { "로또 번호는 ${LottoTicket.LOTTO_NUMBER_COUNT} 개 여야 합니다." }
    }

    constructor(input: String) : this(
        input.split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("당첨번호는 숫자여야 합니다.") }
            .map { LottoNumber.from(it) }
            .toSet()
    )
}
