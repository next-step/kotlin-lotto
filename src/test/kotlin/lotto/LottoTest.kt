package lotto

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import kotlin.random.Random

class LottoTest {

    @Test
    fun `로또 1개 자동으로 만들기`() {
        val lotto = Lotto.generateAuto()
        lotto.getLottoNumbers().forEach {
            print("$it ")
        }
    }

    @Test
    fun `로또 1개 수동으로 만들기`() {
        val lotto = Lotto.generateManual(listOf(1, 2, 3, 4, 5, 6))
        lotto.getLottoNumbers().forEach {
            print("$it ")
        }
    }

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
