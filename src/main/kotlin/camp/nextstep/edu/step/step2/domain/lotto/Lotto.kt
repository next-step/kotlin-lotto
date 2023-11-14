package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.generator.NumberGenerator
import camp.nextstep.edu.step.step2.generator.NumberGenerator.LOTTO_RANDOM

@JvmInline
value class Lotto(
    val numbers: List<Number>
) {

    fun getNumberElements(): List<Int> {
        return numbers.map { it.number }
    }

    fun countMatch(targetLotto: Lotto): Int {
        return numbers.count { targetLotto.getNumberElements().contains(it.number) }
    }

    companion object {

        fun ofInputValues(numbers: String): Lotto {
            val numberList = numbers.split(",")
                .map { it.trim() }
                .map { Number(number = it.toInt()) }
            return Lotto(numbers = numberList)
        }

        /**
         * @description : 로또 번호를 자동 생성한다.
         */
        fun generateAutoNumbers(): Lotto {
            val numbers = NumberGenerator.generate(LOTTO_RANDOM)

            val lottoNums = numbers.map { Number(number = it) }

            return Lotto(numbers = lottoNums)
        }
    }

}
