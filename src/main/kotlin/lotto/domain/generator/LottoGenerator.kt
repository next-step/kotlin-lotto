package lotto.domain.generator

interface LottoGenerator {

    fun execute(): List<Int>

    companion object {
        const val COUNT = 6
        const val MIN = 1
        const val MAX = 45
    }
}
