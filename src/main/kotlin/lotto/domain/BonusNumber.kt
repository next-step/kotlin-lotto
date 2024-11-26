package lotto.domain

class BonusNumber private constructor(val value: LottoNumber) {
    companion object {
        fun create(
            value: Int,
            winningLotto: Lotto,
        ): BonusNumber {
            val lottoNumber = LottoNumber.of(value)
            require(lottoNumber !in winningLotto.numbers) {
                "보너스 번호는 당첨 번호와 중복될 수 없습니다."
            }
            return BonusNumber(lottoNumber)
        }
    }
}
