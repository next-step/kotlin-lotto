package lotto.data

class WinningNumbers(
    lottoNumbers: List<Int>,
    bonusNumber: Int
) {
    val lottoNumbers: LottoNumbers = LottoNumbers(lottoNumbers)
    val bonusNumber: LottoNumber = LottoNumber(bonusNumber)
}
