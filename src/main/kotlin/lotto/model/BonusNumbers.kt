package lotto.model

data class BonusNumbers(val bonusNumbers: Set<LottoNumber>) : Set<LottoNumber> by bonusNumbers {
    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber(it) }.toSet())
}
