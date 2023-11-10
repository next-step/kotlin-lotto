package lotto.domain

data class LottoNumbers(val numbers: List<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) })

    init {
        require(numbers.size == 6) {
            "number size must be 6"
        }

        require(numbers.distinct().size == 6) {
            "numbers should not contain duplicated number"
        }
    }

    companion object {
        fun random(): LottoNumbers {
            return LottoNumbers(LottoNumber.randomNumbers())
        }

        fun manual(manualNumbers: LottoNumbers): LottoNumbers {
            return LottoNumbers(LottoNumber.manualNumbers(manualNumbers))
        }
    }
}
