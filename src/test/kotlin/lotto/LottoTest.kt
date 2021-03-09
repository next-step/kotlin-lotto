package lotto

import org.junit.jupiter.api.Test
import kotlin.random.Random

class LottoTest {

    @Test
    fun `무작위 숫자 6개 만들기`() {
        val lotto = arrayListOf<Int>()
        repeat(6) {
            lotto.add(Random.nextInt(1, 45))
        }
        lotto.sort()
        println(lotto.toString())
    }

    @Test
    fun `중복 없이 무작위숫자 6개 만들기`() {
        val numbers = arrayListOf<Int>()
        var currentDigits = 0
        while (currentDigits < 6) {
            val randomNumber = Random.nextInt(1, 45)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
                currentDigits++
            }
        }
        numbers.sort()
        print(numbers.toString())
    }
}
