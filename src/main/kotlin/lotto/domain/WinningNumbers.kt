package lotto.domain

data class WinningNumbers(val winningNumbers: LottoNumbers, val bonusNumber: LottoNumber) {
    init {
        require(!winningNumbers.numbers.contains(bonusNumber)) {
            "winning numbers should not contain bonus number!"
        }
    }
}
