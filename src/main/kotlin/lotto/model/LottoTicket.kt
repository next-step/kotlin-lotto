package lotto.model

import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers

class LottoTicket(val lottoNumbers: LottoNumbers) {
    constructor(vararg lottoNumbers: Int) : this(LottoNumbers(lottoNumbers.toList()))

    constructor(generator: NumbersGenerator = RandomNumbersGenerator()) : this(
        LottoNumbers(generator.getNumbers(LottoNumber.MAXIMUM, LottoNumbers.CANDIDATE_SIZE))
    )

    fun isMatch(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.isMatch(lottoNumber)
    }

    fun countMatch(targetNumbers: LottoNumbers): Int {
        return lottoNumbers.countMatch(targetNumbers)
    }

    companion object {
        val PRICE = Money.THOUSAND
    }
}
