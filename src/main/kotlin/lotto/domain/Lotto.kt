package lotto.domain

class Lotto constructor(
    val lottoNumbers: LottoNumbers,
) {
    companion object {
        fun autoCreate(): Lotto = Lotto(lottoNumbers = LottoNumbers.random())
    }
}
