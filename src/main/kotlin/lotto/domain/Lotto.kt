package lotto.domain

import lotto.domain.numbers.LottoNumbers

class Lotto(val numbers: LottoNumbers = LottoNumbers()) {
    constructor(lottoNumbers: List<Int>) : this(LottoNumbers(lottoNumbers))
}
