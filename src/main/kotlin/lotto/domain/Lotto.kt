package lotto.domain

class Lotto(val numbers: LottoNumbers) {
    constructor(numbers: List<Int>) : this(LottoNumbers(numbers))

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumber in numbers
    }
}
