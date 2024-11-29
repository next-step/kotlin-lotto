package lotto

class WinningNumbers(val lottoNumbers: LottoNumbers, val bonusNumber :LottoNumber) {
    fun matching(): Int {
        return lottoNumbers.countMatch(lottoNumbers)
    }

    fun bonusMatching(): Boolean {
        return bonusNumber in lottoNumbers.numbers
    }

}