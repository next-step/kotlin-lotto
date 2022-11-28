package lotto.domain

interface LottoGenerator {
    fun generateLottoFromNumbers(
        possibleNumbers: List<LottoNumber>
    ): Lotto

    fun generateLotto(lottoNumbers: String): Lotto
}
