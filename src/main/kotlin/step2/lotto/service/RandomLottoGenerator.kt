package step2.lotto.service

import step2.lotto.domain.BuyAmount
import step2.lotto.domain.Lotto
import step2.lotto.domain.Lottos
import step2.lotto.service.LottoGenerator.Companion.LOTTO_SIZE
import step2.lotto.service.LottoGenerator.Companion.RANGE_END
import step2.lotto.service.LottoGenerator.Companion.RANGE_START

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
