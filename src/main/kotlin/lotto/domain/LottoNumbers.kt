package lotto.domain

data class LottoNumbers(val numbers: List<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.get(it) })

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
            val randomNumbers = LottoNumber.randomSixNumber().sortedBy { it.number }
            return LottoNumbers(randomNumbers)
        }

        fun manual(manualNumbers: LottoNumbers): LottoNumbers {
            return manualNumbers
        }
    }
}
