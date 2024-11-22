package lotto.domain

class Lotto(setGenerator: SetGenerator = RandomSetGenerator()) {
    val numbers = setGenerator.getSet()

    fun isLotto(): Boolean {
        return numbers.all { it in (MINIMUM_NUMBER..MAXIMUM_NUMBER) }
    }

    companion object {
        const val NUMBER_OF_NUMBER = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
    }
}
