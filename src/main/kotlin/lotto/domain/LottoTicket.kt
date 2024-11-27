package lotto.domain

class LottoTicket {
    val lottoNumbers: List<Int>

    constructor() {
        this.lottoNumbers =
            (1..45).shuffled().take(6).sorted()
    }

    constructor(numbers: List<Int>) {
        this.lottoNumbers = numbers
        validateNumbers(this.lottoNumbers)
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return lottoNumbers.intersect(winningNumbers.toSet()).size
    }

    fun hasBonusNumber(bonusNumber: BonusNumber): Boolean {
        return lottoNumbers.contains(bonusNumber.number)
    }

    private fun validateNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE }
        require(numbers.all { it in 1..45 }) { LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE }
        require(numbers.toSet().size == 6) { LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다."
        const val LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45까지만 가능합니다."
        const val LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복되지 않아야 합니다."
    }
}
