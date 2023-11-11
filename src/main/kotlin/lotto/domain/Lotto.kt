package lotto.domain

class Lotto(val lottoNumbers: LottoNumbers) {
    fun match(winningNumbers: LottoNumbers): Int =
        lottoNumbers.match(winningNumbers)

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
