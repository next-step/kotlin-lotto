package lotto.domain

class Lotto(val numbers: LottoNumbers, val isAutoPick: Boolean = false) {
    constructor(vararg numbers: Int) : this(LottoNumbers(*numbers))

    override fun toString(): String = numbers.toString()

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumber in numbers
    }
}
