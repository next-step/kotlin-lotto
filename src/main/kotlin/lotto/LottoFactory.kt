@file:JvmName("LottoFactory")

package lotto

fun generateLottoList(count: Int = 1, numberGenerator: NumberGenerator = RandomNumberGenerator()): List<Lotto> =
    List(count) {
        Lotto(
            numberGenerator.generateNumber(
                startNumber = Lotto.LOTTO_START_NUMBER,
                endNumber = Lotto.LOTTO_END_NUMBER,
                count = Lotto.LOTTO_NUMBER_SIZE
            )
        )
    }
