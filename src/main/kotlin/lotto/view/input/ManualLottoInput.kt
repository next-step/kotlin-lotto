package lotto.view.input

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

class ManualLottoInput(input: String?) {
    val lottoNumbers: Set<LottoNumber>

    init {
        require(!input.isNullOrBlank()) { "당첨 번호의 입력은 필수입니다. " }

        lottoNumbers = input.split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("당첨번호는 숫자여야 합니다.") }
            .map { LottoNumber.from(it) }
            .toSet()

        require(lottoNumbers.size == LottoTicket.LOTTO_NUMBER_COUNT) { "로또 번호는 ${LottoTicket.LOTTO_NUMBER_COUNT} 개 여야 합니다." }
    }
}
