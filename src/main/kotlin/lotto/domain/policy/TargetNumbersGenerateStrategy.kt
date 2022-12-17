package lotto.domain.policy

import lotto.domain.vo.TargetNumber
import lotto.domain.vo.TargetNumbers
import kotlin.random.Random

sealed interface TargetNumbersGenerateStrategy {
    fun generate(): TargetNumbers
}

object TargetNumberAutoGenerateStrategy : TargetNumbersGenerateStrategy {

    override fun generate(): TargetNumbers {
        val targetNumbers = mutableSetOf<TargetNumber>()
        while(targetNumbers.size < TargetNumbers.TARGET_NUMBER_SIZE) { targetNumbers.add(generateRandomNumber()) }
        return TargetNumbers(targetNumbers = targetNumbers.toSet())
    }

    private fun generateRandomNumber(): TargetNumber {
        val randomValue = Random.nextInt(TargetNumber.MIN_NUMBER, TargetNumber.MAX_NUMBER)
        return TargetNumber(value = randomValue)
    }
}
