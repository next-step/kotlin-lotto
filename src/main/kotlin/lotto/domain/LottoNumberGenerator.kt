package lotto.domain

fun interface LottoNumberGenerator {
    fun getLottoNumbers(): List<Int>
}
