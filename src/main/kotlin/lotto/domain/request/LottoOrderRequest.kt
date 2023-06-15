package lotto.domain.request

import lotto.domain.Lotto

data class LottoOrderRequest(
    val money: Long = 0,
    val manualCount: Int = 0,
    val manualNumbersList: List<List<String>> = emptyList()
) {

    val remainingMoney: Long = money
        get() = field - manualCount * Lotto.PRICE.value

    init {
        require(money >= Lotto.PRICE.value) {
            "돈은 ${Lotto.PRICE} 이상 이어야 합니다."
        }

        require(isPurchasableLotto(money, manualCount)) {
            "로또(수동)를 구매하기에 금액이 부족합니다."
        }

        validateLottoNumbersList(manualNumbersList)
    }

    private fun validateLottoNumbersList(target: List<List<String>>) =
        target.forEach {
            val filteredNumbers = it.map(String::trim).mapNotNull(String::toIntOrNull).toSet()

            require(filteredNumbers.size == Lotto.VALID_LENGTH) {
                "로또 번호는 중복되지 않는 6개의 번호여야 합니다. Input: $it"
            }
        }

    private fun isPurchasableLotto(money: Long, manualCount: Int): Boolean {
        val requiredPrice = Lotto.PRICE times manualCount.toLong()

        return money >= requiredPrice.value
    }
}
