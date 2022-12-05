package lotto.domain

interface LottoGenerator {
    fun generateLottoFromNumbers(): Lotto

    fun generateLotto(lottoNumbers: String): Lotto
}
