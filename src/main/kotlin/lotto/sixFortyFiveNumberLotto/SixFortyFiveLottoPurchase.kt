package lotto.sixFortyFiveNumberLotto

data class SixFortyFiveLottoPurchase(
    val type: SixFortyFiveLottoType,
    val numbers: List<SixFortyFiveNumber>,
) {
    companion object {
        fun ofAuto(numbers: List<SixFortyFiveNumber>): SixFortyFiveLottoPurchase {
            return SixFortyFiveLottoPurchase(SixFortyFiveLottoType.AUTO, numbers)
        }

        fun ofManual(numbers: List<SixFortyFiveNumber>): SixFortyFiveLottoPurchase {
            return SixFortyFiveLottoPurchase(SixFortyFiveLottoType.MANUAL, numbers)
        }
    }
}
