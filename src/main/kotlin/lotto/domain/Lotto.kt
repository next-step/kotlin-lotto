package lotto.domain

import lotto.util.LottoNumberGenerator
import lotto.util.RandomLottoNumberGenerator

class Lotto(val numbers: LottoNumbers, val isAutoPick: Boolean = false) {
    constructor(vararg numbers: Int) : this(LottoNumbers(*numbers))
    constructor(lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator) : this(lottoNumberGenerator.generate(), true)

    override fun toString(): String = numbers.toString()

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumber in numbers
    }
}
