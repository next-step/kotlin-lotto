package lotto

class Lotto(val lottoNumbers: List<LottoNumber>) {
    companion object {
        const val SIZE = 6

        fun from(lottoNumbers: List<Int>): Lotto {
            return Lotto(lottoNumbers.map { LottoNumber(it) })
        }
    }

    fun contains(number: Int): Boolean {
        val lottoNumber = LottoNumber(number)
        return lottoNumbers.any { it == lottoNumber }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }
}
