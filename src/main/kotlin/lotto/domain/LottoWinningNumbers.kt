package lotto.domain

data class LottoWinningNumbers(
    val numbers: LottoNumbers,
    val bonusNumber: Int,
) {
    init {
        require(bonusNumber !in numbers.numbers) { "보너스 번호와 로또 번호에 중복된 수가 있으면 안됩니다." }
        require(LottoNumbers.inValidRange(bonusNumber)) { "유효하지 않은 보너스 번호 입니다." }
    }

    companion object {
        fun generate(): LottoWinningNumbers {
            val randomNumbers = DuplicateFreeSequenceGenerator(
                from = LottoNumbers.MINIMUM,
                to = LottoNumbers.MAXIMUM,
                count = LottoNumbers.LENGTH + 1
            )
            return LottoWinningNumbers(
                LottoNumbers(
                    randomNumbers.take(6)
                        .toSet()
                ),
                randomNumbers.last()
            )
        }
    }
}
