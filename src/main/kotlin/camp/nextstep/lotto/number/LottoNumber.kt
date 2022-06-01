package camp.nextstep.lotto.number

data class LottoNumber(val value: Int) {

    companion object {
        private val LOTTO_NUMBERS = LottoNumbers.LOTTO_NUMBER_RANGE.associateWith { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            require(value in LottoNumbers.LOTTO_NUMBER_RANGE) { "로또 번호는 ${LottoNumbers.LOTTO_NUMBER_RANGE.first}에서 ${LottoNumbers.LOTTO_NUMBER_RANGE.last} 사이의 정수입니다." }

            return requireNotNull(LOTTO_NUMBERS[value])
        }
    }
}
