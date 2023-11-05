package lotto.domain

fun interface ShuffleNumber {
    fun shuffleNumber(numbers: List<LottoNumber>): List<LottoNumber>
}
