package lotto.domain

class LotteryPaper(private val lottoNumbers: List<LottoNumber>) {

    init {
        validateLottoNumber(lottoNumbers)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as LotteryPaper
        return this.lottoNumbers == other.lottoNumbers
    }

    override fun hashCode(): Int {
        return this.lottoNumbers.hashCode()
    }

    fun getLottoNumbers(): List<LottoNumber> {
        return lottoNumbers.toList()
    }

    fun hasBonusNumber(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        const val NUMBER_OF_LOTTO_DRAWS = 6

        fun validateLottoNumber(lottoNumber: List<LottoNumber>) {
            validateNonDupulicatedLottoNumber(lottoNumber)
        }

        private fun validateNonDupulicatedLottoNumber(lottoNumber: List<LottoNumber>) {
            require(lottoNumber.toSet().size == lottoNumber.size) {
                "로또 숫자는 중복되면 안됩니다. 입력값을 다시 확인하세요."
            }
        }
    }
}
