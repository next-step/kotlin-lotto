package lotto.domain

class Lotto private constructor(val numbers: LottoNumbers, val isAutoPick: Boolean) {

    override fun toString(): String = numbers.toString()

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumber in numbers
    }

    companion object {
        fun of(lottoNumbers: LottoNumbers, isAutoPick: Boolean = false): Lotto {
            return Lotto(lottoNumbers, isAutoPick)
        }
    }
}
