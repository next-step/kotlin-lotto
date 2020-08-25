package lotto.domain

object LottoGenerator {
    fun createAutoLottoList(countOfLotto: Int): List<Lotto> = (1..countOfLotto).map { Lotto.from() }
}
