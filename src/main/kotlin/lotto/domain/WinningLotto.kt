package lotto.domain

class WinningLotto(
    val winningNumbers: LottoNumbers
) {
    fun hasNumber(lottoNumber: LottoNumber): Boolean =
        winningNumbers.lottoNumbers.contains(lottoNumber)

    companion object {
        fun from(numbers: List<Int>): WinningLotto =
            WinningLotto(
                LottoNumbers.from(numbers)
            )
    }
}
