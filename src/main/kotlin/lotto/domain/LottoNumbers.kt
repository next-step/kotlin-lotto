package lotto.domain

data class LottoNumbers(
    val numbers: List<Int>
) {

    companion object {

        fun of(inputNumbers: String): LottoNumbers {
            return LottoNumbers(inputNumbers.split(",").map(String::toInt))
        }
    }
}
