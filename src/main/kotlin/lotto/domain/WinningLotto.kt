package lotto.domain

import lotto.domain.dto.LottoMatchResult

class WinningLotto(numbers: List<Int>) : Lotto(numbers) {
    fun match(lottoList: List<Lotto>): LottoMatchResult {
        return LottoMatchResult(this, lottoList)
    }
}
