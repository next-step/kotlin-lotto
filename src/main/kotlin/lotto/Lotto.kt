package lotto

import kotlin.random.Random

class Lotto private constructor(private var numbers: List<Int>) {

    fun getLottoNumbers(): List<Int> {
        return numbers.toList()
    }

    companion object {
        private const val MAX_DIGITS = 6
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        fun generateAuto(): Lotto {
            val numbers: ArrayList<Int> = arrayListOf()
            var currentDigits = 0
            while (currentDigits < MAX_DIGITS) {
                val randomNumber = Random.nextInt(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                if (!checkDuplicateNumber(numbers, randomNumber)) {
                    numbers.add(randomNumber)
                    currentDigits++
                }
            }
            numbers.sort()
            return Lotto(numbers)
        }

        fun generateManual(numbers: List<Int>): Lotto {
            return Lotto(numbers.sorted())
        }

        private fun checkDuplicateNumber(numbers: List<Int>, randomNumber: Int): Boolean {
            return numbers.contains(randomNumber)
        }
    }
}
