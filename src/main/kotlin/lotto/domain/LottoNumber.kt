package lotto.domain

import java.util.stream.Collectors

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    operator fun compareTo(value: Int): Int {
        return this.value.compareTo(value)
    }

    companion object {
        private const val RECEIVED_DUPLICATED_WITH_WINNING_NUMBERS = "당첨번호와 중복된 보너스 번호 입니다."
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        private const val WRONG_LOTTO_NUMBER_MESSAGE = "잘못된 로또 번호 입니다.($MINIMUM_LOTTO_NUMBER~$MAXIMUM_LOTTO_NUMBER 입력})"

        private val numberPool = IntRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .map { LottoNumber(it) }
            .toList()

        operator fun get(index: Int): LottoNumber {
            require(index in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { WRONG_LOTTO_NUMBER_MESSAGE }
            return numberPool[index - 1]
        }

        fun from(input: String): LottoNumber {
            val value = input.toIntOrNull()
            require(value != null) { WRONG_LOTTO_NUMBER_MESSAGE }
            return numberPool[value - 1]
        }

        fun from(input: String, lottoNumberPackage: LottoNumberPackage): LottoNumber {
            val bonusNumber = LottoNumber.from(input)
            require(!lottoNumberPackage.numbers.contains(bonusNumber)) { RECEIVED_DUPLICATED_WITH_WINNING_NUMBERS }
            return bonusNumber
        }

        fun getShuffledLottoNumbers(): Set<LottoNumber> {
            return numberPool.shuffled()
                .stream()
                .limit(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT.toLong())
                .sorted(Comparator.comparing { it.value })
                .collect(Collectors.toSet())
        }
    }
}
