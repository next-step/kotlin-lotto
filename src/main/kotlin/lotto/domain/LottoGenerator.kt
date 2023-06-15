package lotto.domain

import kotlin.random.Random

object LottoGenerator {
    fun generateLottos(amount: Int): List<Lotto> {
        require(amount > 0) { "금액은 음수일 수 없습니다" }
        return Array(amount / 1000) { generateLotto() }.toList()
    }

    fun generateLotto(): Lotto {
        val numberSet = sortedSetOf<Int>()
        while (numberSet.size != 6) {
            numberSet.add(Random.nextInt(45) + 1)
        }
        return Lotto(numberSet.toList())
    }
}
