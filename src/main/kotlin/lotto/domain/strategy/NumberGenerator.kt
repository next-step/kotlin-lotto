package lotto.domain.strategy

interface NumberGenerator {

    fun generate(size: Int): List<Int>
}
