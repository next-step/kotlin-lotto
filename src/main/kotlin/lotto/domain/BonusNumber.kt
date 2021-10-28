package lotto.domain

class BonusNumber {
    companion object {
        private const val RECEIVED_DUPLICATED_WITH_WINNING_NUMBERS = "당첨번호와 중복된 보너스 번호 입니다."

        fun from(input: String, lottoNumberPackage: LottoNumberPackage): LottoNumber {
            val bonusNumber = LottoNumber.from(input)
            require(!lottoNumberPackage.numbers.contains(bonusNumber)) { RECEIVED_DUPLICATED_WITH_WINNING_NUMBERS }
            return bonusNumber
        }
    }
}
