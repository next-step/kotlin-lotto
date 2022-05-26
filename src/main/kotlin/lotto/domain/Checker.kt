package lotto.domain

class Checker(private val lastNumbers: List<LottoNumber>) {
    fun match(lottos: List<LottoNumber>): Int =
        lottos.filter { it in lastNumbers }.size
}
