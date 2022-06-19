package lotto.domain

@JvmInline
value class LottoMoney private constructor(
    val money: Int
) {
    companion object {
        fun from(money: Int): LottoMoney {
            validateInputMoney(money)

            return LottoMoney(money)
        }

        private fun validateInputMoney(inputMoney: Int) {
            if (inputMoney < Lotto.PRICE) {
                throw IllegalArgumentException("최소 구입금액은 ${Lotto.PRICE}원 입니다.")
            }

            if (inputMoney % Lotto.PRICE != 0) {
                throw IllegalArgumentException("${Lotto.PRICE}원 단위로 구매하실 수 있습니다.")
            }
        }
    }
}
