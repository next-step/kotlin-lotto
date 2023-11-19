package lotto.controller

import lotto.component.Lotto
import lotto.model.LottoInput
import lotto.model.LottoResult

class LottoController(
    private val lotto: Lotto
) {
    fun run(input: LottoInput): LottoResult {
        return lotto.draw(input.lottoNumbers, input.winningNumbers)
    }
}
