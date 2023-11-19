package lotto

class Lotto(val lottoNumbers: Set<LottoNumber>) {
    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        const val SIZE = 6

        fun from(lottoNumbers: List<Int>): Lotto {
            return Lotto(lottoNumbers.map { LottoNumber.of(it) }.toSet())
        }
    }
}
