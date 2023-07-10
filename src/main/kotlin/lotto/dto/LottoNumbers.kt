package lotto.dto

import lotto.domain.LottoNumber

class LottoNumbers(numbers: List<Int>) {
    val lottoNumbers: List<LottoNumber> = numbers.map { LottoNumber(it) }
}
