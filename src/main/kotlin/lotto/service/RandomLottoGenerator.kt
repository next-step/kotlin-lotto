package lotto.service

import lotto.domain.BuyAmount
import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.service.LottoGenerator.Companion.LOTTO_SIZE
import lotto.service.LottoGenerator.Companion.RANGE_END
import lotto.service.LottoGenerator.Companion.RANGE_START

class RandomLottoGenerator : LottoGenerator {
    override fun generateSingleLotto(): Lotto {
        val randomNumbers = mutableSetOf<Int>()
        while (randomNumbers.size != LOTTO_SIZE) {
            randomNumbers.add((RANGE_START..RANGE_END).random())
        }
        return Lotto.of(randomNumbers)
    }

    override fun generate(buyAmount: BuyAmount): Lottos {
        val elements = mutableListOf<Lotto>()
        repeat(buyAmount.tryCount){
            elements.add(generateSingleLotto())
        }
        return Lottos.of(elements)
    }
}
