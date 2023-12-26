package camp.nextstep.edu.step.step2.generator

import camp.nextstep.edu.step.step2.domain.number.Number

enum class NumberGenerator(
    val generate: (Int, Int) -> List<Int>
) {
    LOTTO_RANDOM({ startNum, endNum ->
        (startNum..endNum).shuffled().subList(0, 6).distinct().sorted()
    });


    companion object {
        fun generate(generator: NumberGenerator, startNumber: Int, endNumber: Int): List<Number> {
            return generator.generate(startNumber, endNumber).map { Number(it) }
        }
    }

}
