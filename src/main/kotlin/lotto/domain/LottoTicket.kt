package lotto.domain

class LottoTicket(val money: Money, val manualLotto: List<Lotto>, val autoLotto: List<Lotto>) {
    val lottos: List<Lotto> = manualLotto + autoLotto

    fun print() {
        println("수동으로 ${manualLotto.size}장, 자동으로 ${autoLotto.size}개를 구매했습니다.")
        lottos.forEach { it.print() }
    }
}
