package domain.winning

import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers

class WinningNumbers(val numbers: LottoNumbers, val bonus: LottoNumber) {
    init {
        require(numbers.toList().none { it == bonus })
    }
}
