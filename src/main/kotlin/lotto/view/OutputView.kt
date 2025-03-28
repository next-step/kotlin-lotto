package lotto.view

import lotto.domain.Lotto

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach {
            println("[${it.rawNumbers.joinToString(", ")}]")
        }
    }
}
