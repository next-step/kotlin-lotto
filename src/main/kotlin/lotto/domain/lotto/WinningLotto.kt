package lotto.domain.lotto

import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers

class WinningLotto(
    private val winningNumbers: LottoNumbers
) {
    constructor(numbers: List<Int>) : this(
        LottoNumbers(numbers)
    )

    fun hasNumber(lottoNumber: LottoNumber): Boolean =
        winningNumbers.lottoNumbers.contains(lottoNumber)
}
