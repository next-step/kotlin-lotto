package lotto.model

data class WinningNumbers(val winningNumbers: LottoNumbers) : Set<LottoNumber> by winningNumbers {

    constructor(numbers: List<Int>) : this(LottoNumbers(numbers))
}
