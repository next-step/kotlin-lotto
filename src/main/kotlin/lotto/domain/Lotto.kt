package lotto.domain

class Lotto(
    val lottoNumbers: List<LottoNumber>
) {

    companion object {
        fun of(lottoNumbers: List<Int>): Lotto {
            return Lotto(lottoNumbers.map { LottoNumber(it) })
        }
    }
}
