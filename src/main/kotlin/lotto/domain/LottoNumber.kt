package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in (1..45)) {
            "numbers should be between 1 to 45: now is $number"
        }
    }

    companion object {
        fun randomNumbers(): List<LottoNumber> = (1..45).shuffled().take(6).sorted().map { LottoNumber(it) }
        fun manualNumbers(numbers: LottoNumbers) = numbers.numbers
    }
}
