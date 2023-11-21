package lotto.domain

fun interface LottoDispenser {

    fun issue(money: Int): List<Lotto>
}
