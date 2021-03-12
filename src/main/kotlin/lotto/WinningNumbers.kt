package lotto

class WinningNumbers(private val winningNumbers: LottoNumbers, val bonusNumber: Int) {
    fun match(lottoNumbers: LottoNumbers): Match = Match(winningNumbers, lottoNumbers)
    fun matchBonus(lottoNumbers: LottoNumbers): Boolean = bonusNumber in lottoNumbers
}
