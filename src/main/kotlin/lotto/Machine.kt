package lotto

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

    private fun winningPrice(confirmation: Confirmation): Int {
        return when (confirmation.winningNumbers.size) {
            3 -> 5000
            4 -> 50000
            5 -> 1500000
            6 -> 2000000000
            else -> 0
        }
    }

    fun statistics(winningValue: String, lottoList: List<Lotto>) {
        val confirmationList = lottoList.map { Confirmation(winningValue, it) }

        val third = confirmationList.filter { it.winningNumbers.size == 3 }.size
        val forth = confirmationList.filter { it.winningNumbers.size == 4 }.size
        val fifth = confirmationList.filter { it.winningNumbers.size == 5 }.size
        val sixth = confirmationList.filter { it.winningNumbers.size == 6 }.size

        println("3개 일치 (5000원)- ${third}개")
        println("4개 일치 (50000원)- ${forth}개")
        println("5개 일치 (1500000원)- ${fifth}개")
        println("6개 일치 (2000000000원)- ${sixth}개")
    }
}
