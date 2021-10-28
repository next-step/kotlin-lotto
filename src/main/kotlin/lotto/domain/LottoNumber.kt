package lotto.domain

import java.util.stream.Collectors

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { WRONG_LOTTO_NUMBER_MESSAGE }
    }

    operator fun compareTo(value: Int): Int {
        return this.value.compareTo(value)
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        private const val WRONG_LOTTO_NUMBER_MESSAGE = "잘못된 로또 번호 입니다.($MINIMUM_LOTTO_NUMBER~$MAXIMUM_LOTTO_NUMBER 입력})"

        fun from(input: String): LottoNumber {
            val value = input.toIntOrNull()
            require(value != null) { WRONG_LOTTO_NUMBER_MESSAGE }
            return numberPool[value]
        }

        private val numberPool = IntRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .map { LottoNumber(it) }
            .toList()

        operator fun get(index: Int): LottoNumber = numberPool[index - 1]

        fun getShuffledLottoNumbers(): Set<LottoNumber> {
            return numberPool.shuffled()
                .stream()
                .limit(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT.toLong())
                .sorted(Comparator.comparing { it.value })
                .collect(Collectors.toSet())
        }
    }
}
