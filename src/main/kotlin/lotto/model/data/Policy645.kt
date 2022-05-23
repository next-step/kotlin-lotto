package lotto.model.data

class Policy645 : Policy {
    override val rangeOfNumbers = LottoNumberRange(1..45)
    override val countOfNumberToSelect = 6
    override val priceOfLotto = 1_000
    override val limitAmountToPurchase = 100_000

    override fun validateNumbers(numbers: Collection<LottoNumber>): IllegalArgumentException? {
        return super.validateNumbers(numbers.distinct()) // 번호 중복 불가
    }

    override fun validateWinningNumbers(numbers: Collection<LottoNumber>, bonusNumber: LottoNumber) =
        super.validateWinningNumbers(numbers, bonusNumber)
            ?: validateBonusNumber(numbers, bonusNumber)

    private fun validateBonusNumber(numbers: Collection<LottoNumber>, bonusNumber: LottoNumber) =
        if (bonusNumber in numbers) {
            IllegalArgumentException("보너스 번호는 로또 번호와 겹칠 수 없습니다.")
        } else {
            null
        }
}
