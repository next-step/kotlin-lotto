package lotto

import io.kotest.matchers.longs.shouldBeGreaterThanOrEqual
import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

class NanoTimeCompareAsSequenceAndNoAsSequenceTest {

    @Test
    fun `시간 비교`() {
        val input = "1,2,3,4,5,6"

        val useAsSequenceNanoTime = measureNanoTime {
            input.split(",").asSequence()
                .map { it.trim().toIntOrNull() ?: 0 }
                .sorted()
                .toList()
        }

        val notUseAsSequenceNanoTime = measureNanoTime {
            input.split(",")
                .map { it.trim().toIntOrNull() ?: 0 }
                .sorted()
                .toList()
        }

        println("asSequence() 사용 : $useAsSequenceNanoTime")
        println("asSequence() 미사용 : $notUseAsSequenceNanoTime")

        useAsSequenceNanoTime shouldBeGreaterThanOrEqual notUseAsSequenceNanoTime
    }
}
