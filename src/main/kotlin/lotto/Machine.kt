package lotto

import java.lang.Math.floor
import java.lang.Math.round
import kotlin.random.Random

class Machine(val purchasePrice: Int) {
    var lottoCount = 0
        private set

    var lottoList = emptyList<Lotto>()
        private set

    fun purchase() {
        lottoCount = purchasePrice / 1000
        lottoList = (1..lottoCount).toList().map { Lotto(makeRandomNumbers()) }
    }


    private fun makeRandomNumbers(): Set<Int> {
        val list = mutableListOf<Int>()
        while (list.size < 6) {
            val random = Random.nextInt(1, 45)
            if (!list.contains(random)) {
                list.add(random)
            }
        }
        return list.toSet()
    }


    fun statistics(winningValue: String, lottoList: List<Lotto>) {
        val confirmationList = lottoList.map { Confirmation(winningValue, it) }
        val third = confirmationList.filter { it.winningNumbers.size == 3 }
        val forth = confirmationList.filter { it.winningNumbers.size == 4 }
        val fifth = confirmationList.filter { it.winningNumbers.size == 5 }
        val sixth = confirmationList.filter { it.winningNumbers.size == 6 }
        val totalWinningPrice = third.sumOf { it.price } + forth.sumOf { it.price } + fifth.sumOf { it.price } + sixth.sumOf { it.price }
        println("3개 일치 (5000원)- ${third.size}개")
        println("4개 일치 (50000원)- ${forth.size}개")
        println("5개 일치 (1500000원)- ${fifth.size}개")
        println("6개 일치 (2000000000원)- ${sixth.size}개")
        println("총 수익률은 ${String.format("%.2f", totalWinningPrice.toDouble() / purchasePrice.toDouble())}입니다.")
    }
}
