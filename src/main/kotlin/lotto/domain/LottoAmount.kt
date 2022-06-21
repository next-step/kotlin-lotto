package lotto.domain

class LottoAmount(
    val amountOfAutoLotto: Int,
    val amountOfManualLotto: Int,
) {
    init {
        require(amountOfAutoLotto >= 0 && amountOfManualLotto >= 0) { "로또 갯수는 음수를 입력할 수 없습니다." }
    }

    companion object {
        fun createOf(
            amountOfTotalLotto: Int,
            amountOfManualLotto: Int,
        ) = LottoAmount(
            amountOfAutoLotto = amountOfTotalLotto - amountOfManualLotto,
            amountOfManualLotto = amountOfManualLotto,
        )
    }
}
