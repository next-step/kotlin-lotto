package lotto.domain

data class WinningNumbers(val numbers: LottoNumbers, val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in numbers) { "보너스 번호와 당첨 번호는 중복이 불가능합니다." }
    }

    fun match(lottoNumbers: LottoNumbers): LottoMatchResult {
        val matchCount = lottoNumbers.match(numbers)
        val bonusMatch = bonusNumber in lottoNumbers
        return LottoMatchResult(matchCount, bonusMatch)
    }
}
