package camp.nextstep.edu.step.step2.generator

enum class NumberGenerator(
    val generate: () -> List<Int>
) {
    LOTTO_RANDOM({ (1..45).shuffled().subList(0, 6).distinct().sorted() });


    companion object {
        fun generate(generator: NumberGenerator): List<Int> {
            return generator.generate()
        }
    }

}
