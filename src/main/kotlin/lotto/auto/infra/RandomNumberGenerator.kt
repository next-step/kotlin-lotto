package lotto.auto.infra

import lotto.auto.infra.port.NumberGenerator

class RandomNumberGenerator(private val minValue: Int, private val maxValue: Int) : NumberGenerator {

    override fun getNumber(): Int = (minValue..maxValue).random()
}
